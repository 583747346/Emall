package com.emall.emallumsservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallumsentity.entity.form.RoleInsertForm;
import com.emall.emallumsentity.entity.form.RoleUpdateForm;
import com.emall.emallumsentity.entity.params.RolePageParam;
import com.emall.emallumsentity.entity.po.RolePo;
import com.emall.emallumsentity.entity.vo.MenuVo;
import com.emall.emallumsentity.entity.vo.ResourceVo;
import com.emall.emallumsentity.entity.vo.RoleVo;
import com.emall.emallumsservice.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/rolelist")
    public Result<IPage<RoleVo>> getRoleList(@RequestBody RolePageParam rolePageParam) {
        return Result.success(roleService.getRoleList(rolePageParam));
    }

    @ApiOperation(value = "删除角色", notes = "根据角色id删除角色")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @DeleteMapping(value = "/{roleId}")
    public Result deleteRole(@PathVariable Long roleId) {
        return Result.success(roleService.deleteRole(roleId));
    }

    @ApiOperation(value = "更新角色", notes = "更新角色信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping(value = "/{roleId}")
    public Result updateRole(@PathVariable Long roleId, @RequestBody RoleUpdateForm roleUpdateForm) {
        RolePo rolePo = roleUpdateForm.toPo(roleId, RolePo.class);
        return Result.success(roleService.updateRole(rolePo));
    }

    @ApiOperation(value = "添加角色", notes = "添加角色信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result insertRole(@RequestBody RoleInsertForm roleUpdateForm) {
        RolePo rolePo = roleUpdateForm.toPo(RolePo.class);
        return Result.success(roleService.insertRole(rolePo));
    }

    @ApiOperation(value = "查看去重全部角色列表", notes = "查看去重全部角色列表")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @GetMapping("/distinct")
    public Result<Set<RoleVo>> getRoles() {
        return Result.success(roleService.getRoles());
    }

    @ApiOperation(value = "根据角色id查看菜单信息", notes = "根据角色id查看菜单信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @GetMapping("/getMenuByRoleId/{roleId}")
    public Result<Set<MenuVo>> getMenuByRoleId(@PathVariable Long roleId) {
        return Result.success(roleService.getMenuByRoleId(roleId));
    }

    @ApiOperation(value = "根据角色id查看资源信息", notes = "根据角色id查看资源信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @GetMapping("/getResourceByRoleId/{roleId}")
    public Result<Set<ResourceVo>> getResourceByRoleId(@PathVariable Long roleId) {
        return Result.success(roleService.getResourceByRoleId(roleId));
    }

    @ApiOperation(value = "根据角色id分配菜单(平台左侧菜单)", notes = "更新角色菜单")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/menu/{roleId}")
    public Result updateMenuByRoleId(@PathVariable(value = "roleId") Long roleId, @RequestBody List<String> menuIds) {
        return Result.success(roleService.updateMenuByRoleId(roleId, menuIds));
    }

    @ApiOperation(value = "根据角色id分配资源(各个菜单的功能（增删改查等功能权限）)", notes = "更新角色资源")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping("/resource/{roleId}")
    public Result updateResourceByRoleId(@PathVariable(value = "roleId") Long roleId, @RequestBody List<String> resourceIds) {
        return Result.success(roleService.updateResourceByRoleId(roleId, resourceIds));
    }

}
