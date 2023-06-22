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
import com.abc.dao.ShoppingfoodMapper;
import com.abc.pojo.Shoppingfood;
import com.abc.service.ShoppingfoodService;
@Service
public class ShoppingfoodServiceImpl extends ServiceImpl<ShoppingfoodMapper, Shoppingfood> implements ShoppingfoodService{

    @Autowired
    ShoppingfoodMapper dao;

    @Override
    public IPage<Shoppingfood> getPage(int currentPage, int pageSize, String textsrc, String dizhi) {
        LambdaQueryWrapper<Shoppingfood> lwq = new LambdaQueryWrapper<Shoppingfood>();
        lwq.like(Strings.isNotEmpty(textsrc),Shoppingfood::getTextsrc,textsrc);
        lwq.like(Strings.isNotEmpty(dizhi),Shoppingfood::getDizhi,dizhi);
        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }

    @Override
    public void modify(Shoppingfood food) {
        dao.updateById(food);
    }
}
