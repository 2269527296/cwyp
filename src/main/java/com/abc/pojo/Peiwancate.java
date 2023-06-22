package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "peiwancate")
public class Peiwancate {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "gamename")
    private String gamename;

    @TableField(value = "peiwanname")
    private String peiwanname;

    @TableField(value = "peiwanimage")
    private String peiwanimage;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "dizhi")
    private String dizhi;

    @TableField(value = "worktime")
    private String worktime;
}