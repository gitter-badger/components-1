/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : RealNameAuthentication.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.hiylo.components.commons.vo.JuheRealNameAuthenticationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

/**
 * @author hiylo
 * @date 2017年10月19日 08:09:34
 */
@Slf4j
@Component
public class RealNameAuthentication {
    @Value("${juhe.key: }")
    private String key;
    private String host = "http://op.juhe.cn/idcard/query";
    private HttpClient httpClient = new HttpClient();
    private Gson gson = new Gson();

    //{"reason":"成功 ","result":{"realname":"范军","idcard":"610124197802165117","res":1},"error_code":0}
    public boolean authentication(String realname, String cardcode) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("Key should must be set");
        }
        try {
            String params = "?key={{key}}&idcard={{cardcode}}&realname={{realname}}";
            params = params.replace("{{key}}", key).replace("{{cardcode}}", cardcode).replace("{{realname}}", URLEncoder.encode(realname, "UTF-8"));
            String responseText = httpClient.get(host + params);
            log.debug(responseText == null ? "entity 为空" : responseText);
            if (Objects.nonNull(responseText)) {
                JuheRealNameAuthenticationResponse response = gson.fromJson(responseText, JuheRealNameAuthenticationResponse.class);
                return Objects.nonNull(response) && Objects.nonNull(response.getResult()) && response.getResult().getRes() == 1;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
