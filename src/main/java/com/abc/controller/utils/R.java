package com.abc.controller.utils;

import lombok.Data;

@Data
public class R {
    private boolean flag;
    private Object data;
    private String msg;

    public R(){

    }
    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }

    public R(boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }
}
