package com.emall.emallappservice.controller;

import com.emall.emallcore.result.Result;
import com.emall.emallappservice.entity.form.MemberForm;
import com.emall.emallappservice.entity.vo.MemberVo;
import com.emall.emallappservice.service.IMemberService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@Api(tags = "会员信息界面", value = "MemberController")
@Slf4j
public class MemberController {

    @Autowired
    private IMemberService memberService;

    /**
     * 账号密码注册登录
     *
     * @return
     */
    @ApiOperation(value = "用户注册登录", notes = "根据手机号注册登录")
    @ApiImplicitParam(paramType = "MemberForm", value = "注册登录表单", required = true, dataType = "MemberForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/register")
    public Result register(@RequestParam MemberForm memberForm) {
        return Result.success(memberService.register(memberForm));
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/getMemberInfo")
    public Result<MemberVo> getMemberInfo() {
        return Result.success(memberService.getMemberInfo());
    }

    @ApiOperation(value = "修改会员信息", notes = "修改会员信息")
    @ApiImplicitParam(paramType = "", value = "", required = true)
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/updateMember")
    public Result<MemberVo> updateMember() {
        return Result.success(memberService.updateMember());
    }

}
