package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.form.BrandForm;
import com.emall.emallmanageplat.entity.params.BrandParam;
import com.emall.emallmanageplat.entity.vo.BrandVo;

public interface IBrandService {

    BrandVo getBrandById(Long brandId);

    IPage<BrandVo> getBrands(Page page, BrandParam brandParam);

    Boolean insertBrand(BrandForm brandForm);

    Boolean updateBrand(Long brandId, BrandForm brandForm);

    Boolean deleteBrand(String brandId);
}
