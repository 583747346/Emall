package com.emall.gatewayadmin.web;

import com.emall.emallcore.result.Result;
import com.emall.gatewayadmin.entity.po.GatewayRoutePo;
import com.emall.gatewayadmin.entity.form.GatewayRouteForm;
import com.emall.gatewayadmin.entity.form.GatewayRouteQueryForm;
import com.emall.gatewayadmin.entity.vo.GatewayRouteVo;
import com.emall.gatewayadmin.entity.params.GatewayRouteQueryParam;
import com.emall.gatewayadmin.service.GatewayRouteService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gateway/routes")
@Api(value = "GatewayRouteController", tags = "网关信息API")
@Slf4j
public class GatewayRouteController {

    @Autowired
    private GatewayRouteService gatewayRoutService;

    @ApiOperation(value = "新增网关路由", notes = "新增一个网关路由")
    @ApiImplicitParam(name = "gatewayRoutForm", value = "新增网关路由form表单", required = true, dataType = "GatewayRouteForm")
    @PostMapping
    public Result add(@Valid @RequestBody GatewayRouteForm gatewayRoutForm) {
        log.info("name:", gatewayRoutForm);
        GatewayRoutePo gatewayRout = gatewayRoutForm.toPo(GatewayRoutePo.class);
        return Result.success(gatewayRoutService.add(gatewayRout));
    }

    @ApiOperation(value = "删除网关路由", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "网关路由ID", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success(gatewayRoutService.delete(id));
    }

    @ApiOperation(value = "修改网关路由", notes = "修改指定网关路由信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "网关路由ID", required = true, dataType = "long"),
            @ApiImplicitParam(name = "gatewayRoutForm", value = "网关路由实体", required = true, dataType = "GatewayRouteForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody GatewayRouteForm gatewayRoutForm) {
        GatewayRoutePo gatewayRouteEntity = gatewayRoutForm.toPo(GatewayRoutePo.class);
        gatewayRouteEntity.setId(id);
        return Result.success(gatewayRoutService.update(gatewayRouteEntity));
    }

    @ApiOperation(value = "获取网关路由", notes = "根据id获取指定网关路由信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "网关路由ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public Result<GatewayRouteVo> get(@PathVariable String id) {
        log.info("get with id:{}", id);
        return Result.success(new GatewayRouteVo(gatewayRoutService.get(id)));
    }

    @ApiOperation(value = "根据uri获取网关路由", notes = "根据uri获取网关路由信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "网关路由路径", required = true, dataType = "string")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @GetMapping
    public Result<GatewayRouteVo> getByUri(@RequestParam String uri) {
        List<GatewayRouteVo> gatewayRoutesVo = gatewayRoutService.query(new GatewayRouteQueryParam(uri)).stream().map(GatewayRouteVo::new).collect(Collectors.toList());
        return Result.success(gatewayRoutesVo.stream().findFirst());
    }

    @ApiOperation(value = "搜索网关路由", notes = "根据条件查询网关路由信息")
    @ApiImplicitParam(name = "gatewayRoutQueryForm", value = "网关路由查询参数", required = true, dataType = "GatewayRouteQueryModel")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @PostMapping(value = "/conditions")
    public Result<GatewayRouteVo> search(@Valid @RequestBody GatewayRouteQueryForm gatewayRouteQueryForm) {
        List<GatewayRoutePo> gatewayRoutes = gatewayRoutService.query(gatewayRouteQueryForm.toParam(GatewayRouteQueryParam.class));
        List<GatewayRouteVo> gatewayRoutesVo = gatewayRoutes.stream().map(GatewayRouteVo::new).collect(Collectors.toList());
        return Result.success(gatewayRoutesVo);
    }

    @ApiOperation(value = "重载网关路由", notes = "将所以网关的路由全部重载到redis中")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功")
    )
    @PostMapping(value = "/overload")
    public Result<Boolean> overload() {
        return Result.success(gatewayRoutService.overload());
    }

}