/*
 * Copyright (c)  2019 Hiylo Org. All rights reserved
 * Project: components
 * File: MenuManager.java
 * Data: 1/11/19 1:07 PM
 * Author: hiylo
 */

package org.hiylo.components.wechat;

import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.hiylo.components.commons.utils.HttpClient;
import org.hiylo.components.fentity.vo.ReturnVO;
import org.hiylo.components.fentity.vo.menu.Button;
import org.hiylo.components.fentity.vo.menu.ComplexButton;
import org.hiylo.components.fentity.vo.menu.Menu;
import org.hiylo.components.fentity.vo.menu.ViewButton;
import org.hiylo.components.wechat.config.WechatConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Objects;

@Component
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);
    @Autowired
    private WechatConfig wxAppPayConfig;
    private HttpClient httpClient = new HttpClient();
    @Autowired
    public WechatPublicAccountConstants constants;
    private Gson gson = new Gson();

    /**
     * 创建菜单
     * @param baseUrl 基础的Url
     * @return 菜单对象
     * @throws UnsupportedEncodingException 字符集异常
     */
    // TODO 替换URL
    public Menu createMenu(String baseUrl) throws UnsupportedEncodingException {

        ViewButton btn13 = new ViewButton();
        btn13.setName("首页");
        btn13.setType("view");
        btn13.setUrl(baseUrl + "/produce/index");// Constants.Weixin.RequestUrl.GET_USER_AUTHORIZATION.replace("REDIRECT_URI",
        // URLEncoder.encode(baseUrl + "/produce/index"))

        ViewButton btn21 = new ViewButton();
        btn21.setName("我的购物车");
        btn21.setType("view");
        btn21.setUrl(constants.getUserAuthorizationUrl(URLEncoder.encode(baseUrl + "/order/list", "UTF-8")));

        ViewButton btn31 = new ViewButton();
        btn31.setType("view");
        btn31.setName("添加用户");
        btn31.setUrl(constants.getUserAuthorizationUrl(URLEncoder.encode(baseUrl + "/member/toAddUser", "UTF-8")));

        ViewButton btn32 = new ViewButton();
        btn32.setName("激活用户");
        btn32.setType("view");
        btn32.setUrl(constants.getUserAuthorizationTokenUrl(URLEncoder.encode(baseUrl + "/member/toActiveUser", "UTF-8")));
        ViewButton btn33 = new ViewButton();
        btn33.setName("积分中心");
        btn33.setType("view");
        btn33.setUrl(constants.getUserAuthorizationUrl(
                URLEncoder.encode(baseUrl + "/member/toPointRecord", "UTF-8")));
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("我的商城");

        mainBtn1.setSub_button(new Button[]{btn13});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("购物车");
        mainBtn2.setSub_button(new Button[]{btn21});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("个人中心");
        mainBtn3.setSub_button(new Button[]{btn31, btn32, btn33});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});
        return menu;
    }

    /**
     * 上传菜单设置
     *
     * @param menu 菜单对象
     * @param accessToken 服务端accessToken
     * @return 是否成功
     */
    public boolean createMenu(Menu menu, String accessToken) {

        String jsonMenu = JSONObject.fromObject(menu).toString();
        String requestUrl = constants.createMenu(accessToken);
        String jsonObject = httpClient.httpsRequest(requestUrl, "POST", jsonMenu);
        return Objects.nonNull(jsonObject) && gson.fromJson(jsonObject, ReturnVO.class).getErrcode() == 0;
    }

    /**
     * 获取当前菜单
     *
     * @param accessToken 服务端accessToken
     * @return 菜单的json字符串
     */
    public String getMenu(String accessToken) {
        String result = null;
        String requestUrl = constants.getMenu(accessToken);
        String jsonObject = httpClient.httpsRequest(requestUrl, "GET", null);

        if (Objects.nonNull(jsonObject)) {
            result = jsonObject;
        }
        return result;
    }

    /**
     * 删除菜单
     * @param accessToken
     * @return
     */
    public boolean deleteMenu(String accessToken) {
        String requestUrl = constants.deleteMenu(accessToken);
        String jsonObject = httpClient.httpsRequest(requestUrl, "GET", null);
        return Objects.nonNull(jsonObject) && gson.fromJson(jsonObject, ReturnVO.class).getErrcode() == 0;
    }
}
