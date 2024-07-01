package com.github.xiaoyu2017.api.server.impl;

import com.github.xiaoyu2017.api.config.JwtConfig;
import com.github.xiaoyu2017.api.domain.pojo.User;
import com.github.xiaoyu2017.api.domain.vo.Payload;
import com.github.xiaoyu2017.api.mapper.UserMapper;
import com.github.xiaoyu2017.api.server.AuthService;
import com.github.xiaoyu2017.api.util.JwtUtil;
import com.github.xiaoyu2017.api.util.StrUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 用户相关服务类实现类
 *
 * @author xiaoyu
 * @version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;
    private final JwtConfig jwtConfig;
    private final StringRedisTemplate stringRedisTemplate;

    public AuthServiceImpl(UserMapper userMapper, JwtConfig jwtConfig, StringRedisTemplate stringRedisTemplate) {
        this.userMapper = userMapper;
        this.jwtConfig = jwtConfig;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public String verify(String userName, String password) {
        User resultUser = userMapper.selectByUserNameAndPassword(new User(userName, password));
        if (resultUser != null) {
            // 返回JWT
            return JwtUtil.generateTokenExpireInMinutes(resultUser, jwtConfig.getPrivateKey(), jwtConfig.getUser().getExpire());
        } else {
            return null;
        }
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }

    @Override
    public boolean logout(String token) {
        return stringRedisTemplate.opsForSet().add(StrUtil.AUTH_BLACK_LIST_KEY, token) > 0;
    }

    @Override
    public boolean isLapse(String token) {
        return stringRedisTemplate.opsForSet().add(StrUtil.AUTH_BLACK_LIST_KEY, token) == 0;
    }

    @Override
    public boolean isRefresh(String token) {
        Payload<User> infoFromToken = JwtUtil.getInfoFromToken(token, jwtConfig.getPublicKey(), User.class);
        return !(infoFromToken.getExpiration().getTime() > System.currentTimeMillis());
    }
}
