package com.github.xiaoyu2017.api.controller;

import com.github.xiaoyu2017.api.domain.vo.Result;
import com.github.xiaoyu2017.api.domain.vo.UserVo;
import com.github.xiaoyu2017.api.server.UserService;
import com.github.xiaoyu2017.api.tool.BeanTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 授权管理
 *
 * @author xiaoyu
 * @version 1.0
 */

@RestController
@Api(tags = "授权管理")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ResponseEntity<Result<String>> login(UserVo userVo) {
        return ResponseEntity.ok(userService.verify(BeanTool.beanToUser(userVo)));
    }

}
