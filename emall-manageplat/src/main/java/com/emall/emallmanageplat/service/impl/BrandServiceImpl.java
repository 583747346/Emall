package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.BrandParam;
import com.emall.emallmanageplat.entity.po.BrandPo;
import com.emall.emallmanageplat.entity.vo.BrandVo;
import com.emall.emallmanageplat.mapper.BrandMapper;
import com.emall.emallmanageplat.service.IBrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandPo> implements IBrandService {
    @Override
    public BrandVo getBrandById(String brandId) {
        BrandPo brandPo = this.getById(brandId);
        return new BrandVo(brandPo);
    }

    /**
     * 分页查询品牌信息
     *
     * @param page
     * @param brandParam
     * @return
     */
    @Override
    public IPage<BrandVo> getBrands(Page page, BrandParam brandParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(brandParam.getName()), "name", brandParam.getName());
        queryWrapper.ge(StringUtils.isNotEmpty(brandParam.getCreatedTimeStart().toString()), "create_time", brandParam.getCreatedTimeStart());
        queryWrapper.le(StringUtils.isNotEmpty(brandParam.getCreatedTimeEnd().toString()), "create_time", brandParam.getCreatedTimeEnd());
        IPage<BrandPo> brandPos = this.page(page, queryWrapper);
        return brandPos.convert(BrandVo::new);
    }

    /**
     * 添加一个新的品牌
     *
     * @param brandPo
     * @return
     */
    @Override
    public Boolean insertBrand(BrandPo brandPo) {
        return this.save(brandPo);
    }

    /**
     * 根据品牌id——更新品牌信息
     * @param brandPo
     * @return
     */
    @Override
    public Boolean updateBrand(BrandPo brandPo) {
        return this.updateById(brandPo);
    }

    /**
     * 根据品牌id——批量删除品牌
     * @param brandId
     * @return
     */
    @Override
    public Boolean deleteBrand(String brandId) {
        String[] brandIds = brandId.split(",");
        List<BrandPo> brandPos = this.baseMapper.selectBatchIds(Arrays.asList(brandIds));
        brandPos.forEach(brandPo -> {
            //TODO 品牌表添加删除标记（逻辑删除）
//            brandPo.setDelete("1");
        });
        return this.updateBatchById(brandPos);
    }
}
