package com.github.xiaoyu2017.api.domain.bean;

import lombok.Getter;

/**
 * TODO
 *
 * @author xiaoyu
 * @version 1.0
 */
@Getter
public enum ResultCode {
    // 数据新增
    INSERT_SUCCESS_200("2000", "新增成功"),
    INSERT_ERROR_400("4000", "新增失败"),
    // 数据删除
    DELETE_SUCCESS_200("2000", "删除成功"),
    DELETE_ERROR_400("4000", "删除失败"),

    // 登录
    LOGIN_SUCCESS_200("2000", "登录成功"),
    LOGIN_ERROR_400("4000", "用户名或密码错误"),
    LOGIN_ERROR_500("5000", "服务器出错请稍等");


    ResultCode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private final String code;
    private final String value;
}
