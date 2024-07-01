package com.github.xiaoyu2017.api.server;

import com.github.xiaoyu2017.api.domain.pojo.User;
import com.github.xiaoyu2017.api.domain.vo.Result;

/**
 * User用户服务类-接口
 *
 * @author xiaoyu
 * @version 1.0
 */
public interface UserService {

    Result<String> verify(User user);

    Result<String> add(User user);

    Result<String> remove(String uid);
}
