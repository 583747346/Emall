package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.form.BrandForm;
import com.emall.emallgoodsentity.entity.params.BrandParam;
import com.emall.emallgoodsentity.entity.vo.BrandVo;
import com.emall.emallgoodsservice.mapper.BrandMapper;
import com.emall.emallgoodsservice.oss.OssUploadPicture;
import com.emall.emallgoodsservice.service.IBrandService;
import com.emall.emallweb.entity.po.BrandPo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandPo> implements IBrandService {

    @Autowired
    private OssUploadPicture ossUploadPicture;

    @Override
    public BrandVo getBrandById(Long brandId) {
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
        QueryWrapper queryWrapper = brandParam.build();
        queryWrapper.like(StringUtils.isNotEmpty(brandParam.getName()), "name", brandParam.getName());
        IPage<BrandPo> brandPos = this.page(page, queryWrapper);
        return brandPos.convert(BrandVo::new);
    }

    /**
     * 添加一个新的品牌
     *
     * @param brandForm
     * @return
     */
    @Override
    @Transactional
    public Boolean insertBrand(BrandForm brandForm) {
        BrandPo brandPo = brandForm.toPo(BrandPo.class);
        return this.save(brandPo);
    }

    /**
     * 根据品牌id——更新品牌信息
     *
     * @param brandId
     * @param brandForm
     * @return
     */
    @Override
    @Transactional
    public Boolean updateBrand(Long brandId, BrandForm brandForm) {
        BrandPo brandPo = brandForm.toPo(brandId, BrandPo.class);
        return this.updateById(brandPo);
    }

    /**
     * 根据品牌id——批量删除品牌
     *
     * @param brandId
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteBrand(String brandId) {
        String[] brandIds = brandId.split(",");
        List<Long> idLongs = Arrays.asList(brandIds).stream().map(id -> Long.parseLong(id)).collect(Collectors.toList());
        List<BrandPo> brandPos = this.baseMapper.selectBatchIds(idLongs);
        return this.updateBatchById(brandPos);
    }

    /**
     * 根据品牌id修改品牌状态
     *
     * @param brandId
     * @param showStatus
     * @return
     */
    @Override
    public Boolean updateStatusByBrandId(Long brandId, int showStatus) {
        UpdateWrapper<BrandPo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", brandId).set("show_status", showStatus);
        return this.update(updateWrapper);
    }
}
