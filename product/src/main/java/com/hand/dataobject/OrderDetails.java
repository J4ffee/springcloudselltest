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
@TableName("order_details")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 2096894827883313542L;
	@TableId(value = "DETAIL_ID")
	private String detailId;
	private String orderId;
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer productQuantity;
	private String productIcon;
	private Date createTime;
	private Date updateTime;


	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductIcon() {
		return productIcon;
	}

	public void setProductIcon(String productIcon) {
		this.productIcon = productIcon;
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
		return "OrderDetails{" +
			", detailId=" + detailId +
			", orderId=" + orderId +
			", productId=" + productId +
			", productName=" + productName +
			", productPrice=" + productPrice +
			", productQuantity=" + productQuantity +
			", productIcon=" + productIcon +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
