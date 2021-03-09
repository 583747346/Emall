package com.emall.emallgoodsservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallcore.result.Result;
import com.emall.emallgoodsentity.entity.form.MemberPriceForm;
import com.emall.emallgoodsentity.entity.po.MemberPricePo;
import com.emall.emallgoodsentity.entity.vo.MemberPriceVo;
import com.emall.emallgoodsservice.service.IMemberPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员价格 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
@RestController
@RequestMapping("/member-price")
@Api(value = "MemberPriceController", tags = "会员价格-API")
@Slf4j
public class MemberPriceController {

    @Autowired
    private IMemberPriceService memberPriceService;

    @ApiOperation(value = "获取会员价格信息", notes = "获取会员价格信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/memberPriceList")
    public Result<IPage<MemberPriceVo>> memberPriceList(@RequestBody Page page) {
        return Result.success(memberPriceService.memberPriceList(page));
    }

    @ApiOperation(value = "会员价格信息添加", notes = "会员价格信息添加")
    @PostMapping
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result insertMemberPrice(@RequestBody MemberPriceForm memberPriceForm) {
        return Result.success(memberPriceService.insertMemberPrice(memberPriceForm.toPo(MemberPricePo.class)));
    }

    @ApiOperation(value = "会员价格信息删除", notes = "会员价格信息删除")
    @DeleteMapping("/{id}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteMemberPrice(@PathVariable Long id) {
        return Result.success(memberPriceService.deleteMemberPrice(id));
    }

    @ApiOperation(value = "会员价格信息更新", notes = "会员价格信息更新")
    @PutMapping("/{id}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result updateMemberPrice(@PathVariable Long id, @RequestBody MemberPriceForm memberPriceForm) {
        return Result.success(memberPriceService.updateMemberPrice(memberPriceForm.toPo(id, MemberPricePo.class)));
    }

}
