package com.abc.controller;

import com.abc.pojo.Homerightimg;
import com.abc.service.HomerightimgService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
public class HomerightController {
    @Autowired
    HomerightimgService service;

    Homerightimg homerightimg = new Homerightimg();

    @RequestMapping(value = "/right/query",produces="text/html;charset=UTF-8;")
    public String query(){
        List<Homerightimg> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }


    @RequestMapping("/rightUpload")
    public String upload(MultipartFile[] imgFile,String peiwanname, HttpServletRequest request) throws Exception {

        String path = request.getSession().getServletContext().getRealPath("");
        String pathsrc1 = path.replace("C:\\Users\\WZX\\AppData\\Local\\Temp","D:\\springbootnativefile\\upload");
        String pathsrc = pathsrc1.substring(0,30);

        File file = new File(pathsrc);
        if (!file.exists()){
            // 创建目录或子目录
            file.mkdirs();
        }
        String fileName =  imgFile[0].getOriginalFilename();
        imgFile[0].transferTo(new File(file,fileName));
        String fileName1 = imgFile[1].getOriginalFilename();
        imgFile[1].transferTo(new File(file,fileName1));
        String fileName2 = imgFile[2].getOriginalFilename();
        imgFile[2].transferTo(new File(file,fileName2));
        String fileName3 = imgFile[3].getOriginalFilename();
        imgFile[3].transferTo(new File(file,fileName3));
        homerightimg.setLeftcenter("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
        homerightimg.setRightcenter("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName1);
        homerightimg.setLeftshowdown("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName2);
        homerightimg.setRightshowdown("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName3);
        homerightimg.setPeiwanname(peiwanname);
        service.save(homerightimg);
        return "success";
//        String str[] = {"http://localhost:8080/imgs"+"/"+fileName,"http://localhost:8080/imgs"+"/"+fileName,
//              "http://localhost:8080/imgs"+"/"+fileName2,"http://localhost:8080/imgs"+"/"+fileName3};
//        List list = new ArrayList<String>(Arrays.asList(str));
//        String json = JSONObject.toJSONString(list);





    }
}
