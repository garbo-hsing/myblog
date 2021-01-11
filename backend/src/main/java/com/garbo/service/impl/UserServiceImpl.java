package com.garbo.service.impl;

import com.garbo.entity.User;
import com.garbo.mapper.UserMapper;
import com.garbo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    private UserMapper userMapper;

    @Autowired
    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
}
