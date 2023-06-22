package com.abc.service;

import com.abc.pojo.Knowpeiwan;
import com.abc.pojo.Peiwancate;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface KnowpeiwanService extends IService<Knowpeiwan>{


    IPage<Knowpeiwan> getPage(int currentPage, int pageSize, String know);
}
