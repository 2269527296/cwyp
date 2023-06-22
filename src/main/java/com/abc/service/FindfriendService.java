package com.abc.service;

import com.abc.pojo.Findfriend;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface FindfriendService extends IService<Findfriend>{


    IPage<Findfriend> getPage(int currentPage, int pageSize, String name, String gamename);


}
