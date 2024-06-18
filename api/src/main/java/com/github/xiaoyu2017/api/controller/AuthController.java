package com.github.xiaoyu2017.api.controller;

import com.github.xiaoyu2017.api.domain.bean.ResultCode;
import com.github.xiaoyu2017.api.domain.vo.Result;
import com.github.xiaoyu2017.api.domain.vo.UserVo;
import com.github.xiaoyu2017.api.server.UserService;
import com.github.xiaoyu2017.api.tool.BeanTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Result<String> result = new Result<>();
        if (userService.verify(BeanTool.beanToUser(userVo))) {
            result.setCode(ResultCode.LOGIN_SUCCESS_200.getCode());
            result.setMessage(ResultCode.LOGIN_SUCCESS_200.getValue());
            result.setError(0);
        } else {
            result.setCode(ResultCode.LOGIN_ERROR_400.getCode());
            result.setMessage(ResultCode.LOGIN_ERROR_400.getValue());
            result.setError(1);
        }
        return ResponseEntity.ok(result);
    }
}
