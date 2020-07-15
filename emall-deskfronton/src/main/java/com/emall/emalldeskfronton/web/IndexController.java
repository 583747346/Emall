package com.emall.emalldeskfronton.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@Api(tags = "emall首页",value = "IndexController")
public class IndexController {



}
