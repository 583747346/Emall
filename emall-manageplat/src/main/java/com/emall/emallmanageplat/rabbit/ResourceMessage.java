package com.emall.emallmanageplat.rabbit;

import com.emall.emallmanageplat.entity.po.ResourcePo;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

@Data
public class ResourceMessage {

    private String code;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源url
     */
    private String url;

    /**
     * 资源方法
     */
    private String method;

    /**
     * 简介
     */

    private String description;

    /**
     * 消息标记（true-增加-更新，false-删除）
     */
    private Boolean flag;

    public ResourceMessage(ResourcePo resourcePo){
        BeanUtils.copyProperties(resourcePo,this);
    }

}
