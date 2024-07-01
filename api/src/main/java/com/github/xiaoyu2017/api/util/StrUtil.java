package com.github.xiaoyu2017.api.util;

/**
 * 字符串相关处理工具类
 *
 * @author xiaoyu
 * @version 1.0
 */
public class StrUtil {

    public static String uriRemoveParam(String uri) {
        String[] split = uri.split("\\?");
        int i = split[0].lastIndexOf('/');
        return split[0].substring(i);
    }

    // Redis
    public static final String AUTH_BLACK_LIST_KEY = "auth:black_list";


    // Web
    public static final String USER_TOKEN = "USER_TOKEN";
}
