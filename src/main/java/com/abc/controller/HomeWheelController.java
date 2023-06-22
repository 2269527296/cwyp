package com.abc.controller;


import com.abc.controller.utils.R;
import com.abc.pojo.Imgabc;
import com.abc.pojo.Peiwancate;
import com.abc.pojo.User;
import com.abc.service.ImgabcService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * 2. SpringMVC提供的文件上传
 */
@RestController
//@RequestMapping("imgabc")
public class HomeWheelController {

    private    Integer a;

    @Autowired
    ImgabcService service;
    Imgabc imgabc = new Imgabc();


    @GetMapping("imgabc/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,String picture){
        IPage<User> page = service.getPage(currentPage,pageSize, picture);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,picture);
        }
        return new R(true,page);
    }


    @DeleteMapping("imgabc/{id}")
    public R nihao(@PathVariable Integer id){
        return new R(service.removeById(id));
    }

    @GetMapping("imgabc/{id}")
    public R query(@PathVariable Integer id){
        this.a = id;
        return new R(true,service.getById(id));
    }




    @RequestMapping("/img/query")
    public String query(){
        List<Imgabc> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }

    /**
     * SpringMVC文件上传
     * 1. 控制器方法通过MultipartFile获取整个上传的文件。
     * 2. 参数名称upload(MultipartFile imgFile..) 中的imgFile一定要与页面的文件域的表单元素名称一致.
     *    <input type="file" name="imgFile">
     */
    @RequestMapping("imgabc/fileUpload")
    public R upload(MultipartFile imgFile,HttpServletRequest request,String a,
                       HttpServletResponse response) throws Exception {
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
        imgabc.setImagesrc("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
        imgabc.setImgsrc("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
            if((a==null&&!(fileName.equals("")))){
                    service.save(imgabc);
            }
            if(fileName.equals("")==false){
                imgabc.setId(this.a);
                imgabc.setImagesrc("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
                imgabc.setImgsrc("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);
                service.modify(imgabc);
            }
            if (!(fileName.equals(""))) {
                imgFile.transferTo(new File(file, fileName));
            }
        response.sendRedirect(request.getContextPath()+"/pages/lunbomanage.html");
         return new R(true);
    }
}
