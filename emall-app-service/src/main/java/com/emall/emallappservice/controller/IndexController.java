/*
package com.emall.emalldeskfronton.controller;

import com.emall.emallcore.result.Result;
import com.emall.emalldeskfronton.com.emall.emallgoodsentity.entity.vo.*;
import com.emall.emalldeskfronton.service.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
@Api(tags = "emall首页", value = "IndexController")
public class IndexController {

    @Autowired
    private IAdvertiseService advertiseService;
    @Autowired
    private IProductTopicService productTopicService;
    @Autowired
    private IProductService productService;
    @Autowired
    private ISecKillService secKillService;


    @ApiOperation(value = "首页", notes = "首页信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<List<EmallCarVo>> getAdvertisePics() {
        IndexInfoVo indexInfoVo = new IndexInfoVo();
        //获取广告轮播商品
        List<AdvertiseVo> advertisePics = advertiseService.getAdvertisePics();
        //获取主题信息(主题表与分类表关联)
        List<ProductTopicVo> productTopicVos = productTopicService.getProductTopics();
        //获取促销商品信息
        List<PromotionVo> promotionVos = productService.getPromotions();
        //获取秒杀商品信息
//        List<SecKillVo> secKillVos = secKillService.getSeckillGoods();
        //新品首发
        List<NewGoodsVo> newProducts = productService.getNewProducts();
        //获取推荐商品信息(榜单，价格购，回购，员工推荐)
//        List<RecommendVo> recommendVos = recommendService.getRecommends();
        //获取类别(类别——商品)
//        List<KindProductVo> kindProductVos = kindProductService.getKindProduct();
        return Result.success("");
    }


}
*/
