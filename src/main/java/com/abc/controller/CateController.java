package com.abc.controller;

import com.abc.controller.utils.R;
import com.abc.pojo.Navigationsrc;
import com.abc.pojo.Peiwancate;
import com.abc.pojo.User;
import com.abc.service.PeiwancateService;
import com.alibaba.fastjson.JSONArray;
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
public class CateController {
    private    Integer a;
    @Autowired
    PeiwancateService service;
    Peiwancate peiwancate = new Peiwancate();


    @DeleteMapping("peiwan/{id}")
    public R nihao(@PathVariable Integer id){
        return new R(service.removeById(id));
    }


    @GetMapping("peiwan/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, String gamename,String peiwanname){
        System.out.println(gamename);
        System.out.println(peiwanname);
        IPage<Peiwancate> page = service.getPage(currentPage,pageSize,gamename,peiwanname);
//        如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage>page.getPages()){
            page = service.getPage((int)page.getPages(),pageSize,gamename,peiwanname);
        }
        return new R(true,page);
    }

    @GetMapping("peiwan/{id}")
    public R query(@PathVariable Integer id){
        this.a = id;
        Peiwancate peiwan =  service.getOne(new QueryWrapper<Peiwancate>().eq("id",id));
        return new R(true,peiwan);
    }

    @RequestMapping(value = "/cate/query",produces="text/html;charset=UTF-8;" )
    public String query(){
        List<Peiwancate> list = service.list();
        String json = JSONObject.toJSONString(list);
        return json;
    }


    @RequestMapping(value = "/limit/query" ,produces="text/html;charset=UTF-8;")
    public String limitquery(@RequestParam(value = "peiwanname",required = false)String peiwanname){
        QueryWrapper<Peiwancate> wrapper = new QueryWrapper<>();
        wrapper.select("id","gamename","peiwanname","phone","peiwanimage","dizhi","worktime").like("peiwanname",peiwanname);
        List<Peiwancate>list = service.list(wrapper);
        String json = JSONArray.toJSONString(list);
        return json;
    }


    @RequestMapping("/peiwan/cateUpload")
    public R upload(@RequestParam(value = "imgFile",required = false)MultipartFile imgFile, String gamename, String
            peiwanname , String dizhi, String phone, String worktime
                        , HttpServletResponse response, String a,HttpServletRequest request) throws Exception {

            String fileName = imgFile.getOriginalFilename();
            // 指定存储路径
            String filePath = "D:/springbootnativefile/upload/"+fileName;
            if (fileName.equals("")&&a==null){
                response.sendRedirect(request.getContextPath()+"/pages/peiwanmanage.html");
            }
            if (fileName.equals("")&&a!=null){
                Peiwancate p = new Peiwancate();
                p.setWorktime(worktime);
                p.setPhone(phone);
                p.setDizhi(dizhi);
                p.setPeiwanname(peiwanname);
                p.setGamename(gamename);
                p.setId(this.a);
                Peiwancate peiwan =  service.getOne(new QueryWrapper<Peiwancate>().eq("id",this.a));
                p.setPeiwanimage(peiwan.getPeiwanimage());
                service.modify(p);
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
                Peiwancate p = new Peiwancate();
                p.setWorktime(worktime);
                p.setPhone(phone);
                p.setDizhi(dizhi);
                p.setPeiwanname(peiwanname);
                p.setGamename(gamename);
                p.setPeiwanimage("http://wzxcwyp.mynatapp.cc/imgs/upload"+"/"+fileName);

                if((a==null&&!(fileName.equals("")))){
                    service.save(p);
                }
                if(fileName.equals("")==false){
                    p.setId(this.a);
                    service.modify(p);
                }
            }

        response.sendRedirect(request.getContextPath()+"/pages/peiwanmanage.html");
        return new R(true,"成功");
    }

}
