package com.emall.emallmanageplat.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.params.MemberQueryParam;
import com.emall.emallmanageplat.entity.po.MemberPo;
import com.emall.emallmanageplat.service.IMemberService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "MemberController", value = "会员信息-API")
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @ApiOperation(value = "获取会员信息", notes = "根据条件获取商品属性")
    @ApiImplicitParam(name = "MemberQueryParam", value = "会员筛选条件", required = true, dataType = "MemberQueryParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<IPage<MemberPo>> getAttribute(@RequestBody MemberQueryParam param) {
        return Result.success(memberService.getMembers(param));
    }
}
