package com.abc.controller;

import com.abc.pojo.Imgabc;
import com.abc.pojo.Navigationsrc;
import com.abc.service.NavigationsrcService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
public class HomeNavigationController {
    @Autowired
    NavigationsrcService service;
    Navigationsrc navi = new Navigationsrc();

    @RequestMapping(value = "/nav/query",produces="text/html;charset=UTF-8;" )
    public String query(){
        List<Navigationsrc> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }

    @RequestMapping("/naviUpload")
    public String upload(MultipartFile imgFile, String textsrc,String
            cid ,HttpServletRequest request) throws Exception {

        String path = request.getSession().getServletContext().getRealPath("");
        String pathsrc1 = path.replace("C:\\Users\\WZX\\AppData\\Local\\Temp","D:\\springbootnativefile\\upload");
        String pathsrc = pathsrc1.substring(0,30);
        System.out.println(pathsrc);
        File file = new File(pathsrc);

        if (!file.exists()){
            file.mkdirs();
        }
        String fileName = imgFile.getOriginalFilename();

        navi.setNavigationimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
        navi.setCid(Integer.valueOf(cid));
        navi.setTextsrc(textsrc);
        service.save(navi);

        imgFile.transferTo(new File(file,fileName));
        return "success";
    }
}
