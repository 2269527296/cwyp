package com.abc.service.impl;

import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.abc.dao.ImgabcMapper;
import com.abc.pojo.Imgabc;
import com.abc.service.ImgabcService;
@Service
public class ImgabcServiceImpl extends ServiceImpl<ImgabcMapper, Imgabc> implements ImgabcService{

    @Autowired
    ImgabcMapper dao;

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, String picture) {
        LambdaQueryWrapper<Imgabc> lwq = new LambdaQueryWrapper<Imgabc>();
        lwq.like(Strings.isNotEmpty(picture),Imgabc::getImgsrc,picture);
        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }

    @Override
    public void modify(Imgabc imgabc) {
        dao.updateById(imgabc);
    }
}
