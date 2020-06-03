package com.emall.emallmanageplat.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ES模糊查询
 */
public interface ESProductMapper extends ElasticsearchRepository<ProductsPo, Long> {
    /**
     * @param name         商品名称
     * @param subTitle     商品副标题
     * @param detailTitle  商品详情标题
     * @return
     */
    Page<ProductsPo> findByNameOrSubTileOrDetailsTitle(String name, String subTitle, String detailTitle);
}
