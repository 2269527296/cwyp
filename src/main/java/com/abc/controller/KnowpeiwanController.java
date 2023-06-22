package com.abc.controller;

import com.abc.controller.utils.R;
import com.abc.pojo.Homeleftimg;
import com.abc.pojo.Knowpeiwan;
import com.abc.pojo.Peiwancate;
import com.abc.service.KnowpeiwanService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
public class KnowpeiwanController {
    @Autowired
    KnowpeiwanService service;
    Knowpeiwan knowpeiwan = new Knowpeiwan();

    @RequestMapping(value = "/know/query",produces="text/html;charset=UTF-8;")
    public String query(){
        List<Knowpeiwan> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }


    @GetMapping("know/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, String know){
        IPage<Knowpeiwan> page = service.getPage(currentPage,pageSize,know);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,know);
        }
        return new R(true,page);
    }

    @RequestMapping("/knowUpload")
    public String upload(MultipartFile[] imgFile, HttpServletRequest request,String know) throws Exception {

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
        knowpeiwan.setLeftimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
        knowpeiwan.setTopimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName1);
        knowpeiwan.setCenterimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName2);
        knowpeiwan.setKnow(know);
        service.save(knowpeiwan);
        return "success";
    }
}
