package com.abc.service;

import com.abc.pojo.Peiwancate;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface PeiwancateService extends IService<Peiwancate>{


    IPage<Peiwancate> getPage(int currentPage, int pageSize, String gamename, String peiwanname);

    void modify(Peiwancate p);
}
