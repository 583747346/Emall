package com.emall.authorizationserver.web;

import com.emall.authorizationserver.service.IAuthorizationService;
import com.emall.authorizationserver.tools.HttpServletRequestAuthWrapper;
import com.emall.emallcore.result.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("根据访问url授权")
@Slf4j
public class AuthorizationController {

    @Autowired
    private IAuthorizationService authorizationService;

    @ApiOperation(value = "权限验证", notes = "根据用户token，访问的url和method判断用户是否有权限访问")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "url", value = "访问的url", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "method", value = "访问的method", required = true, dataType = "string")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping(value = "/auth/permission")
    public Result decide(@RequestParam String url, @RequestParam String method, HttpServletRequest request) {
        boolean decide = authorizationService.auth(new HttpServletRequestAuthWrapper(request, url, method));
        return Result.success(decide);
    }
}
