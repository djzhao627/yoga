package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 17:11:28
 */
public class EmployeeInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//手机号
	private String phonenumber;
	//身份证号码
	private String idcard;
	//民族
	private String nation;
	//户口类型
	private String hukoutype;
	//婚姻状况
	private String maritalstatus;
	//紧急联系人
	private String emergencycontact;
	//紧急联系人号码
	private String emergencycontactphone;
	//最高学历
	private String highestdegree;
	//毕业院校
	private String graduateschool;
	//专业
	private String professional;
	//毕业时间
	private String graduatiotime;
	//学历性质
	private String natureacademicqualifications;
	//参加工作时间
	private String joinworktime;
	//入司时间
	private String entercompanytime;
	//工作岗位
	private String operatpost;
	//职位
	private String jobposition;
	//任职时间
	private String durationemptime;
	//政治面貌
	private String politicallandscape;

	/**
	 * 设置：手机号
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdcard() {
		return idcard;
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
	public void setHukoutype(String hukoutype) {
		this.hukoutype = hukoutype;
	}
	/**
	 * 获取：户口类型
	 */
	public String getHukoutype() {
		return hukoutype;
	}
	/**
	 * 设置：婚姻状况
	 */
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	/**
	 * 获取：婚姻状况
	 */
	public String getMaritalstatus() {
		return maritalstatus;
	}
	/**
	 * 设置：紧急联系人
	 */
	public void setEmergencycontact(String emergencycontact) {
		this.emergencycontact = emergencycontact;
	}
	/**
	 * 获取：紧急联系人
	 */
	public String getEmergencycontact() {
		return emergencycontact;
	}
	/**
	 * 设置：紧急联系人号码
	 */
	public void setEmergencycontactphone(String emergencycontactphone) {
		this.emergencycontactphone = emergencycontactphone;
	}
	/**
	 * 获取：紧急联系人号码
	 */
	public String getEmergencycontactphone() {
		return emergencycontactphone;
	}
	/**
	 * 设置：最高学历
	 */
	public void setHighestdegree(String highestdegree) {
		this.highestdegree = highestdegree;
	}
	/**
	 * 获取：最高学历
	 */
	public String getHighestdegree() {
		return highestdegree;
	}
	/**
	 * 设置：毕业院校
	 */
	public void setGraduateschool(String graduateschool) {
		this.graduateschool = graduateschool;
	}
	/**
	 * 获取：毕业院校
	 */
	public String getGraduateschool() {
		return graduateschool;
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
	public void setGraduatiotime(String graduatiotime) {
		this.graduatiotime = graduatiotime;
	}
	/**
	 * 获取：毕业时间
	 */
	public String getGraduatiotime() {
		return graduatiotime;
	}
	/**
	 * 设置：学历性质
	 */
	public void setNatureacademicqualifications(String natureacademicqualifications) {
		this.natureacademicqualifications = natureacademicqualifications;
	}
	/**
	 * 获取：学历性质
	 */
	public String getNatureacademicqualifications() {
		return natureacademicqualifications;
	}
	/**
	 * 设置：参加工作时间
	 */
	public void setJoinworktime(String joinworktime) {
		this.joinworktime = joinworktime;
	}
	/**
	 * 获取：参加工作时间
	 */
	public String getJoinworktime() {
		return joinworktime;
	}
	/**
	 * 设置：入司时间
	 */
	public void setEntercompanytime(String entercompanytime) {
		this.entercompanytime = entercompanytime;
	}
	/**
	 * 获取：入司时间
	 */
	public String getEntercompanytime() {
		return entercompanytime;
	}
	/**
	 * 设置：工作岗位
	 */
	public void setOperatpost(String operatpost) {
		this.operatpost = operatpost;
	}
	/**
	 * 获取：工作岗位
	 */
	public String getOperatpost() {
		return operatpost;
	}
	/**
	 * 设置：职位
	 */
	public void setJobposition(String jobposition) {
		this.jobposition = jobposition;
	}
	/**
	 * 获取：职位
	 */
	public String getJobposition() {
		return jobposition;
	}
	/**
	 * 设置：任职时间
	 */
	public void setDurationemptime(String durationemptime) {
		this.durationemptime = durationemptime;
	}
	/**
	 * 获取：任职时间
	 */
	public String getDurationemptime() {
		return durationemptime;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setPoliticallandscape(String politicallandscape) {
		this.politicallandscape = politicallandscape;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getPoliticallandscape() {
		return politicallandscape;
	}
}
