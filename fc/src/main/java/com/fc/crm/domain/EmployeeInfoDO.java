package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 23:08:50
 */
public class EmployeeInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//手机号
	private String phoneNumber;
	//身份证号码
	private String idCard;
	//民族
	private String nation;
	//户口类型
	private String huKouType;
	//婚姻状况
	private String maritalStatus;
	//紧急联系人
	private String emergencyContact;
	//紧急联系人号码
	private String emergencyContactPhone;
	//最高学历
	private String highestDegree;
	//毕业院校
	private String graduateSchool;
	//专业
	private String professional;
	//毕业时间
	private String graduationTime;
	//学历性质
	private String natureAcademicQualifications;
	//参加工作时间
	private String joinWorkTime;
	//入司时间
	private String enterCompanyTime;
	//工作岗位
	private String workPost;
	//职位
	private String jobPosition;
	//任职时间
	private String durationEmpTime;
	//政治面貌
	private String politicalLandscape;

	/**
	 * 设置：手机号
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：民族
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**
	 * 获取：民族
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 设置：户口类型
	 */
	public void setHuKouType(String huKouType) {
		this.huKouType = huKouType;
	}
	/**
	 * 获取：户口类型
	 */
	public String getHuKouType() {
		return huKouType;
	}
	/**
	 * 设置：婚姻状况
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	/**
	 * 获取：婚姻状况
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * 设置：紧急联系人
	 */
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	/**
	 * 获取：紧急联系人
	 */
	public String getEmergencyContact() {
		return emergencyContact;
	}
	/**
	 * 设置：紧急联系人号码
	 */
	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}
	/**
	 * 获取：紧急联系人号码
	 */
	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}
	/**
	 * 设置：最高学历
	 */
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	/**
	 * 获取：最高学历
	 */
	public String getHighestDegree() {
		return highestDegree;
	}
	/**
	 * 设置：毕业院校
	 */
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	/**
	 * 获取：毕业院校
	 */
	public String getGraduateSchool() {
		return graduateSchool;
	}
	/**
	 * 设置：专业
	 */
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	/**
	 * 获取：专业
	 */
	public String getProfessional() {
		return professional;
	}
	/**
	 * 设置：毕业时间
	 */
	public void setGraduationTime(String graduationTime) {
		this.graduationTime = graduationTime;
	}
	/**
	 * 获取：毕业时间
	 */
	public String getGraduationTime() {
		return graduationTime;
	}
	/**
	 * 设置：学历性质
	 */
	public void setNatureAcademicQualifications(String natureAcademicQualifications) {
		this.natureAcademicQualifications = natureAcademicQualifications;
	}
	/**
	 * 获取：学历性质
	 */
	public String getNatureAcademicQualifications() {
		return natureAcademicQualifications;
	}
	/**
	 * 设置：参加工作时间
	 */
	public void setJoinWorkTime(String joinWorkTime) {
		this.joinWorkTime = joinWorkTime;
	}
	/**
	 * 获取：参加工作时间
	 */
	public String getJoinWorkTime() {
		return joinWorkTime;
	}
	/**
	 * 设置：入司时间
	 */
	public void setEnterCompanyTime(String enterCompanyTime) {
		this.enterCompanyTime = enterCompanyTime;
	}
	/**
	 * 获取：入司时间
	 */
	public String getEnterCompanyTime() {
		return enterCompanyTime;
	}
	/**
	 * 设置：工作岗位
	 */
	public void setWorkPost(String workPost) {
		this.workPost = workPost;
	}
	/**
	 * 获取：工作岗位
	 */
	public String getWorkPost() {
		return workPost;
	}
	/**
	 * 设置：职位
	 */
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	/**
	 * 获取：职位
	 */
	public String getJobPosition() {
		return jobPosition;
	}
	/**
	 * 设置：任职时间
	 */
	public void setDurationEmpTime(String durationEmpTime) {
		this.durationEmpTime = durationEmpTime;
	}
	/**
	 * 获取：任职时间
	 */
	public String getDurationEmpTime() {
		return durationEmpTime;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setPoliticalLandscape(String politicalLandscape) {
		this.politicalLandscape = politicalLandscape;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getPoliticalLandscape() {
		return politicalLandscape;
	}
}
