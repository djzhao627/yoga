package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 16:30:50
 */
public class CoursePackagesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//门店id
	private String deptId;
	//套餐名称
	private String packageName;
	//副标题
	private String subtitle;
	//课程Ids
	private String courseIds;
	//商品Ids
	private String goodsIds;
	//套餐价格
	private Float totalPrice;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：门店id
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：门店id
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：套餐名称
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	/**
	 * 获取：套餐名称
	 */
	public String getPackageName() {
		return packageName;
	}
	/**
	 * 设置：副标题
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	/**
	 * 获取：副标题
	 */
	public String getSubtitle() {
		return subtitle;
	}
	/**
	 * 设置：课程Ids
	 */
	public void setCourseIds(String courseIds) {
		this.courseIds = courseIds;
	}
	/**
	 * 获取：课程Ids
	 */
	public String getCourseIds() {
		return courseIds;
	}
	/**
	 * 设置：商品Ids
	 */
	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}
	/**
	 * 获取：商品Ids
	 */
	public String getGoodsIds() {
		return goodsIds;
	}
	/**
	 * 设置：套餐价格
	 */
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 获取：套餐价格
	 */
	public Float getTotalPrice() {
		return totalPrice;
	}
}
