package com.emall.emallappservice.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * 商品推荐
 */

@RestController
@RequestMapping("/recommend")
@Api(tags = "商品推荐",value = "GoodsRecommendController")
public class GoodsRecommendController {
}
