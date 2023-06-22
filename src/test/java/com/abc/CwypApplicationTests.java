//package com.abc;
//
//import com.abc.dao.UserMapper;
//import com.abc.pojo.User;
//import com.abc.service.UserService;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import jdk.internal.util.xml.impl.Input;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import redis.clients.jedis.Jedis;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.*;
//
//import static org.apache.coyote.http11.Constants.a;
//
//@SpringBootTest
//class CwypApplicationTests {
//
//
//
//    @Test
//    void contextLoads() {
//        File file = new File("E:\\zhangsan.txt");
//        //先创建文件对象
//
////调用相应的方法，得到对应信息
//        System.out.println("文件名字=" + file.getName());
////getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
//        System.out.println("文件绝对路径=" + file.getAbsolutePath());
//        System.out.println("文件父级目录=" + file.getParent());
//        System.out.println("文件大小(字节)=" + file.length());
//        System.out.println("文件是否存在=" + file.exists());//T
//        System.out.println("是不是一个文件=" + file.isFile());//T
//        System.out.println("是不是一个目录=" + file.isDirectory());//
//    }
//
//    @Test
//    void contextLoads1() throws IOException {
//        Jedis jedis = new Jedis("192.168.10.100");
//        Set<String> keys = jedis.keys("*");
//        for (String key:keys){
//            String s = jedis.get(key);
//            System.out.println(key+":"+s);
//        }
//        jedis.close();
//    }
//
//    }
//
