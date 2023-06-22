package com.abc.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.abc.dao.GamelistMapper;
import com.abc.pojo.Gamelist;
import com.abc.service.GamelistService;
@Service
public class GamelistServiceImpl extends ServiceImpl<GamelistMapper, Gamelist> implements GamelistService{

}
