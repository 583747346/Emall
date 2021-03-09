package com.emall.emallumsservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallumsentity.entity.form.MenuForm;
import com.emall.emallumsentity.entity.params.MenuPageParam;
import com.emall.emallumsentity.entity.vo.MenuVo;
import com.emall.emallumsentity.entity.vo.PermissionVo;
import com.emall.emallumsservice.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@RestController
@RequestMapping("/menu")
@Api(value = "MenuController", tags = "菜单信息API")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "添加菜单", notes = "添加菜单信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PostMapping
    public Result insertMenu(@RequestBody MenuForm menuForm){
        return Result.success(menuService.insertMenu(menuForm));
    }

    @ApiOperation(value = "删除菜单", notes = "删除菜单信息")
    @DeleteMapping("/{menuId}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteMenu(@PathVariable Long menuId) {
        return Result.success(menuService.deleteMenu(menuId));
    }

    @ApiOperation(value = "更新菜单", notes = "根据菜单id更新资源")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{menuId}")
    public Result updateMenu(@PathVariable Long menuId, @RequestBody MenuForm menuForm) {
        return Result.success(menuService.updateMenu(menuId,menuForm));
    }


    @ApiOperation(value = "条件分页查询菜单", notes = "条件分页查询所有菜单列表")
    @PostMapping("/menulist")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<IPage<MenuVo>> getMenus(@RequestBody MenuPageParam menuQueryParam) {
        return Result.success(menuService.getMenus(menuQueryParam.getPage(), menuQueryParam));
    }

    @ApiOperation(value = "查看所有菜单的树状结构", notes = "查看所有菜单的树状结构")
    @GetMapping("/menutree")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<List<PermissionVo>> getMenuTree() {
        return Result.success(menuService.getMenuTree());
    }

    @ApiOperation(value = "查看所有的子菜单", notes = "查看所有的子菜单")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @GetMapping(value = "/getSubMenus")
    public Result<List<MenuVo>> getSubMenus() {
        return Result.success(menuService.getSubMenus());
    }

}
