package com.github.xiaoyu2017.api.server.impl;

import com.github.xiaoyu2017.api.domain.bean.ResultCode;
import com.github.xiaoyu2017.api.domain.pojo.User;
import com.github.xiaoyu2017.api.domain.vo.Result;
import com.github.xiaoyu2017.api.mapper.UserMapper;
import com.github.xiaoyu2017.api.server.UserService;
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

    @Override
    public boolean verify(User user) {
        User resultUser = userMapper.selectByUserNameAndPassword(user);
        if (resultUser != null) {
            return true;
        } else {
            return false;
        }
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
