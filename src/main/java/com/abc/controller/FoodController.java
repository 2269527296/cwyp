package com.abc.controller;

import com.abc.controller.utils.R;
import com.abc.pojo.Peiwancate;
import com.abc.pojo.Shoppingfood;
import com.abc.service.ShoppingfoodService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class FoodController {
    private    Integer a;

    @Autowired
    ShoppingfoodService service;
    Shoppingfood food = new Shoppingfood();

    @RequestMapping(value = "/food/query",produces="text/html;charset=UTF-8;" )
    public String query(){
        List<Shoppingfood> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }


    @GetMapping("food/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, String textsrc, String dizhi){
        IPage<Shoppingfood> page = service.getPage(currentPage,pageSize,textsrc,dizhi);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,textsrc,dizhi);
        }
        return new R(true,page);
    }

    @DeleteMapping("food/{id}")
    public R nihao(@PathVariable Integer id){
        return new R(service.removeById(id));
    }


//    @GetMapping("food/{id}")
//    public R query(@PathVariable Integer id){
//        this.a = id;
//        Shoppingfood food =  service.getOne(new QueryWrapper<Shoppingfood>().eq("id",id));
//        return new R(true,food);
//    }

    @RequestMapping("food/getone")
       public R query(Integer id){
        this.a = id;
       Shoppingfood food =  service.getOne(new QueryWrapper<Shoppingfood>().eq("id",id));
       return new R(true,food);
    }

    @RequestMapping("food/foodUpload")
    public R upload(MultipartFile imgFile, String textsrc, String
            dizhi , String time, String introduce,
                         HttpServletRequest request, String a, HttpServletResponse response) throws Exception {
        String fileName = imgFile.getOriginalFilename();
        // 指定存储路径
        String filePath = "D:/springbootnativefile/upload/"+fileName;
        if (fileName.equals("")&&a==null){
            response.sendRedirect(request.getContextPath()+"/pages/foodmanage.html");
        }
        if (fileName.equals("")&&a!=null){
            Shoppingfood food = new Shoppingfood();
            food.setTextsrc(textsrc);
            food.setTime(time);
            food.setDizhi(dizhi);
            food.setIntroduce(introduce);
            food.setId(this.a);
            Shoppingfood f =  service.getOne(new QueryWrapper<Shoppingfood>().eq("id",this.a));
            food.setImgsrc(f.getImgsrc());
            service.modify(food);
        }
        else {
            File dest = new File(filePath);
            try {
                // 保存文件
                imgFile.transferTo(dest);
            }catch (IOException e) {
                e.toString();
                return new R(true,"失败");
            }
            Shoppingfood shoppingfood = new Shoppingfood();
            shoppingfood.setTextsrc(textsrc);
            shoppingfood.setIntroduce(introduce);
            shoppingfood.setDizhi(dizhi);
            shoppingfood.setTime(time);
            shoppingfood.setImgsrc("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);

            if((a==null&&!(fileName.equals("")))){
                service.save(shoppingfood);
            }
            if(fileName.equals("")==false){
                shoppingfood.setId(this.a);
                service.modify(shoppingfood);
            }
        }

        response.sendRedirect(request.getContextPath()+"/pages/foodmanage.html");
        return new R(true,"成功");
    }
}
