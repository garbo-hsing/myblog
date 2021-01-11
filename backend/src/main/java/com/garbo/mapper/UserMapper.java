package com.garbo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garbo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author garbo
 * @since 2021-01-11
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User getUserById(Long id);
}
