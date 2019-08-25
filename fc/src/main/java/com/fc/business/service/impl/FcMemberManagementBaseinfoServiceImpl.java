package com.fc.business.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.business.dao.FcMemberManagementBaseinfoDao;
import com.fc.business.domain.FcMemberManagementBaseinfoDO;
import com.fc.business.service.FcMemberManagementBaseinfoService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class FcMemberManagementBaseinfoServiceImpl implements FcMemberManagementBaseinfoService {
    @Autowired
    private FcMemberManagementBaseinfoDao fcMemberManagementBaseinfoDao;

    @Override
    public FcMemberManagementBaseinfoDO get(Integer id) {
        return fcMemberManagementBaseinfoDao.get(id);
    }

    @Override
    public List<FcMemberManagementBaseinfoDO> list(Map<String, Object> map) {
        return fcMemberManagementBaseinfoDao.list(map);
    }

    @Override
    public List<Map<String, Object>> findDatas(Map<String, Object> map) {
        List<Map<String, Object>> list = fcMemberManagementBaseinfoDao.findDatas(map);
        return list;
    }

    @Override
    public int save(FcMemberManagementBaseinfoDO fcMemberManagementBaseinfo) {
        String customerServic = fcMemberManagementBaseinfo.getCustomerServic();
        String consultants = fcMemberManagementBaseinfo.getConsultants();
        if (StringUtils.isNotBlank(customerServic)) {
            fcMemberManagementBaseinfo.setCustomerServic(customerServic.substring(0, customerServic.lastIndexOf(",")));
        }
        if (StringUtils.isNotBlank(consultants)) {
            fcMemberManagementBaseinfo.setConsultants(consultants.substring(0, consultants.lastIndexOf(",")));
        }
        return fcMemberManagementBaseinfoDao.save(fcMemberManagementBaseinfo);
    }

    @Override
    public int update(FcMemberManagementBaseinfoDO fcMemberManagementBaseinfo) {
        String customerServic = fcMemberManagementBaseinfo.getCustomerServic();
        String consultants = fcMemberManagementBaseinfo.getConsultants();
        if (StringUtils.isNotBlank(customerServic)) {
            fcMemberManagementBaseinfo.setCustomerServic(customerServic.substring(0, customerServic.lastIndexOf(",")));
        }
        if (StringUtils.isNotBlank(consultants)) {
            fcMemberManagementBaseinfo.setConsultants(consultants.substring(0, consultants.lastIndexOf(",")));
        }
        return fcMemberManagementBaseinfoDao.update(fcMemberManagementBaseinfo);
    }

    @Override
    public int remove(Integer id) {
        return fcMemberManagementBaseinfoDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return fcMemberManagementBaseinfoDao.batchRemove(ids);
    }

}
