package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.form.BrandForm;
import com.emall.emallmanageplat.entity.params.BrandParam;
import com.emall.emallmanageplat.entity.po.BrandPo;
import com.emall.emallmanageplat.entity.vo.BrandVo;
import com.emall.emallmanageplat.mapper.BrandMapper;
import com.emall.emallmanageplat.oss.OssUploadPicture;
import com.emall.emallmanageplat.service.IBrandService;
import com.emall.emallmanageplat.tool.OssBucketEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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
     * @param brandForm
     * @return
     */
    @Override
    @Transactional
    public Boolean insertBrand(BrandForm brandForm) {
        //brand logo 添加到oss 返回图片地址
        BrandPo brandPo = brandForm.toPo(BrandPo.class);
        String logo = ossUploadPicture.uploadPicToOss(brandForm.getLogo(), OssBucketEnum.BRAND_LOGO);
        //brand bigPic 添加到oss 返回图片地址
        String bigPic = ossUploadPicture.uploadPicToOss(brandForm.getBigPic(), OssBucketEnum.BRAND_BIGPIC);
        brandPo.setLogo(logo);
        brandPo.setBigPic(bigPic);
        return this.save(brandPo);
    }

    /**
     * 根据品牌id——更新品牌信息
     *
     *
     * @param brandId
     * @param brandForm
     * @return
     */
    @Override
    @Transactional
    public Boolean updateBrand(Long brandId, BrandForm brandForm) {
        BrandPo brandPo = brandForm.toPo(brandId, BrandPo.class);
        //brand logo 添加到oss 返回图片地址
        String logo = ossUploadPicture.uploadPicToOss(brandForm.getLogo(), OssBucketEnum.BRAND_LOGO);
        //brand bigPic 添加到oss 返回图片地址
        String bigPic = ossUploadPicture.uploadPicToOss(brandForm.getBigPic(), OssBucketEnum.BRAND_BIGPIC);
        brandPo.setLogo(logo);
        brandPo.setBigPic(bigPic);
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
        List<BrandPo> brandPos = this.baseMapper.selectBatchIds(Arrays.asList(brandIds));
        brandPos.forEach(brandPo -> {
            //TODO 品牌表添加删除标记（逻辑删除）
//            brandPo.setDelete("1");
        });
        return this.updateBatchById(brandPos);
    }
}
