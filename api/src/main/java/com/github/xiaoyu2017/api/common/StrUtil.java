package com.github.xiaoyu2017.api.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void main(String[] args) {
        String str = "/user/login/lslslsl?api=sasas";
        System.out.println(StrUtil.uriRemoveParam(str));
    }
}
