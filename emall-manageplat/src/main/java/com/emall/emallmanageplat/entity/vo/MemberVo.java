package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.po.MemberPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("会员信息视图")
public class MemberVo {

    public MemberVo(MemberPo memberPo){
        BeanUtils.copyProperties(memberPo,this);
    }

}
