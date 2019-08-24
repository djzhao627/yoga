package com.fc.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 会员信息表
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-19 21:40:52
 */
public class FcMemberManagementBaseinfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//姓名
	private String name;
	//客户类型
	private String type;
	//所属顾问
	private String consultants;
	//微信号
	private String wechat;
	//联系电话
	private String phone;
	//咨询课程
	private String consultingCourse;
	//是否住宿
	private String accommodation;
	//咨询日期
	private String advisoryDate;
	//所在省市
	private String address;
	//所属客服
	private String customerServic;
	//身份证号码
	private String sfzh;
	//数据来源
	private String dataSource;
	//证书编号
	private String certificateNumber;
	//备注
	private String bz;
	//插入时间
	private Date insertTime;
	//插入操作人id
	private Integer insertOperator;
	//更新时间
	private Date updateTime;
	//更新操作人id
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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：客户类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：客户类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：所属顾问
	 */
	public void setConsultants(String consultants) {
		this.consultants = consultants;
	}
	/**
	 * 获取：所属顾问
	 */
	public String getConsultants() {
		return consultants;
	}
	/**
	 * 设置：微信号
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * 获取：微信号
	 */
	public String getWechat() {
		return wechat;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：咨询课程
	 */
	public void setConsultingCourse(String consultingCourse) {
		this.consultingCourse = consultingCourse;
	}
	/**
	 * 获取：咨询课程
	 */
	public String getConsultingCourse() {
		return consultingCourse;
	}
	/**
	 * 设置：是否住宿
	 */
	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}
	/**
	 * 获取：是否住宿
	 */
	public String getAccommodation() {
		return accommodation;
	}
	/**
	 * 设置：咨询日期
	 */
	public void setAdvisoryDate(String advisoryDate) {
		this.advisoryDate = advisoryDate;
	}
	/**
	 * 获取：咨询日期
	 */
	public String getAdvisoryDate() {
		return advisoryDate;
	}
	/**
	 * 设置：所在省市
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：所在省市
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：所属客服
	 */
	public void setCustomerServic(String customerServic) {
		this.customerServic = customerServic;
	}
	/**
	 * 获取：所属客服
	 */
	public String getCustomerServic() {
		return customerServic;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getSfzh() {
		return sfzh;
	}
	/**
	 * 设置：数据来源
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * 获取：数据来源
	 */
	public String getDataSource() {
		return dataSource;
	}
	/**
	 * 设置：证书编号
	 */
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	/**
	 * 获取：证书编号
	 */
	public String getCertificateNumber() {
		return certificateNumber;
	}
	/**
	 * 设置：备注
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 获取：备注
	 */
	public String getBz() {
		return bz;
	}
	/**
	 * 设置：插入时间
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	/**
	 * 获取：插入时间
	 */
	public Date getInsertTime() {
		return insertTime;
	}
	/**
	 * 设置：插入操作人id
	 */
	public void setInsertOperator(Integer insertOperator) {
		this.insertOperator = insertOperator;
	}
	/**
	 * 获取：插入操作人id
	 */
	public Integer getInsertOperator() {
		return insertOperator;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：更新操作人id
	 */
	public void setUpdateOperator(Integer updateOperator) {
		this.updateOperator = updateOperator;
	}
	/**
	 * 获取：更新操作人id
	 */
	public Integer getUpdateOperator() {
		return updateOperator;
	}
}
