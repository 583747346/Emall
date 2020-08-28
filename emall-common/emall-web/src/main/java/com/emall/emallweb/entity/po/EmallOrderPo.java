package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BaseProcessPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("订单信息实体")
@TableName("emall_order")
public class EmallOrderPo extends BaseProcessPo {

    @ApiModelProperty(value = "id", name = "id")
    @TableId(type = IdType.ID_WORKER_STR)
    private Long id;
    @ApiModelProperty(value = "会员账号", name = "username")
    private String username;
    @ApiModelProperty(value = "优惠券id", name = "coupon_id")
    private String couponId;
    @ApiModelProperty(value = "订单编号", name = "order_no")
    private String orderNo;
    @ApiModelProperty(value = "订单总金额", name = "total_amount")
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "应付金额（实际支付金额）", name = "pay_amount")
    private BigDecimal payAmount;
    @ApiModelProperty(value = "运费金额", name = "freight_amount")
    private BigDecimal freightAmount;
    @ApiModelProperty(value = "积分抵扣金额", name = "points_amount")
    private BigDecimal pointsAmount;
    @ApiModelProperty(value = "优惠券抵扣金额", name = "coupon_amount")
    private BigDecimal couponAmount;
    @ApiModelProperty(value = "支付方式：未支付(0)-支付宝(1)-微信(2)-银联(3)", name = "pay_type")
    private Integer payType;
    @ApiModelProperty(value = "订单来源：小程序(0)-app订单(1)-PC端(2)", name = "source_type")
    private Integer sourceType;
    @ApiModelProperty(value = "订单状态：待付款(0)-待发货(1)-已发货(2)-已完成(3)-已关闭(4)-无效订单(5)", name = "order_status")
    private Integer orderStatus;
    @ApiModelProperty(value = "订单类型：0->正常订单；1->秒杀订单", name = "order_type")
    private Integer orderType;
    @ApiModelProperty(value = "物流公司(配送方式)", name = "delivery_company")
    private String deliveryCompany;
    @ApiModelProperty(value = "物流单号", name = "delivery_sn")
    private String deliverySn;
    @ApiModelProperty(value = "自动确认时间（天）", name = "auto_confirm_day")
    private String autoConfirmDay;
    @ApiModelProperty(value = "可以获得的积分", name = "obtain_points")
    private Integer obtainPoints;
    @ApiModelProperty(value = "可以活动的成长值", name = "growth_points")
    private Integer growthPoints;
    @ApiModelProperty(value = "活动信息", name = "promotion_info")
    private String promotionInfo;
    @ApiModelProperty(value = "发票类型：0->不开发票；1->电子发票；2->纸质发票", name = "bill_type")
    private Integer billType;
    @ApiModelProperty(value = "发票抬头", name = "bill_header")
    private String billHeader;
    @ApiModelProperty(value = "发票内容", name = "bill_content")
    private String billContent;
    @ApiModelProperty(value = "收票人电话", name = "bill_receiver_phone")
    private String billReceiver_phone;
    @ApiModelProperty(value = "收票人邮箱", name = "bill_receiver_email")
    private String billReceiverEmail;
    @ApiModelProperty(value = "收货人姓名", name = "receiver_name")
    private String receiverName;
    @ApiModelProperty(value = "收货人电话", name = "receiver_phone")
    private String receiverPhone;
    @ApiModelProperty(value = "收货人邮编", name = "receiver_post_code")
    private String receiverPost_code;
    @ApiModelProperty(value = "省份/直辖市", name = "receiver_province")
    private String receiverProvince;
    @ApiModelProperty(value = "城市", name = "receiver_city")
    private String receiverCity;
    @ApiModelProperty(value = "区", name = "receiver_region")
    private String receiverRegion;
    @ApiModelProperty(value = "详细地址", name = "receiver_detail_address")
    private String receiverDetailAddress;
    @ApiModelProperty(value = "订单备注", name = "note")
    private String note;
    @ApiModelProperty(value = "确认收货状态：0->未确认；1->已确认", name = "confirm_status")
    private Integer confirmStatus;
    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除", name = "delete_status")
    private Integer deleteStatus;
    @ApiModelProperty(value = "下单时使用的积分", name = "use_points")
    private Integer usePoints;
    @ApiModelProperty(value = "支付时间", name = "payment_time")
    private Date paymentTime;
    @ApiModelProperty(value = "发货时间", name = "delivery_time")
    private Date deliveryTime;
    @ApiModelProperty(value = "确认收货时间", name = "receive_time")
    private Date receiveTime;
    @ApiModelProperty(value = "评价时间", name = "comment_time")
    private Date commentTime;


}
