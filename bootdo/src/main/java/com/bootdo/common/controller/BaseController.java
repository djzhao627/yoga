package com.bootdo.common.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}


	/**
	 * 获取域名url(http://...:.../)
	 * @return
	 */
	public String getDomainUrl() {
		HttpServletRequest request = this.getRequest();
		String domainUrl = request.getRequestURL().toString();
		String contextName = request.getContextPath();
		int index = domainUrl.indexOf(contextName);
		domainUrl=domainUrl.substring(0, index);
		return domainUrl;
	}
	
	/**
	 * 获取域名url(http://...:.../ProjectName)
	 * @return
	 */
	public String getDomainPath(){
		HttpServletRequest request = this.getRequest();
		return this.getDomainUrl() + request.getContextPath();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	public PageUtils getPageList(Map<String, Object> params , IPageDefine pageDefine){
		PageUtils pageUtils = null;
        try {
        	//获取分页参数(格式：{limit=10, offset=0} )
			Query query = Query.getPageParams(params);

			//查询分页列表数据
			List<?> dictList = pageDefine.getPageRows(query);
			
			//获取页码参数
			pageUtils = new PageUtils(dictList, query);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
        return pageUtils;
	}
}