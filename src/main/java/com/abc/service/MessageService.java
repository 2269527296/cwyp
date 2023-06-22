package com.abc.service;

import com.abc.pojo.Message;
import com.abc.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface MessageService extends IService<Message>{




    IPage<User> getPage(int currentPage, int pageSize, String username, String infomation);
}
