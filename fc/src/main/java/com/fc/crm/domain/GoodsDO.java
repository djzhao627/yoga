package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-08 14:56:30
 */
public class GoodsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//门店id
	private String deptId;
	//标题
	private String title;
	//副标题
	private String subTitle;
	//价格，存入时x100
	private Integer price;
	//商品详情
	private String detail;
	//图片url
	private String image;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：副标题
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	/**
	 * 获取：副标题
	 */
	public String getSubTitle() {
		return subTitle;
	}
	/**
	 * 设置：价格，存入时x100
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * 获取：价格，存入时x100
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * 设置：商品详情
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：商品详情
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：图片url
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：图片url
	 */
	public String getImage() {
		return image;
	}
}
