package com.abc.dao;

import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User login(@Param("username") String username, @Param("password") String password);

    void add(@Param("username")String username,@Param("password")String password);

    void delete(@Param("user_id") String user_id);

    User getorderpassword(@Param("user_id") String user_id);

    void modify(@Param("id") Integer id, @Param("newpassword") String newpassword);
}