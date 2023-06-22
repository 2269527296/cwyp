package com.abc.service.impl;

import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.abc.dao.PeiwancateMapper;
import com.abc.pojo.Peiwancate;
import com.abc.service.PeiwancateService;
@Service
public class PeiwancateServiceImpl extends ServiceImpl<PeiwancateMapper, Peiwancate> implements PeiwancateService{

    @Autowired
    PeiwancateMapper dao;


    @Override
    public IPage<Peiwancate> getPage(int currentPage, int pageSize, String gamename, String peiwanname) {
        LambdaQueryWrapper<Peiwancate> lwq = new LambdaQueryWrapper<Peiwancate>();
        lwq.like(Strings.isNotEmpty(peiwanname),Peiwancate::getPeiwanname,peiwanname);
        lwq.like(Strings.isNotEmpty(gamename),Peiwancate::getGamename,gamename);
        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }

    @Override
    public void modify(Peiwancate p) {
        dao.updateById(p);
    }
}
