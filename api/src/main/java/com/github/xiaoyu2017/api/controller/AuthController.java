package com.github.xiaoyu2017.api.controller;

import com.github.xiaoyu2017.api.domain.bean.BbsContext;
import com.github.xiaoyu2017.api.domain.bean.ResultCode;
import com.github.xiaoyu2017.api.domain.vo.Result;
import com.github.xiaoyu2017.api.server.AuthService;
import com.github.xiaoyu2017.api.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    AuthService authService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ResponseEntity<Result<String>> login(HttpServletResponse response, String userName, String password) {
        String token = authService.verify(userName, password);
        if (StringUtils.isBlank(token)) {
            return ResponseEntity.ok(new Result<>(ResultCode.LOGIN_ERROR_400.getMessage(), ResultCode.LOGIN_ERROR_400.getCode(), 1, null));
        }
        Cookie cookie = new Cookie(StrUtil.USER_TOKEN, token);
        response.addCookie(cookie);
        return ResponseEntity.ok(new Result<>(ResultCode.LOGIN_SUCCESS_200.getMessage(), ResultCode.LOGIN_SUCCESS_200.getCode(), 0, token));
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出登录", notes = "退出登录")
    public ResponseEntity<Result<String>> logout(HttpServletRequest request) {
        if (authService.logout(BbsContext.get().getToken())) {
            return ResponseEntity.ok(new Result<>(ResultCode.LOGOUT_SUCCESS_200.getMessage(), ResultCode.LOGOUT_SUCCESS_200.getCode(), 0, null));
        }
        return ResponseEntity.ok(new Result<>(ResultCode.LOGOUT_ERROR_400.getMessage(), ResultCode.LOGOUT_ERROR_400.getCode(), 1, null));
    }

}
