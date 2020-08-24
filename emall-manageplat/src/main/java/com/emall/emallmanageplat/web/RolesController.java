package com.emall.emallmanageplat.web;

import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.RoleInsertForm;
import com.emall.emallmanageplat.entity.form.RoleUpdateForm;
import com.emall.emallmanageplat.entity.po.RolesPo;
import com.emall.emallmanageplat.service.IRolesService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@RestController
@Slf4j
@Api(value = "RolesController", tags = "角色信息API")
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @ApiOperation(value = "查询角色", notes = "根据用户id查询用户所拥有的角色信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping(value = "/user/{userId}")
    public Result getRole(@PathVariable Long userId) {
        log.debug("query with userId:{}", userId);
        return Result.success(rolesService.getRole(userId));
    }

    @ApiOperation(value = "删除角色", notes = "根据角色id删除角色")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping(value = "/{roleId}")
    public Result deleteRole(@PathVariable Long roleId) {
        return Result.success(rolesService.deleteRole(roleId));
    }

    @ApiOperation(value = "更新角色", notes = "更新角色信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping(value = "/{roleId}")
    public Result updateRole(@PathVariable Long roleId, RoleUpdateForm roleUpdateForm) {
        RolesPo rolesPo = roleUpdateForm.toPo(roleId, RolesPo.class);
        return Result.success(rolesService.updateRole(rolesPo));
    }

    @ApiOperation(value = "添加角色", notes = "添加角色信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result insertRole(RoleInsertForm roleUpdateForm) {
        RolesPo rolesPo = roleUpdateForm.toPo(RolesPo.class);
        return Result.success(rolesService.insertRole(rolesPo));
    }

    @ApiOperation(value = "根据角色id分配菜单(平台左侧菜单)", notes = "更新角色菜单")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/{roleId}/{menuId}")
    public Result updateMenuByRoleId(@PathVariable(value = "roleId") Long roleId, @PathVariable(value = "menuId") String menuId) {
        return Result.success(rolesService.updateMenuByRoleId(roleId, menuId));
    }

    @ApiOperation(value = "根据角色id分配资源(各个菜单的功能（增删改查等功能权限）)", notes = "更新角色资源")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/{roleId}/{resourceId}")
    public Result updateResourceByRoleId(@PathVariable(value = "roleId") Long roleId, @PathVariable(value = "resourceId") String resourceId) {
        return Result.success(rolesService.updateResourceByRoleId(roleId, resourceId));
    }

}
