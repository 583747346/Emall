package com.emall.emallappservice.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员商品浏览记录
 */
@RestController
@RequestMapping("/history")
@Api(tags = "会员商品浏览记录",value = "MemberHistoryController")
public class MemberHistoryController {
}
