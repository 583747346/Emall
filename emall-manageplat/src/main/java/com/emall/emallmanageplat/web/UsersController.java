package com.emall.emallmanageplat.web;

import com.alibaba.fastjson.JSONObject;
import com.emall.emallcore.exception.SystemErrorType;
import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.UserInsertForm;
import com.emall.emallmanageplat.entity.po.UsersPo;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.entity.form.UserUpdateForm;
import com.emall.emallmanageplat.service.IUsersService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
@Api(value = "UsersController", tags = "用户信息API")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    private static final String CLIENT_TOKEN_USER = "client-token-user";
    private static final String CLIENT_TOKEN = "client-token";

    @ApiOperation(value = "获取用户", notes = "根据用户唯一标识id获取用户信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<UsersVo> getUserByUniqueId(@RequestParam String uniqueId) {
        return Result.success(usersService.getByUniqueId(uniqueId));
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result<UsersVo> updateUserById(@PathVariable Long id, @Valid @RequestBody UserUpdateForm userUpdateForm) {
        UsersPo usersPo = userUpdateForm.toPo(id, UsersPo.class);
        return Result.success(usersService.updateUserById(usersPo));
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result<UsersVo> deleteUserById(@PathVariable Long id) {
        return Result.success(usersService.deleteUserById(id));
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result<UsersVo> insertUser(@RequestBody UserInsertForm userInsertForm) {
        UsersPo usersPo = userInsertForm.toPo(UsersPo.class);
        return Result.success(usersService.insertUser(usersPo));
    }

    @ApiOperation(value = "根据token获取用户详情", notes = "获取用户详情")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/getUserInfo")
    public Result<UsersVo> getUserInfo(HttpServletRequest request) {
        JSONObject jsonObject = JSONObject.parseObject(request.getHeader(CLIENT_TOKEN_USER));
        if (jsonObject == null) {
            return Result.fail(SystemErrorType.SYSTEM_ERROR);
        }
        return Result.success(usersService.getByUniqueId(jsonObject.get("username").toString()));
    }


    @ApiOperation(value = "根据用户id更新用户角色", notes = "更新用户角色")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/{userid}/{roleId}")
    public Result<UsersVo> updateRoleByUserId(@PathVariable Long userid, @PathVariable String roleId) {
        return Result.success(usersService.updateRoleByUserId(userid, roleId));
    }

}
