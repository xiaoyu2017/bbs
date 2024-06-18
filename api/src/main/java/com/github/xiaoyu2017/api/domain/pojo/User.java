package com.github.xiaoyu2017.api.domain.pojo;

import com.github.xiaoyu2017.api.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户类-pojo
 *
 * @author xiaoyu
 * @version 1.0
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 3843944063258139566L;

    public User() {
    }

    private String userName;
    private String password;
    private String uid;
}
