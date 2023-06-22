package com.abc.service.impl;

import com.abc.pojo.Peiwancate;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.abc.pojo.Knowpeiwan;
import com.abc.dao.KnowpeiwanMapper;
import com.abc.service.KnowpeiwanService;
@Service
public class KnowpeiwanServiceImpl extends ServiceImpl<KnowpeiwanMapper, Knowpeiwan> implements KnowpeiwanService{

    @Autowired
    KnowpeiwanMapper dao;

    @Override
    public IPage<Knowpeiwan> getPage(int currentPage, int pageSize, String know) {
        LambdaQueryWrapper<Knowpeiwan> lwq = new LambdaQueryWrapper<Knowpeiwan>();
        lwq.like(Strings.isNotEmpty(know),Knowpeiwan::getKnow,know);
        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }
}
