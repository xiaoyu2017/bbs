package com.github.xiaoyu2017.api.interceptor;

import com.github.xiaoyu2017.api.server.AuthService;
import com.github.xiaoyu2017.api.util.StrUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户验证相关拦截器
 *
 * @author xiaoyu
 * @version 1.0
 */
@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    AuthService authService;

    /**
     * controller执行前进行拦截
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  chosen handler to execute, for type and/or instance evaluation
     * @return 是否通过
     * @throws Exception 异常信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(StrUtil.USER_TOKEN);
        // token为空
        if (StringUtils.isBlank(token)) {
            response.sendRedirect("/login");
            return false;
        }
        // token是否过期
        if (authService.isLapse(token)) {
            response.sendRedirect("/login");
            return false;
        }
        // 是否需要刷新
        if (authService.isRefresh(token)) {
            token = authService.refreshToken(token);
            Cookie cookie = new Cookie(StrUtil.USER_TOKEN, token);
            response.addCookie(cookie);
        }
        return true;
    }
}
