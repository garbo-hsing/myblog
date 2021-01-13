package com.garbo.controller;


import com.garbo.common.lang.Result;
import com.garbo.entity.User;
import com.garbo.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ApiOperation(value = "测试方法", notes = "测试方法", httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String test(@ApiParam(name = "id", value = "用户id", required = true, example = "1") @PathVariable("id") Long id) {
        User user = userService.getById(1L);
        return Result.succeed(user);
    }

}
