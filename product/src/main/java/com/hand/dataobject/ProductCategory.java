package com.hand.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
@TableName("product_category")
public class ProductCategory implements Serializable {


	private static final long serialVersionUID = 94043025556889777L;
	@TableId(value="category_id")
	private Integer categoryId;
	private String categoryName;
    /**
     * 类目编号
     */
	private Integer categoryType;
	private Date createTime;
	private Date updateTime;


	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
		return "ProductCategory{" +
			", categoryId=" + categoryId +
			", categoryName=" + categoryName +
			", categoryType=" + categoryType +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
