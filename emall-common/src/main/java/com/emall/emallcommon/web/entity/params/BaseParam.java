package com.emall.emallcommon.web.entity.params;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.emall.emallcommon.web.entity.po.BasePo;
import lombok.Data;

import java.util.Date;


/**
 * @author qinlang
 * @param <T>
 */
@Data
public class BaseParam<T extends BasePo> {
    private Date createdTimeStart;
    private Date createdTimeEnd;

    public QueryWrapper<T> build() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null != this.createdTimeStart, "created_time", this.createdTimeStart)
                .le(null != this.createdTimeEnd, "created_time", this.createdTimeEnd);
        return queryWrapper;
    }
}
