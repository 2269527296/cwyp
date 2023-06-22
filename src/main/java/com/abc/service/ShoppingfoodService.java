package com.abc.service;

import com.abc.pojo.Peiwancate;
import com.abc.pojo.Shoppingfood;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface ShoppingfoodService extends IService<Shoppingfood>{


    IPage<Shoppingfood> getPage(int currentPage, int pageSize, String textsrc, String dizhi);

    void modify(Shoppingfood food);
}
