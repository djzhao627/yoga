package com.fc.common.utils;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * @Author fengchi
 */
public class  PageUtils implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//分页参数-每页条数
	public static String limit = "limit";
	//分页参数-当前页码
	public static String offset = "offset";
	//分页参数-总分页数
	public static String page = "page";
	
	private int total;
	private List<?> rows;

	public PageUtils(List<?> list, long total) {
		this.rows = list;
		this.total = new Long(total).intValue();
	}

	public PageUtils(List<?> list, Query query){
		//获取页码参数
		PageInfo<?> pageInfo = new PageInfo<>(list, query.getLimit());
		//new PageUtils(pageInfo.getList(), pageInfo.getTotal());
		this.rows = list;
		this.total = new Long(pageInfo.getTotal()).intValue();
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
