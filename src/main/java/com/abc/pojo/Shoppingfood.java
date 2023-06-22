package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "shoppingfood")
public class Shoppingfood {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "imgsrc")
    private String imgsrc;

    @TableField(value = "textsrc")
    private String textsrc;

    @TableField(value = "dizhi")
    private String dizhi;

    @TableField(value = "time")
    private String time;

    @TableField(value = "introduce")
    private String introduce;
}