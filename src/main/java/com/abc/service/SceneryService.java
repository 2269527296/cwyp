package com.abc.service;

import com.abc.pojo.Scenery;
import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface SceneryService extends IService<Scenery>{


    IPage<Scenery> getPage(int currentPage, int pageSize, String sceneryimg);

    void modify(Scenery sc);
}
