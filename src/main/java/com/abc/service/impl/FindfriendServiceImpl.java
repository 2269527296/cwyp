package com.abc.service.impl;

import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.abc.pojo.Findfriend;
import com.abc.dao.FindfriendMapper;
import com.abc.service.FindfriendService;
@Service
public class FindfriendServiceImpl extends ServiceImpl<FindfriendMapper, Findfriend> implements FindfriendService{

    @Autowired
    FindfriendMapper dao;

    @Override
    public IPage<Findfriend> getPage(int currentPage, int pageSize, String name, String gamename) {
        LambdaQueryWrapper<Findfriend> lwq = new LambdaQueryWrapper<Findfriend>();
        lwq.like(Strings.isNotEmpty(name),Findfriend::getName,name);
        lwq.like(Strings.isNotEmpty(gamename),Findfriend::getGamename,gamename);
        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }




}
