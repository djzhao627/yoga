package com.fc.common.controller;

import java.util.List;

import com.fc.common.utils.Query;

public interface IPageDefine {

    List<?> getPageRows(Query query);
}
