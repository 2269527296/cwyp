package com.abc.controller;

import com.abc.controller.utils.R;
import com.abc.pojo.User;
import com.abc.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;



    @RequestMapping("login")
    public String login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password,
                        HttpServletRequest request
    ){

        System.out.println(username);
        User u = service.login(username,password);
        if (u==null){
            return "0";
        }else {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
//            request.getSession().setAttribute("newlogin",user);
            return "1";
        }
    }

    @RequestMapping("add")
    public String add(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password
    ){
        User u = service.getOne(new QueryWrapper<User>().eq("name",username));
        if(u!=null){
            return "0";
        }
        else{
            service.add(username,password);
            return "1";
        }
    }

    @RequestMapping("del")
    public String del(@RequestParam(value = "user_id") String user_id){
        service.delete(user_id);
        return "1";
    }

    @RequestMapping("update")
    public String update(@RequestParam(value = "user_id") String user_id,
                         @RequestParam(value = "newpassword") String newpassword){
        User u = service.getorderpassword(user_id);
        service.modify(u.getId(),newpassword);
        return "1";
    }


//    ==========================================================================================================


    @DeleteMapping("{id}")
    public R nihao(@PathVariable Integer id){
        return new R(service.removeById(id));
    }

    @PostMapping
    public R add(@RequestBody User user) throws IOException {
        if (user.getName().equals("123")) throw new IOException();
        boolean flag = service.save(user);
        return new R(flag,flag?"添加成功^_^":"添加失败-_-!");
    }

    @GetMapping("{id}")
    public R query(@PathVariable Integer id){
        return new R(true,service.getById(id));
    }

    @PutMapping
    public R modify(@RequestBody User user){
        return new R(service.updatemodify(user));
    }

    //    @RequestMapping("page")
//    public IPage<User> getPage(@RequestParam(value = "currentPage",required = false)Integer currentPage,
//                               @RequestParam(value = "pageSize",required = false)Integer pageSize){
//        return service.getPage(currentPage,pageSize);
//    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,User user){
        IPage<User> page = service.getPage(currentPage,pageSize, user);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,user);
        }
        return new R(true,page);
    }
}
