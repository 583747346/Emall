package com.emall.emallmanageplat.web;

import com.emall.emallcommon.core.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/test")
    public Result test(){
        int i= 1/0;
        return Result.success ("成功");
    }

}
