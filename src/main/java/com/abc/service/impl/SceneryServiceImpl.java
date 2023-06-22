package com.abc.service.impl;

import com.abc.pojo.Imgabc;
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
import com.abc.pojo.Scenery;
import com.abc.dao.SceneryMapper;
import com.abc.service.SceneryService;
@Service
public class SceneryServiceImpl extends ServiceImpl<SceneryMapper, Scenery> implements SceneryService{

    @Autowired
    SceneryMapper dao;


    @Override
    public IPage<Scenery> getPage(int currentPage, int pageSize, String sceneryimg) {
        LambdaQueryWrapper<Scenery> lwq = new LambdaQueryWrapper<Scenery>();
        lwq.like(Strings.isNotEmpty(sceneryimg),Scenery::getSceneryimg,sceneryimg);
        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }

    @Override
    public void modify(Scenery sc) {
        dao.updateById(sc);
    }
}
