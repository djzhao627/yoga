package com.bootdo.common.controller;

import java.util.List;

import com.bootdo.common.utils.Query;

public interface IPageDefine {
	
	List<?> getPageRows(Query query);
}
