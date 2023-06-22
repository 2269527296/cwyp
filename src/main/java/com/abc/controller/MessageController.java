package com.abc.controller;

import com.abc.controller.utils.R;
import com.abc.pojo.Message;
import com.abc.pojo.User;
import com.abc.service.MessageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    MessageService service;

    Message message = new Message();


    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, String username,String infomation){
        IPage<User> page = service.getPage(currentPage,pageSize, username,infomation);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,username,infomation);
        }
        return new R(true,page);
    }

    @DeleteMapping("{id}")
    public R nihao(@PathVariable Integer id){
        return new R(service.removeById(id));
    }

    @RequestMapping("add")
    public String add(@Param("user_id")String user_id,@Param("infomation")String infomation){
        message.setUsername(user_id);
        message.setInfomation(infomation);
        service.save(message);
        return "1";
    }




}
