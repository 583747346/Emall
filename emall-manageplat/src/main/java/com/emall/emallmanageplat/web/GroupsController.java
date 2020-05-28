package com.emall.emallmanageplat.web;

import com.emall.emallcommon.core.result.Result;
import com.emall.emallmanageplat.entity.form.GroupInsertForm;
import com.emall.emallmanageplat.entity.form.GroupUpdateForm;
import com.emall.emallmanageplat.entity.params.GroupParam;
import com.emall.emallmanageplat.entity.po.GroupsPo;
import com.emall.emallmanageplat.entity.vo.GroupVo;
import com.emall.emallmanageplat.service.IGroupsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户组表 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@RestController
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private IGroupsService groupsService;

    @ApiOperation(value = "查询用户组", notes = "模糊查询用户组")
    @ApiImplicitParam(paramType = "GroupParam", value = "用户组添加表单信息", required = true, dataType = "GroupParam")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result<List<GroupVo>> getGroup(@RequestBody GroupParam groupParam) {
        return Result.success (groupsService.getGroup (groupParam));
    }

    @ApiOperation(value = "创建用户组", notes = "创建用户组")
    @ApiImplicitParam(paramType = "GroupInsertForm", value = "用户组添加表单信息", required = true, dataType = "GroupInsertForm")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result insertGroup(@RequestBody GroupInsertForm groupInsertForm) {
        return Result.success (groupsService.insertGroup (groupInsertForm.toPo (GroupsPo.class)));
    }

    @ApiOperation(value = "更新用户组", notes = "根据用户组id更新用户组")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", value = "用户唯一标识", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "GroupUpdateForm", value = "用户组更新表单信息", required = true, dataType = "GroupUpdateForm")
    })
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result updateGroup(@PathVariable String id, @RequestBody GroupUpdateForm groupUpdateForm) {
        return Result.success (groupsService.updateGroup (groupUpdateForm.toPo (id, GroupsPo.class)));
    }

    @ApiOperation(value = "删除用户组", notes = "根据用户组id删除用户组")
    @ApiImplicitParam(paramType = "path", value = "用户唯一标识", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result deleteGroup(@PathVariable String id) {
        return Result.success (groupsService.deleteGroup (id));
    }
}
