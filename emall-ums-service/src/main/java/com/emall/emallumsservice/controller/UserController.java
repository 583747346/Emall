package com.emall.emallumsservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.exception.SystemErrorType;
import com.emall.emallcore.result.Result;
import com.emall.emallumsentity.entity.form.UserInsertForm;
import com.emall.emallumsentity.entity.form.UserUpdateForm;
import com.emall.emallumsentity.entity.params.UserPageParam;
import com.emall.emallumsentity.entity.po.UserPo;
import com.emall.emallumsentity.entity.vo.UserVo;
import com.emall.emallumsservice.service.IRoleService;
import com.emall.emallumsservice.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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
@Slf4j
public class UserController {

    @Autowired
    private IUserService usersService;
    @Autowired
    private IRoleService roleService;

    private static final String CLIENT_TOKEN_USER = "client-token-user";

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/userlist")
    public Result<IPage<UserVo>> getUseList(@RequestBody UserPageParam userPageParam) {
        return Result.success(usersService.getUseList(userPageParam));
    }

    @ApiOperation(value = "获取用户", notes = "根据用户唯一标识id获取用户信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<UserVo> getUserByUniqueId(@RequestParam String uniqueId) {
        return Result.success(usersService.getByUniqueId(uniqueId));
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result<UserVo> updateUserById(@PathVariable Long id, @Valid @RequestBody UserUpdateForm userUpdateForm) {
        UserPo userPo = userUpdateForm.toPo(id, UserPo.class);
        return Result.success(usersService.updateUserById(userPo));
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result<UserVo> deleteUserById(@PathVariable Long id) {
        return Result.success(usersService.deleteUserById(id));
    }

    @ApiOperation(value = "修改用户状态", notes = "修改用户状态")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}/{status}")
    public Result<UserVo> updateStatusByUserId(@PathVariable Long id, @PathVariable String status) {
        return Result.success(usersService.updateStatusByUserId(id,status));
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result<UserVo> insertUser(@RequestBody @Valid UserInsertForm userInsertForm) {
        UserPo userPo = userInsertForm.toPo(UserPo.class);
        return Result.success(usersService.insertUser(userPo));
    }

    @ApiOperation(value = "根据token获取用户详情", notes = "获取用户详情")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping("/getUserInfo")
    public Result<UserVo> getUserInfo(HttpServletRequest request) {
        JSONObject jsonObject = JSONObject.parseObject(request.getHeader(CLIENT_TOKEN_USER));
        if (jsonObject == null) {
            return Result.fail(SystemErrorType.SYSTEM_ERROR);
        }
        return Result.success(usersService.getByUniqueId(jsonObject.get("username").toString()));
    }

    @ApiOperation(value = "查询角色", notes = "根据用户id查询用户所拥有的角色信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping(value = "/{userId}")
    public Result getRole(@PathVariable Long userId) {
        log.debug("query with userId:{}", userId);
        return Result.success(roleService.getRole(userId));
    }

    @ApiOperation(value = "根据用户id更新用户角色", notes = "更新用户角色")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/role/{userId}")
    public Result<UserVo> updateRoleByUserId(@PathVariable Long userId, @RequestBody List<String> roleIds) {
        return Result.success(usersService.updateRoleByUserId(userId, roleIds));
    }


}
