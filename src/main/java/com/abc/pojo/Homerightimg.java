package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "homerightimg")
public class Homerightimg {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "leftcenter")
    private String leftcenter;

    @TableField(value = "rightcenter")
    private String rightcenter;

    @TableField(value = "leftshowdown")
    private String leftshowdown;

    @TableField(value = "rightshowdown")
    private String rightshowdown;

    @TableField(value = "peiwanname")
    private String peiwanname;






}