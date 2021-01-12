package com.garbo;

import com.garbo.common.lang.Result;
import com.garbo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(Result.succeed(userMapper.getUserById(1L)));
    }
}
