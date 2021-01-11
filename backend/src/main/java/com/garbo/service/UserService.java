package com.garbo.service;

import com.garbo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author garbo
 * @since 2021-01-11
 */
public interface UserService extends IService<User> {
    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);
}
