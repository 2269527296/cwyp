package com.abc.controller;

import com.abc.pojo.Gamelist;
import com.abc.pojo.Peiwandetail;
import com.abc.service.PeiwandetailService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("detail")
public class PeiwandetailController {
    @Autowired
    PeiwandetailService service;

    @RequestMapping(value = "query",produces="text/html;charset=UTF-8;" )
    public String query(){
        List<Peiwandetail> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }

    @RequestMapping("add")
    public String add(Peiwandetail peiwandetail){
        service.save(peiwandetail);
        return "1";
    }
}
