package com.abc.service.impl;

import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.abc.dao.MessageMapper;
import com.abc.pojo.Message;
import com.abc.service.MessageService;
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService{

    @Autowired
    MessageMapper dao;

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, String username, String infomation) {
        LambdaQueryWrapper<Message> lwq = new LambdaQueryWrapper<Message>();
        lwq.like(Strings.isNotEmpty(username),Message::getUsername,username);
        lwq.like(Strings.isNotEmpty(infomation),Message::getInfomation,infomation);
        IPage page = new Page(currentPage,pageSize);
        dao.selectPage(page,lwq);
        return page;
    }


}
