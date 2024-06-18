package com.github.xiaoyu2017.api.tool;

import com.github.xiaoyu2017.api.domain.pojo.User;
import org.springframework.beans.BeanUtils;

/**
 * bean相关工具类
 *
 * @author xiaoyu
 * @version 1.0
 */
public class BeanTool {

    public static User beanToUser(Object s) {
        User user = new User();
        BeanUtils.copyProperties(s, user);
        return user;
    }

}
