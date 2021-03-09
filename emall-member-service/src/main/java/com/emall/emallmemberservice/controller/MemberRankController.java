package com.emall.emallmemberservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallcore.result.Result;
import com.emall.emallmemberentity.entity.form.MemberRankForm;
import com.emall.emallmemberentity.entity.po.MemberRankPo;
import com.emall.emallmemberentity.entity.vo.MemberRankVo;
import com.emall.emallmemberservice.service.IMemberRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 会员等级 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
@RestController
@RequestMapping("/member-rank")
@Api(value = "MemberRankController", tags = "会员等级信息API")
public class MemberRankController {

    @Autowired
    private IMemberRankService memberRankService;

    @ApiOperation(value = "会员等级信息列表", notes = "条件分页查询所有会员等级")
    @PostMapping("/memberRankList")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<IPage<MemberRankVo>> memberRankList(@RequestBody Page page) {
        return Result.success(memberRankService.memberRankList(page));
    }

    @ApiOperation(value = "会员等级信息添加", notes = "会员等级信息添加")
    @PostMapping
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertMemberRank(@RequestBody MemberRankForm memberRankForm) {
        return Result.success(memberRankService.insertMemberRank(memberRankForm.toPo(MemberRankPo.class)));
    }

    @ApiOperation(value = "会员等级信息删除", notes = "会员等级信息删除")
    @DeleteMapping("/{id}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteMemberRank(@PathVariable Long id) {
        return Result.success(memberRankService.deleteMemberRank(id));
    }

    @ApiOperation(value = "会员等级信息更新", notes = "会员等级信息更新")
    @PutMapping("/{id}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateMemberRank(@PathVariable Long id, @RequestBody MemberRankForm memberRankForm) {
        return Result.success(memberRankService.updateMemberRank(memberRankForm.toPo(id, MemberRankPo.class)));
    }

    @ApiOperation(value = "会员等级信息的状态更新", notes = "会员等级信息的状态更新")
    @PutMapping("/{id}/{status}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateStatusById(@PathVariable Long id, @PathVariable Integer status) {
        return Result.success(memberRankService.updateStatusById(id, status));
    }

    @ApiOperation(value = "会员等级描述列表", notes = "会员等级描述去重列表")
    @GetMapping
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<List<String>> memberRankeDistinct() {
        return Result.success(memberRankService.memberRankeDistinct());
    }

}
