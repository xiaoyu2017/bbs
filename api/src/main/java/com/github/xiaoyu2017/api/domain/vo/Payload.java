package com.github.xiaoyu2017.api.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author xiaoyu
 * @version 1.0
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
