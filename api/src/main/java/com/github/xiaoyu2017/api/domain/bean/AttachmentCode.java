package com.github.xiaoyu2017.api.domain.bean;

import lombok.Getter;

/**
 * TODO
 *
 * @author xiaoyu
 * @version 1.0
 */
@Getter
public enum AttachmentCode {
    USER_ICON(1, "用户头像"),
    ARTICLE_IMG(2, "文章图片");

    AttachmentCode(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private final Integer code;
    private final String value;
}
