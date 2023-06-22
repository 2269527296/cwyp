package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "knowpeiwan")
public class Knowpeiwan {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "know")
    private String know;

    @TableField(value = "centerimg")
    private String centerimg;

    @TableField(value = "leftimg")
    private String leftimg;

    @TableField(value = "topimg")
    private String topimg;
}