package com.hand.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
@TableName("order_master")
public class OrderMaster implements Serializable {

	private static final long serialVersionUID = -6315005868234659116L;
	@TableId(value = "ORDER_ID")
	private String orderId;
	private String buyerName;
	private String buyerPhone;
	private String buyerAddress;
	private String buyerOpenid;
    /**
     * 总金额
     */
	private BigDecimal orderAmount;
    /**
     * 订单状态
     */
	private Integer orderStatus;
    /**
     * 支付状态 0 未支付
     */
	private Integer payStatus;
	private Date createTime;
	private Date updateTime;


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerOpenid() {
		return buyerOpenid;
	}

	public void setBuyerOpenid(String buyerOpenid) {
		this.buyerOpenid = buyerOpenid;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "OrderMaster{" +
			", orderId=" + orderId +
			", buyerName=" + buyerName +
			", buyerPhone=" + buyerPhone +
			", buyerAddress=" + buyerAddress +
			", buyerOpenid=" + buyerOpenid +
			", orderAmount=" + orderAmount +
			", orderStatus=" + orderStatus +
			", payStatus=" + payStatus +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
