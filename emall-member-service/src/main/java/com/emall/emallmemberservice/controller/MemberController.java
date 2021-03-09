package com.emall.emallmemberservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallmemberentity.entity.params.MemberPageParam;
import com.emall.emallmemberentity.entity.po.MemberPo;
import com.emall.emallmemberservice.service.IMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理平台查看会员信息
 */
@RestController
@Api(value = "MemberController", tags = "会员信息-API")
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @ApiOperation(value = "获取会员信息", notes = "根据条件获取会员信息列表")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/memberList")
    public Result<IPage<MemberPo>> memberList(@RequestBody MemberPageParam param) {
        return Result.success(memberService.memberList(param));
    }

    @ApiOperation(value = "会员状态修改", notes = "会员状态修改")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}/{status}")
    public Result<IPage<MemberPo>> updateMemberStatus(@PathVariable Long id, @PathVariable Integer status) {
        return Result.success(memberService.updateMemberStatus(id, status));
    }
}
