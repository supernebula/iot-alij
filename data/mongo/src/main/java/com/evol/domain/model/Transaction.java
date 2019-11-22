package com.evol.domain.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "transactions")
@Data
public class Transaction  implements Serializable {

    /// <summary>
    /// 充电ID
    /// </summary>
    private int Id;
    /// <summary>
    /// 订单号
    /// </summary>
    private String OrderNo;
    /// <summary>
    /// 用户名
    /// </summary>
    private String UserName;
    /// <summary>
    /// 用户ID
    /// </summary>
    private int UserId;
    /// <summary>
    /// 支付类型：1微信，2支付宝，3余额，4投币，5刷卡，6免费特权,7在线卡
    /// </summary>
    private int Ways;
    /// <summary>
    /// 设备ID
    /// </summary>
    private int DeviceId;
    /// <summary>
    /// 设备编号
    /// </summary>
    private String DeviceNumber;
    /// <summary>
    /// 设备路数
    /// </summary>
    private int DeviceWay = 0;
    /// <summary>
    /// 市代ID
    /// </summary>
    private int AgentId;
    /// <summary>
    /// 市代名称
    /// </summary>
    private String AgentName;
    /// <summary>
    /// 区代ID
    /// </summary>
    private int AreaAgentId;
    /// <summary>
    /// 区代名称
    /// </summary>
    private String AreaAgentName;
    /// <summary>
    /// 商家ID
    /// </summary>
    private int MerchantId;
    /// <summary>
    /// 商家名称
    /// </summary>
    private String MerchantName;
    /// <summary>
    /// 省
    /// </summary>
    private String Province;
    /// <summary>
    /// 市
    /// </summary>
    private String City;
    /// <summary>
    /// 区
    /// </summary>
    private String Country;
    /// <summary>
    /// 状态：0未成功，1成功，2退款
    /// </summary>
    private int State;
    /// <summary>
    /// 充值或是消费：1充值，2消费,3预约付款
    /// </summary>
    private int TransactionType;
    /// <summary>
    /// 预付金额
    /// </summary>
    private BigDecimal PrepayMoney;
    /// <summary>
    /// 充电金额
    /// </summary>
    private BigDecimal Money;

    private BigDecimal UsedMoney;
    /// <summary>
    /// 充电小时
    /// </summary>
    private double Hour;

    private BigDecimal Coupon;
    /// <summary>
    /// 红包
    /// </summary>
    private BigDecimal Bao;

    private int Source;
    /// <summary>
    /// 订单创建时间
    /// </summary>
    private Date CreateTime = new Date();
    /// <summary>
    /// 充电结束时间
    /// </summary>
    private Date EndTime;
    /// <summary>
    /// 错误代码1充满自停;2拔掉断电;3功率过大;4保险丝损坏;5:空载断电;6充电器/电池异常
    /// </summary>
    private int ErrorNum;
    /// <summary>
    /// 邀请码
    /// </summary>
    private String InvitationCode = "";
    /// <summary>
    /// 续充父ID
    /// </summary>
    private int TransId;
    /// <summary>
    /// 异步统计营业额 1 已结算，0未结算
    /// </summary>
    private int IsSettle;
    /// <summary>
    /// 订单类型：1充电桩，2充电柜
    ///
    /// </summary>
    private int DeviceType = 1;
    /// <summary>
    /// 充电柜类型订单用于电瓶是否已取出：1未取出，2已取出
    /// </summary>
    private int TranTakeOut = 1;
    /// <summary>
    /// 计费方式0：一口价；1：按电量计费；2：按功率计费
    /// </summary>
    private int BillingType = 0;
    /// <summary>
    /// 支付来源；0:投币刷卡；1:APP;2:小程序
    /// </summary>
    private int PaySource = 0;
    /// <summary>
    /// 线上卡卡号
    /// </summary>
    private String CardNumber = "1111";
    /// <summary>
    /// 预计电量
    /// </summary>
    private BigDecimal Electricity = new BigDecimal(0);


}
