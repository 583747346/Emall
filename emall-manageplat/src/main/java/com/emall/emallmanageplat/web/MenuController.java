package com.emall.emallmanageplat.web;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallcore.result.Result;
import com.emall.emallmanageplat.entity.form.MenuForm;
import com.emall.emallmanageplat.entity.params.MenuQueryParam;
import com.emall.emallmanageplat.entity.po.MenuPo;
import com.emall.emallmanageplat.entity.vo.ResourceVo;
import com.emall.emallmanageplat.service.IMenuService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add")
    public Result insertMenu(@RequestBody MenuForm menuForm){
        return Result.success(menuService.insertMenu(menuForm.toPo(MenuPo.class)));
    }

    @ApiOperation(value = "删除菜单", notes = "删除菜单信息")
    @DeleteMapping("/{menuId}")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result deleteResources(@PathVariable String menuId) {
        return Result.success(menuService.deleteMenu(menuId));
    }

    @ApiOperation(value = "更新菜单", notes = "根据菜单id更新资源")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @PutMapping("/{menuId}")
    public Result updateGroup(@PathVariable Long menuId, @RequestBody MenuForm menuForm) {
        return Result.success(menuService.updateMenu(menuForm.toPo(menuId, MenuPo.class)));
    }


    @ApiOperation(value = "条件分页查询菜单", notes = "条件分页查询所有菜单列表")
    @PostMapping("/getMenus")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    public Result<IPage<ResourceVo>> getResources(@RequestBody MenuQueryParam menuQueryParam) {
        return Result.success(menuService.getMenus(menuQueryParam.getPage(), menuQueryParam));
    }


}
