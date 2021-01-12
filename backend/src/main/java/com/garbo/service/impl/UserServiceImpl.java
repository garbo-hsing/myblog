package com.garbo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garbo.entity.User;
import com.garbo.mapper.UserMapper;
import com.garbo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author garbo
 * @since 2021-01-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
