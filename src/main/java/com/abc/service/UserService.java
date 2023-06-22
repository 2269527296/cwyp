package com.abc.service;

import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User>{


    User login(String username, String password);

    void add(String username, String password);

    void delete(String user_id);

    User getorderpassword(String user_id);

    void modify(Integer id, String newpassword);

    IPage<User> getPage(int currentPage, int pageSize, User user);

    boolean updatemodify(User user);

    List<User>  queryall();
}
