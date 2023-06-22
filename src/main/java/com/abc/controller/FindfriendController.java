package com.abc.controller;

import com.abc.controller.utils.R;
import com.abc.pojo.Findfriend;
import com.abc.pojo.User;
import com.abc.service.FindfriendService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("friend")
public class FindfriendController {
    @Autowired
    FindfriendService service;

    Findfriend findfriend = new Findfriend();

    @RequestMapping(value = "query",produces="text/html;charset=UTF-8;" )
    public String query(){
        List<Findfriend> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }




    @RequestMapping("add")
    public String add(@RequestParam(value = "name")String name,
                      @RequestParam(value = "gamename")String gamename,
                      @RequestParam(value = "server")String server,
                      @RequestParam(value = "message")String message){
        findfriend.setName(name);
        findfriend.setGamename(gamename);
        findfriend.setServer(server);
        findfriend.setMessage(message);
        service.save(findfriend);
        return "1";
    }


    @DeleteMapping("{id}")
    public R nihao(@PathVariable Integer id){
        return new R(service.removeById(id));
    }



    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, String name,String gamename){
        IPage<Findfriend> page = service.getPage(currentPage,pageSize, name,gamename);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,name,gamename);
        }
        return new R(true,page);
    }
}
