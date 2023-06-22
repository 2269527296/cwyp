package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "imgabc")
public class Imgabc {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "imagesrc")
    private String imagesrc;

    @TableField(value = "imgsrc")
    private String imgsrc;
}