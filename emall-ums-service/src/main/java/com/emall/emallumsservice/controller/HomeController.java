package com.emall.emallumsservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.emall.emallcore.result.Result;
import com.emall.emallumsentity.entity.vo.PermissionVo;
import com.emall.emallumsservice.service.IHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/home")
@Slf4j
@Api(value = "首页dashboard",tags = "首页dashboard")
public class HomeController {

    @Autowired
    private IHomeService homeService;

    @ApiOperation(value = "树状菜单权限", notes = "树状菜单权限")
    @GetMapping(value = "/treeList")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    public Result<List<PermissionVo>> treeList(HttpServletRequest request){
        JSONObject parse = (JSONObject) JSONObject.parse(request.getHeaders("client-token-user").nextElement());
        return Result.success(homeService.treeList(parse.get("user_name").toString()));
    }

//    @ApiOperation(value = "首页dashboad", notes = "首页dashboad")
//    @GetMapping(value = "/getDashboard")
//    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
//    public Result<HomeVo> getDashboard(Principal principal){
//        return Result.success(homeService.getDashboard(principal.getName()));
//    }

}
