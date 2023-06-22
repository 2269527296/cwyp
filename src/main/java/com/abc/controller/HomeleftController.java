package com.abc.controller;

import com.abc.pojo.Homeleftimg;
import com.abc.pojo.Peiwancate;
import com.abc.service.HomeleftimgService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class HomeleftController {
    @Autowired
    HomeleftimgService service;
    Homeleftimg homeleftimg = new Homeleftimg();

    @RequestMapping(value = "/left/query",produces="text/html;charset=UTF-8;")
        public String query(){
            List<Homeleftimg> list = service.list();
            String json = JSONObject.toJSONString(list);
            return json;
    }

    @RequestMapping("/leftUpload")
    public String upload(MultipartFile[] imgFile, HttpServletRequest request) throws Exception {

        String path = request.getSession().getServletContext().getRealPath("");
        String pathsrc1 = path.replace("C:\\Users\\WZX\\AppData\\Local\\Temp","D:\\springbootnativefile\\upload");
        String pathsrc = pathsrc1.substring(0,30);

        File file = new File(pathsrc);
        if (!file.exists()){
            // 创建目录或子目录
            file.mkdirs();
        }
        String fileName = imgFile[0].getOriginalFilename();
        imgFile[0].transferTo(new File(file,fileName));
        String fileName1 = imgFile[1].getOriginalFilename();
        imgFile[1].transferTo(new File(file,fileName1));
        String fileName2 = imgFile[2].getOriginalFilename();
        imgFile[2].transferTo(new File(file,fileName2));
        homeleftimg.setLefrimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
        homeleftimg.setTopimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName1);
        homeleftimg.setRightimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName2);
        service.save(homeleftimg);
        return "success";
    }

}
