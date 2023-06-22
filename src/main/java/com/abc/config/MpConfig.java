package com.abc.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {

    @Bean

    public MybatisPlusInterceptor  MybatisPlusInterceptor(){
        //mybatis-plus的拦截器接口
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        专门用来做分页的接口
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
