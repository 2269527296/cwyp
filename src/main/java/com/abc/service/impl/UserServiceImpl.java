package com.abc.service.impl;

import com.abc.dao.UserMapper;
import com.abc.pojo.User;
import com.abc.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{

    @Autowired
    UserMapper dao;

    @Override
    public User login(String username, String password) {
        return dao.login(username,password);
    }

    @Override
    public void add(String username, String password) {
        dao.add(username,password);
    }

    @Override
    public void delete(String user_id) {
        dao.delete(user_id);
    }

    @Override
    public User getorderpassword(String user_id) {
        return dao.getorderpassword(user_id);
    }

    @Override
    public void modify(Integer id, String newpassword) {
        dao.modify(id,newpassword);
    }



    @Cacheable(value = "queryall")
//@CacheEvict(value="common")
    public List<User> queryall(){
       return dao.selectList(null);
    }


    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> lwq = new LambdaQueryWrapper<User>();
        lwq.like(Strings.isNotEmpty(user.getName()),User::getName,user.getName());
        lwq.like(Strings.isNotEmpty(user.getPassword()),User::getPassword,user.getPassword());


        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }


    @Override
    public boolean updatemodify(User user) {
        return dao.updateById(user) >0;
    }
}
