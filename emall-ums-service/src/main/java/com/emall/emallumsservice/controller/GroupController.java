package com.emall.emallumsservice.controller;

import com.emall.emallcore.result.Result;
import com.emall.emallumsentity.entity.form.GroupForm;
import com.emall.emallumsentity.entity.params.GroupPageParam;
import com.emall.emallumsentity.entity.params.GroupParam;
import com.emall.emallumsentity.entity.po.GroupPo;
import com.emall.emallumsentity.entity.vo.GroupVo;
import com.emall.emallumsservice.service.IGroupsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "GroupsController", tags = "用户组API")
public class GroupController {

    @Autowired
    private IGroupsService groupsService;

    @ApiOperation(value = "查询用户组", notes = "模糊查询用户组-分页")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping(("/getGroup"))
    public Result<List<GroupVo>> getGroup(@RequestBody GroupPageParam groupQueryParam) {
        return Result.success(groupsService.getGroup(groupQueryParam.getPage(), groupQueryParam.toParam(GroupParam.class)));
    }

    @ApiOperation(value = "创建用户组", notes = "创建用户组")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result insertGroup(@RequestBody GroupForm groupForm) {
        return Result.success(groupsService.insertGroup(groupForm.toPo(GroupPo.class)));
    }

    @ApiOperation(value = "更新用户组", notes = "根据用户组id更新用户组")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{id}")
    public Result updateGroup(@PathVariable Long id, @RequestBody GroupForm groupForm) {
        return Result.success(groupsService.updateGroup(groupForm.toPo(id, GroupPo.class)));
    }

    @ApiOperation(value = "删除用户组", notes = "根据用户组id删除用户组")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping("/{id}")
    public Result deleteGroup(@PathVariable String id) {
        return Result.success(groupsService.deleteGroup(id));
    }
}
