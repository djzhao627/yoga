package com.fc.miniapp.service;

import com.fc.common.utils.HttpRequest;
import com.fc.miniapp.properties.WxAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 与微信服务器通信的服务层
 *
 * @author djzhao
 * @date 19/10/02 17:56
 */
@Service
public class WxService {
    @Autowired
    private WxAuth wxAuth;

    /**
     * 根据小程序登录返回的code获取openid和session_key
     *
     * @param jsCode 小程序返回的code
     * @return openid和session_key
     */
    public String getWxSession(String jsCode) {
        String sb = "appid=" + wxAuth.getAppId() +
                "&secret=" + wxAuth.getSecret() +
                "&js_code=" + jsCode +
                "&grant_type=" + wxAuth.getGrantType();
        String res = HttpRequest.sendGet(wxAuth.getSessionHost(), sb);
        if (res.equals("")) {
            return null;
        }
        return res;
    }
}
