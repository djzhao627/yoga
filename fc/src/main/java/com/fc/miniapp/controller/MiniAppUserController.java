package com.fc.miniapp.controller;

import com.fc.common.utils.JSONUtils;
import com.fc.common.utils.R;
import com.fc.miniapp.service.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 小程序用户相关的控制器
 *
 * @author djzhao
 * @date 19/10/02 17:05
 */
@Controller
@RequestMapping("/miniapp")
public class MiniAppUserController {

    @Autowired
    private WxService wxService;

    private Logger logger = LoggerFactory.getLogger(MiniAppUserController.class);

    @ResponseBody
    @RequestMapping("/wxAuth")
    public R wxAuth(String code) {
        String wxSession = wxService.getWxSession(code);

        if(null == wxSession){
            return R.error();
        }

        Map<String, Object> map = JSONUtils.jsonToMap(wxSession);
        logger.info(map.toString());
        return R.ok(map);
    }

}
