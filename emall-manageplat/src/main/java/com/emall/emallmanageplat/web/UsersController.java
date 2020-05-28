package com.emall.emallmanageplat.web;

import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.entity.form.UserInsertForm;
import com.emall.emallmanageplat.entity.po.UsersPo;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.entity.form.UserUpdateForm;
import com.emall.emallmanageplat.service.IUsersService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "用户列表信息")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @ApiOperation(value = "获取用户", notes = "根据用户唯一标识id获取用户信息")
    @ApiImplicitParam(name = "uniqueId", value = "用户唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping
    public Result<UsersVo> getUserByUniqueId(@RequestParam String uniqueId) {
        return Result.success(usersService.getByUniqueId(uniqueId));
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户唯一标识", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userUpdateForm", value = "用户更新表单", required = true, dataType = "UserUpdateForm")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result<UsersVo> updateUserById(@PathVariable String id, @Valid @RequestBody UserUpdateForm userUpdateForm) {
        UsersPo usersPo = userUpdateForm.toPo(id, UsersPo.class);
        return Result.success(usersService.updateUserById(usersPo));
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result<UsersVo> deleteUserById(@PathVariable String id) {
        return Result.success(usersService.deleteUserById(id));
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @ApiImplicitParam(paramType = "UserInsertForm",value = "用户添加表单", required = true, dataType = "UserInsertForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result<UsersVo> insertUser(@RequestBody UserInsertForm userInsertForm) {
        UsersPo usersPo = userInsertForm.toPo(UsersPo.class);
        return Result.success(usersService.insertUser(usersPo));
    }

}
