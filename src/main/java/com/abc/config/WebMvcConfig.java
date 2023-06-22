//package com.abc.config;
//
//
//import com.abc.inter.interceptor.MyInter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * Web MVC 配置类
// * @author pan_junbiao
// **/
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer
//{
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry)
//    {
//        //注册Interceptor拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new MyInter());
//        registration.addPathPatterns("/**"); //所有路径都被拦截
//        registration.excludePathPatterns( //添加不拦截路径
//                "/user/login",       //登录请求
//                "/older/**", //登录页面
//                "/plugins/**",
//                "/login.html",   //html静态资源
//                "/js/**",     //js静态资源
//                "/css/**",     //css静态资源
//                "/imgs/upload/**"
//        );
//    }
//}