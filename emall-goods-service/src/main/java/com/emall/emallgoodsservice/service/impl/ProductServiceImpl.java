package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.form.ProductForm;
import com.emall.emallgoodsentity.entity.form.ProductSkuForm;
import com.emall.emallgoodsentity.entity.params.ProductParam;
import com.emall.emallgoodsentity.entity.po.*;
import com.emall.emallgoodsentity.entity.vo.BrandVo;
import com.emall.emallgoodsentity.entity.vo.ProductVo;
import com.emall.emallgoodsservice.mapper.ProductMapper;
import com.emall.emallgoodsservice.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPo> implements IProductService {

    //    @Autowired
//    private ESProductMapper esProductMapper;
    @Autowired
    private IProductSkuService productSkuService;
    @Autowired
    private IMemberPriceService memberPriceService;
    @Autowired
    private IPmsFullPromotionService fullPromotionService;
    @Autowired
    private IPmsProductAttributeValueService productAttributeValueService;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private IProductCategoryService productCategoryService;

    @Override
    public IPage<ProductVo> getProductByCondition(IPage page, ProductParam productParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //TODO 查询产品的时候筛选品牌/类别 表结构的关联
        queryWrapper.like(StringUtils.isNotEmpty(productParam.getName()), "name", productParam.getName());
        queryWrapper.eq(StringUtils.isNotEmpty(productParam.getBrand()), "brand", productParam.getBrand());
        queryWrapper.eq(StringUtils.isNotEmpty(productParam.getProductCategory()), "category", productParam.getProductCategory());
        queryWrapper.ge(StringUtils.isNotEmpty(productParam.getCreatedTimeStart().toString()), "created_time", productParam.getCreatedTimeStart());
        queryWrapper.le(StringUtils.isNotEmpty(productParam.getCreatedTimeEnd().toString()), "created_time", productParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotEmpty(productParam.getPromotionType().toString()), "promotion_type", productParam.getPromotionType());
        queryWrapper.eq(StringUtils.isNotEmpty(productParam.getNewStatus().toString()), "new_status", productParam.getNewStatus());
        queryWrapper.eq(StringUtils.isNotEmpty(productParam.getPublishStatus().toString()), "publish_status", productParam.getPublishStatus());
        IPage<ProductPo> productPos = this.page(page, queryWrapper);
        return productPos.convert(ProductVo::new);
    }

    /**
     * 批量上下架产品
     *
     * @param productIds
     * @return
     */
    @Override
    @Transactional
    public boolean publishProduct(String productIds) {
        List<String> ids = Arrays.asList(productIds.split(","));
        List<ProductPo> poList = this.baseMapper.selectBatchIds(ids);
        poList.forEach(productPo -> {
            productPo.setPublishStatus(1);
        });
        return this.updateBatchById(poList);
    }

    /**
     * 根据产品id更新商品信息
     *
     * @param productId
     * @param productForm
     * @return
     */
    @Override
    @Transactional
    public boolean updateProduct(Long productId, ProductForm productForm) {
        //更新商品信息
        this.updateById(productForm.toPo(productId, ProductPo.class));
        //更新SKU信息
        productSkuService.updateByPid(productId, productForm.getProductSkus());
        return true;
    }

    /**
     * 添加新产品
     *
     * @param productForm
     * @return
     */
    @Override
    @Transactional
    public boolean insertProduct(ProductForm productForm) {
        //添加产品
        ProductPo productPo = productForm.toPo(ProductPo.class);
        //生成商品货号
        generateProductCode(productPo);
        this.baseMapper.insert(productPo);
        //获取商品id
        Long productId = productPo.getId();

        /*************************************添加sku*****************************/
        //获取sku相关信息
        List<ProductSkuForm> productSkuForms = productForm.getProductSkus();
        //保存sku
        productSkuService.saveAll(productPo, productSkuForms);
        /************************************************************************/


        /*************************************添加促销*****************************/
        if (productForm.getPromotionType() == 2) {   //会员价格
            List<MemberPricePo> memberPricePos = new ArrayList<>();
            productForm.getMemberPriceForms().stream().forEach(memberPrice -> {
                MemberPricePo memberPricePo = new MemberPricePo();
                memberPricePo.setRankId(memberPrice.getRankId());
                memberPricePo.setMemberPrice(memberPrice.getMemberPrice());
                memberPricePo.setProductId(productId);
                memberPricePo.setMemberLevelName(memberPrice.getMemberLevelName());
                memberPricePos.add(memberPricePo);
            });
            memberPriceService.saveBatch(memberPricePos);
        } else if (productForm.getPromotionType() == 3) {   //满减价格
            List<FullPromotionPo> fullPromotionPos = new ArrayList<>();
            productForm.getPmsFullPromotionForms().stream().forEach(productFullPromotionForm -> {
                FullPromotionPo pmsFullPromotionPo = new FullPromotionPo();
                pmsFullPromotionPo.setFullPrice(productFullPromotionForm.getFullPrice());
                pmsFullPromotionPo.setReducePrice(productFullPromotionForm.getReducePrice());
                pmsFullPromotionPo.setProductId(productId);
                fullPromotionPos.add(pmsFullPromotionPo);
            });
            fullPromotionService.saveBatch(fullPromotionPos);
        }
        /****************************************************************************/

        /*************************************添加商品属性参数**************************/
        List<PmsProductAttributeValuePo> productAttributeValuePos = new ArrayList<>();
        productForm.getProdcutAttributeParams().stream().forEach(productParamsVo -> {
            PmsProductAttributeValuePo po = new PmsProductAttributeValuePo();
            po.setProductId(productId);
            po.setAtrributeParams(String.join(",", productParamsVo.getParamValue()));
            po.setAtrributeParamsId(productParamsVo.getParamId());
            productAttributeValuePos.add(po);
        });
        productAttributeValueService.saveBatch(productAttributeValuePos);
        /****************************************************************************/

        return true;
    }

    /**
     * 根据id批量删除产品信息
     *
     * @param productIds
     * @return
     */
    @Override
    @Transactional
    public boolean deleteProduct(String productIds) {
        List<String> ids = Arrays.asList(productIds.split(","));
        List<ProductPo> poList = this.baseMapper.selectBatchIds(ids);
        poList.forEach(productPo -> {
            productPo.setDeleteStatus(1);
        });
        return this.updateBatchById(poList);
    }

    /**
     * 生成商品货号
     * 款号生成规则：品牌编号【3位】+品类编号【4】+年份【后2位】+流水码【3】
     *
     * @param productPo
     */
    private void generateProductCode(ProductPo productPo) {
        //根据品牌id查品牌编号
        BrandVo brandVo = brandService.getBrandById(productPo.getBrandId());
        //根据品类编号查品类编号
        ProductCategoryPo categoryPo = productCategoryService.getCategoryById(productPo.getProductCategoryId());
        //获取年份
        int year = LocalDate.now().getYear() % 100;
        //流水号
        QueryWrapper<ProductPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("product_no");
        queryWrapper.eq("brand_id", productPo.getBrandId()).eq("product_category_id", productPo.getProductCategoryId());
        queryWrapper.orderByDesc("product_no");
        List<ProductPo> list = this.list(queryWrapper);
        if (list.size() > 0) {
            String serialNum = list.get(0).getProductNo().substring(-3, 0);
            productPo.setProductNo(brandVo.getBrandCode() + categoryPo.getCategoryCode() + year + (Integer.parseInt(serialNum) + 1));
        } else {
            productPo.setProductNo(brandVo.getBrandCode() + categoryPo.getCategoryCode() + year + "001");
        }
    }
}
