package com.fc.crm.vo;

import java.io.Serializable;


/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-10-02 15:20:41
 */
public class CourseMemberVO {

	//
	private Integer id;
	//课程id
	private Integer courseId;
	//会员id
	private String memberIds;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 会员名称
	 */
	private String memberName ;

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
	 * 设置：课程id
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程id
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * 设置：会员id
	 */
	public void setMemberId(String memberIds) {
		this.memberIds = memberIds;
	}
	/**
	 * 获取：会员id
	 */
	public String getMemberIds() {
		return memberIds;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
