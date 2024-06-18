package com.github.xiaoyu2017.api.domain.pojo;

import com.github.xiaoyu2017.api.domain.BaseEntity;
import com.github.xiaoyu2017.api.domain.bean.CollectCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏类-pojo
 *
 * @author xiaoyu
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Collect extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1456133883784934357L;

    private Date time;
    private CollectCode code;
}
