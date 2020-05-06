package com.emall.emallmanageplat.web;


import com.core.result.Result;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.service.IUsersService;
import com.emall.emallmanageplat.service.impl.UsersServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @ApiOperation(value = "获取用户", notes = "根据用户唯一标识id获取用户信息")
    @ApiImplicitParam(paramType = "query", name = "uniqueId", value = "用户唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<UsersVo> getUserByUniqueId(@RequestParam String uniqueId) {
        return Result.success(usersService.getByUniqueId(uniqueId));
    }

}
