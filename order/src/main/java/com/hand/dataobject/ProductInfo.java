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
@TableName("product_info")
public class ProductInfo implements Serializable {

	private static final long serialVersionUID = 5311274802958261767L;
	@TableId(value = "PRODUCT_ID")
	private String productId;
	private String productName;
	private BigDecimal productPrice;
    /**
     * 库存
     */
	private Integer productStock;
	private String productDescription;
	private Integer productStatus;
	private String productIcon;
	private Integer categoryType;
	private Date createTime;
	private Date updateTime;


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

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductIcon() {
		return productIcon;
	}

	public void setProductIcon(String productIcon) {
		this.productIcon = productIcon;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
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
		return "ProductInfo{" +
			", productId=" + productId +
			", productName=" + productName +
			", productPrice=" + productPrice +
			", productStock=" + productStock +
			", productDescription=" + productDescription +
			", productStatus=" + productStatus +
			", productIcon=" + productIcon +
			", categoryType=" + categoryType +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
