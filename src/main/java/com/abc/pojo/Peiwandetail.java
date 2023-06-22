package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "peiwandetail")
public class Peiwandetail {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "peiwanname")
    private String peiwanname;

    @TableField(value = "peiwanprice")
    private String peiwanprice;

    @TableField(value = "peiwanintroduce")
    private String peiwanintroduce;
}