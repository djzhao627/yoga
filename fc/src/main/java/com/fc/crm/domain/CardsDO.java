package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-28 21:47:46
 */
public class CardsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//会员id
	private Integer memberId;
	//卡类型
	private String cardType;
	//适用课程类型
	private String courseType;
	//开始时间
	private String startTime;
	//截止时间
	private String endTime;
	//状态
	private String status;

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
	 * 设置：会员id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：卡类型
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * 获取：卡类型
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * 设置：适用课程类型
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	/**
	 * 获取：适用课程类型
	 */
	public String getCourseType() {
		return courseType;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：截止时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：截止时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
}
