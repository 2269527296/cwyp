package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "scenery")
public class Scenery {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "sceneryimg")
    private String sceneryimg;
}