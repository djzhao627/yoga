package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-27 21:40:02
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String sfzh;
	//
	private String initialTraining;
	//
	private String paymentDate;
	//
	private String paymentType;
	//
	private String paymentMode;
	//
	private Float paymentAccount;
	//
	private String book;
	//
	private String clothes;
	//
	private String scheduleDate;
	//
	private String scheduleCampus;
	//
	private Float otherFees;
	//
	private String enrollmentCourse;
	//
	private Date insertTime;
	//
	private Integer insertOperator;
	//
	private Date updateTime;
	//
	private Integer updateOperator;

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
	 * 设置：
	 */
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	/**
	 * 获取：
	 */
	public String getSfzh() {
		return sfzh;
	}
	/**
	 * 设置：
	 */
	public void setInitialTraining(String initialTraining) {
		this.initialTraining = initialTraining;
	}
	/**
	 * 获取：
	 */
	public String getInitialTraining() {
		return initialTraining;
	}
	/**
	 * 设置：
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * 获取：
	 */
	public String getPaymentDate() {
		return paymentDate;
	}
	/**
	 * 设置：
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * 获取：
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * 设置：
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * 获取：
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * 设置：
	 */
	public void setPaymentAccount(Float paymentAccount) {
		this.paymentAccount = paymentAccount;
	}
	/**
	 * 获取：
	 */
	public Float getPaymentAccount() {
		return paymentAccount;
	}
	/**
	 * 设置：
	 */
	public void setBook(String book) {
		this.book = book;
	}
	/**
	 * 获取：
	 */
	public String getBook() {
		return book;
	}
	/**
	 * 设置：
	 */
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	/**
	 * 获取：
	 */
	public String getClothes() {
		return clothes;
	}
	/**
	 * 设置：
	 */
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	/**
	 * 获取：
	 */
	public String getScheduleDate() {
		return scheduleDate;
	}
	/**
	 * 设置：
	 */
	public void setScheduleCampus(String scheduleCampus) {
		this.scheduleCampus = scheduleCampus;
	}
	/**
	 * 获取：
	 */
	public String getScheduleCampus() {
		return scheduleCampus;
	}
	/**
	 * 设置：
	 */
	public void setOtherFees(Float otherFees) {
		this.otherFees = otherFees;
	}
	/**
	 * 获取：
	 */
	public Float getOtherFees() {
		return otherFees;
	}
	/**
	 * 设置：
	 */
	public void setEnrollmentCourse(String enrollmentCourse) {
		this.enrollmentCourse = enrollmentCourse;
	}
	/**
	 * 获取：
	 */
	public String getEnrollmentCourse() {
		return enrollmentCourse;
	}
	/**
	 * 设置：
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	/**
	 * 获取：
	 */
	public Date getInsertTime() {
		return insertTime;
	}
	/**
	 * 设置：
	 */
	public void setInsertOperator(Integer insertOperator) {
		this.insertOperator = insertOperator;
	}
	/**
	 * 获取：
	 */
	public Integer getInsertOperator() {
		return insertOperator;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateOperator(Integer updateOperator) {
		this.updateOperator = updateOperator;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdateOperator() {
		return updateOperator;
	}
}
