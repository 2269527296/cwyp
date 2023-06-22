package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "navigationsrc")
public class Navigationsrc {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "navigationimg")
    private String navigationimg;

    @TableField(value = "textsrc")
    private String textsrc;

    @TableField(value = "cid")
    private Integer cid;
}