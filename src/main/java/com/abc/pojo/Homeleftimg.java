package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "homeleftimg")
public class Homeleftimg {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "lefrimg")
    private String lefrimg;

    @TableField(value = "topimg")
    private String topimg;

    @TableField(value = "rightimg")
    private String rightimg;
}