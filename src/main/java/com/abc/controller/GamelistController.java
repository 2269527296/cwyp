package com.abc.controller;

import com.abc.pojo.Gamelist;
import com.abc.pojo.Peiwancate;
import com.abc.service.GamelistService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamelistController {
    @Autowired
    GamelistService service;

    @RequestMapping(value = "/gamelist/query",produces="text/html;charset=UTF-8;" )
    public String query(){
        List<Gamelist> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }
}
