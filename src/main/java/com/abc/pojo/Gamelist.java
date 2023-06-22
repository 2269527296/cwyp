package com.abc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "gamelist")
public class Gamelist {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "gamename")
    private String gamename;
}