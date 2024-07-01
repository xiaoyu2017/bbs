package com.github.xiaoyu2017.api.server.impl;

import com.github.xiaoyu2017.api.config.JwtConfig;
import com.github.xiaoyu2017.api.domain.bean.ResultCode;
import com.github.xiaoyu2017.api.domain.pojo.User;
import com.github.xiaoyu2017.api.domain.vo.Result;
import com.github.xiaoyu2017.api.mapper.UserMapper;
import com.github.xiaoyu2017.api.server.UserService;
import com.github.xiaoyu2017.api.util.JwtUtil;
import com.github.xiaoyu2017.api.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User用户服务类-接口实现类
 *
 * @author xiaoyu
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    JwtConfig jwtConfig;

    @Override
    public Result<String> verify(User user) {
        User resultUser = userMapper.selectByUserNameAndPassword(user);
        Result<String> result = new Result<>();
        if (resultUser != null) {
            user.setPassword("");
            // 返回JWT
            String token = JwtUtil.generateTokenExpireInMinutes(resultUser, jwtConfig.getPrivateKey(), jwtConfig.getUser().getExpire());
            result.setData(token);
            result.setCode(ResultCode.LOGIN_SUCCESS_200.getCode());
            result.setMessage(ResultCode.LOGIN_SUCCESS_200.getMessage());
            result.setError(0);
        } else {
            result.setCode(ResultCode.LOGIN_ERROR_400.getCode());
            result.setMessage(ResultCode.LOGIN_ERROR_400.getMessage());
            result.setError(1);
        }
        return result;
    }

    @Override
    public Result<String> add(User user) {
        // 设置UID
        user.setUid(SnowFlakeUtil.getStrSnowFlakeId());
        int insert = userMapper.insert(user);
        return insert == 1 ? Result.success(ResultCode.INSERT_SUCCESS_200) : Result.error(ResultCode.INSERT_ERROR_400);
    }

    @Override
    public Result<String> remove(String uid) {
        int delete = userMapper.deleteByUid(uid);
        return delete == 1 ? Result.success(ResultCode.DELETE_SUCCESS_200) : Result.error(ResultCode.DELETE_ERROR_400);
    }
}
