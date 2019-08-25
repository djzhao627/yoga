package com.fc.common.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.github.pagehelper.PageHelper;

/**
 * 查询参数
 */
public class Query extends R {
	private static final long serialVersionUID = 1L;
	// 当前页码
	private Integer offset;
	// 每页条数
	private Integer limit;

	public Query(Map<String, Object> params) {
		this.putAll(params);
		// 分页参数
		if(null==params.get("offset")){
			this.offset = null;
		}else{
			this.offset = Integer.parseInt(params.get("offset").toString());	
		}
		if(null==params.get("limit")){
			this.limit = 0;
		}else{
			this.limit = Integer.parseInt(params.get("limit").toString());	
		}
		
		this.put(PageUtils.offset, offset);
		this.put(PageUtils.page, (this.offset == null || this.offset == 0)? 0: (this.offset / limit + 1) );
		this.put(PageUtils.limit, limit);
	}
	
	public static Query getPageParams(Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		
		//分页参数
		if(query.get(PageUtils.page)!= null && query.get(PageUtils.limit)!= null){
			PageHelper.startPage((int)query.getOrDefault(PageUtils.page, 0), (int)query.getOrDefault(PageUtils.limit, 0));
		}
		return query;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.put("offset", offset);
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
