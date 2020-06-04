package com.emall.emallmanageplat.mapper;

import com.emall.emallmanageplat.entity.po.ProductsPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ES关键字模糊查询
 */
public interface ESProductMapper extends ElasticsearchRepository<ProductsPo, Long> {
    /**
     * @param name         商品名称
     * @param subTitle     商品副标题
     * @param detailTitle  商品详情标题
     * @return
     */
    Page<ProductsPo> findByNameOrSubTitleOrDetailsTitle(String name, String subTitle, String detailTitle, Pageable page);
}
