package com.abc.inter.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInter implements HandlerInterceptor {
    //主要逻辑：在handler之前执行：抽取handler中的冗余代码 主要用于登陆 权限验证 主要写个演示一下
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        //获取session里面的登陆信息，后续 根据需要可以写cookie或者其他
//        System.out.println("============当前路径："+request.getRequestURI()+"============================");
        if (session.getAttribute("newlogin") == null) {
            //设置一下编码格式 服务器是ios8859-1 浏览器是utf-8 需要把服务器改过来。
            response.setContentType("text/html;charset=utf-8");
            //设置一下如果没有登陆信息需要打开的页面，这个页面一定是放行的
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;    //中断请求 结束mcv里面的其他操作 一定要写
        } else {
            return true; //放行，后续的拦截器或handler就会执行
        }
    }

    //在handler之后执行:进一步的响应定制  注意是handler之后
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }
    //在页面渲染完毕之后，执行：资源回收
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}