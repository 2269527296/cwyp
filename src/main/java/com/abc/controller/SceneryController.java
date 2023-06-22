package com.abc.controller;

import com.abc.controller.utils.R;
import com.abc.pojo.Scenery;
import com.abc.pojo.Shoppingfood;
import com.abc.pojo.User;
import com.abc.service.SceneryService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
public class SceneryController {
    private Integer a;

    @Autowired
    SceneryService service;

    Scenery sc = new Scenery();


    @RequestMapping(value = "/scenery/query",produces="text/html;charset=UTF-8;" )
    public String query(){
        List<Scenery> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }

    @GetMapping("scenery/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, String sceneryimg){
        IPage<Scenery> page = service.getPage(currentPage,pageSize,sceneryimg);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,sceneryimg);
        }
        return new R(true,page);
    }


    @DeleteMapping("scenery/{id}")
    public R nihao(@PathVariable Integer id){
        return new R(service.removeById(id));
    }

    @GetMapping("scenery/{id}")
    public R query(@PathVariable Integer id){
        this.a = id;
        return new R(true,service.getById(id));
    }


    @RequestMapping("scenery/sceneryUpload")
    public R upload(MultipartFile imgFile,
                         HttpServletRequest request, String a, HttpServletResponse response) throws Exception {

        //1. 获取上传的目录路径
        // D:/classes/IdeaProjects2019/springmvc02/target/springmvc02-1.0-SNAPSHOT/upload
        String path = request.getSession().getServletContext().getRealPath("");
        String pathsrc1 = path.replace("C:\\Users\\WZX\\AppData\\Local\\Temp","D:\\springbootnativefile\\upload");
        String pathsrc = pathsrc1.substring(0,30);
        //2. 以天为单位，一天创建一个文件夹，保存当天上传的文件
//        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //3. 创建目录
        File file = new File(pathsrc);
        if (!file.exists()){
            // 创建目录或子目录
            file.mkdirs();
        }
        //4. 文件上传
        //4.1 获取原始文件名
        String fileName = imgFile.getOriginalFilename();
        sc.setSceneryimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
        if((a==null&&!(fileName.equals("")))){
            service.save(sc);
        }
        if(fileName.equals("")==false){
            sc.setId(this.a);
            sc.setSceneryimg("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
            service.modify(sc);
        }
        if (!(fileName.equals(""))) {
            imgFile.transferTo(new File(file, fileName));
        }
        response.sendRedirect(request.getContextPath()+"/pages/viewmanage.html");
        return new R(true);
    }

}
