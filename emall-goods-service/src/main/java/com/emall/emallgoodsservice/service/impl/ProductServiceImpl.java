package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.form.FullPromotionForm;
import com.emall.emallgoodsentity.entity.form.MemberPriceForm;
import com.emall.emallgoodsentity.entity.form.ProductForm;
import com.emall.emallgoodsentity.entity.form.ProductSkuForm;
import com.emall.emallgoodsentity.entity.params.ProductParam;
import com.emall.emallgoodsentity.entity.po.*;
import com.emall.emallgoodsentity.entity.vo.BrandVo;
import com.emall.emallgoodsentity.entity.vo.ProductDetailsVo;
import com.emall.emallgoodsentity.entity.vo.ProductParamsVo;
import com.emall.emallgoodsentity.entity.vo.ProductVo;
import com.emall.emallgoodsservice.mapper.ProductMapper;
import com.emall.emallgoodsservice.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPo> implements IProductService {

    //    @Autowired
//    private ESProductMapper esProductMapper;
    @Autowired
    private IProductSkuService productSkuService;
    @Autowired
    private IMemberPriceService memberPriceService;
    @Autowired
    private IFullPromotionService fullPromotionService;
    @Autowired
    private IProductAttributeParamsService productAttributeParamsService;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private IProductCategoryService productCategoryService;

    @Override
    public IPage<ProductVo> getProductByCondition(IPage page, ProductParam productParam) {
        QueryWrapper<ProductPo> queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(productParam.getName()), "name", productParam.getName());
        queryWrapper.eq(productParam.getBrandId() != null, "brand_id", productParam.getBrandId());
        queryWrapper.eq(productParam.getProductCategoryId() != null, "product_category_id", productParam.getProductCategoryId());
        queryWrapper.ge(productParam.getCreatedTimeStart() != null, "created_time", productParam.getCreatedTimeStart());
        queryWrapper.le(productParam.getCreatedTimeEnd() != null, "created_time", productParam.getCreatedTimeEnd());
        queryWrapper.eq(productParam.getPromotionType() != null, "promotion_type", productParam.getPromotionType());
        queryWrapper.eq(productParam.getNewStatus() != null, "new_status", productParam.getNewStatus());
        queryWrapper.eq(productParam.getDeleteStatus() != null, "delete_status", productParam.getDeleteStatus());
        queryWrapper.eq(productParam.getPublishStatus() != null, "publish_status", productParam.getPublishStatus());
        IPage<ProductPo> productPos = this.page(page, queryWrapper);
        //处理图片
        productPos.getRecords().forEach(productPo -> {
            if (!productPo.getAlbumPics().isEmpty()) {
                productPo.setAlbumPics(productPo.getAlbumPics().split(",")[0]);
            }
        });
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
            productForm.getFullPromotionForms().stream().forEach(productFullPromotionForm -> {
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
        List<ProductAttributeParamsPo> productAttributeParamsPos = new ArrayList<>();
        productForm.getProdcutAttributeParams().stream().forEach(productParamsVo -> {
            ProductAttributeParamsPo po = new ProductAttributeParamsPo();
            po.setProductId(productId);
            po.setAttributeValue(String.join(",", productParamsVo.getParamValue()));
            po.setAttributeId(productParamsVo.getParamId());
            productAttributeParamsPos.add(po);
        });
        productAttributeParamsService.insertBatch(productAttributeParamsPos);
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
     * 根据商品表id更新商品状态【新老款状态，推荐状态，上下架状态，活动状态】
     *
     * @param productId
     * @param status
     * @param type
     * @return
     */
    @Override
    public boolean updateProductStatus(Long productId, Integer status, String type) {
        UpdateWrapper<ProductPo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", productId).set(type, status);
        return this.update(updateWrapper);
    }

    /**
     * 根据商品id获取商品详情
     *
     * @param productId
     * @return
     */
    @Override
    public ProductDetailsVo getProductDetailsById(Long productId) {
        ProductDetailsVo productDetailsVo = new ProductDetailsVo();
        ProductPo productPo = this.getById(productId);
        BeanUtils.copyProperties(productPo, productDetailsVo);
        int promotionType = productPo.getPromotionType();
        //构建促销模块
        if (promotionType == 2) {   //会员价格
            List<MemberPricePo> memberPricePos = memberPriceService.selectMemberPriceByProductId(productId);
            List<MemberPriceForm> memberPriceForms = memberPricePos.stream().map(memberPricePo -> {
                MemberPriceForm memberPriceForm = new MemberPriceForm();
                memberPriceForm.setMemberLevelName(memberPricePo.getMemberLevelName());
                memberPriceForm.setMemberPrice(memberPricePo.getMemberPrice());
                memberPriceForm.setRankId(memberPricePo.getRankId());
                return memberPriceForm;
            }).collect(Collectors.toList());
            productDetailsVo.setMemberPriceForms(memberPriceForms);
        } else if (promotionType == 3) {  //满减价格
            List<FullPromotionPo> fullPromotionPos = fullPromotionService.selectFullPromotionByProductId(productId);
            List<FullPromotionForm> fullPromotionForms = fullPromotionPos.stream().map(fullPromotionPo -> {
                FullPromotionForm fullPromotionForm = new FullPromotionForm();
                fullPromotionForm.setFullPrice(fullPromotionPo.getFullPrice());
                fullPromotionForm.setReducePrice(fullPromotionPo.getReducePrice());
                return fullPromotionForm;
            }).collect(Collectors.toList());
            productDetailsVo.setFullPromotionForms(fullPromotionForms);
        }

        //sku数据
        List<ProductSkuPo> skuPos = productSkuService.getSkuListByProductId(productId);
        List<ProductSkuForm> productSkuForms = skuPos.stream().map(productSkuPo -> {
            ProductSkuForm productSkuForm = new ProductSkuForm();
            //逗号隔开的图片转为字符串数组
            productSkuForm.setPicture(productSkuPo.getPicture().split(","));
            BeanUtils.copyProperties(productSkuPo, productSkuForm);
            return productSkuForm;
        }).collect(Collectors.toList());
        productDetailsVo.setProductSkus(productSkuForms);

        //构建属性参数
        List<ProductAttributeParamsPo> paramsPos = productAttributeParamsService.selectByProductId(productId);
        List<ProductParamsVo> paramsVos = paramsPos.stream().map(po -> {
            ProductParamsVo vo = new ProductParamsVo();
            vo.setParamId(po.getAttributeId());
            vo.setParamValue(po.getAttributeValue().split(","));
            return vo;
        }).collect(Collectors.toList());
        productDetailsVo.setProdcutAttributeParams(paramsVos);

        return productDetailsVo;
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
            String serialNum = list.get(0).getProductNo().substring(list.get(0).getProductNo().length() - 3);
            productPo.setProductNo(brandVo.getBrandCode() + categoryPo.getCategoryCode() + year + (Integer.parseInt(serialNum) + 1));
        } else {
            productPo.setProductNo(brandVo.getBrandCode() + categoryPo.getCategoryCode() + year + "001");
        }
    }
}
