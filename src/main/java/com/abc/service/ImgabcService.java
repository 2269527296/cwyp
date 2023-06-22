package com.abc.service;

import com.abc.pojo.Imgabc;
import com.abc.pojo.Peiwancate;
import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface ImgabcService extends IService<Imgabc>{


    IPage<User> getPage(int currentPage, int pageSize, String picture);

    void modify(Imgabc imgabc);


}
