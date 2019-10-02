package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-10-02 15:20:41
 */
public class CourseMemberDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//课程id
	private Integer courseId;
	//会员id
	private Integer memberId;
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
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getMemberId() {
		return memberId;
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
