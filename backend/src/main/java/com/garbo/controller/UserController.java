package com.garbo.controller;


import com.garbo.common.lang.Result;
import com.garbo.entity.User;
import com.garbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author garbo
 * @since 2021-01-11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/{id}")
    public String test(@PathVariable("id") Long id) {
        User user = userService.getById(1L);
        return Result.succeed(user);
    }

}
