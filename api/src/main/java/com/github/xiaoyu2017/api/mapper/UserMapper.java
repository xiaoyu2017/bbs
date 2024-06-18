package com.github.xiaoyu2017.api.mapper;

import com.github.xiaoyu2017.api.domain.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * User用户数据库操作类-mapper
 *
 * @author xiaoyu
 * @version 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     *
     * @param user 用户信息
     * @return 行数
     */
    User selectByUserNameAndPassword(User user);

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return int
     */
    int insert(User user);

    int deleteByUid(String uid);
}
