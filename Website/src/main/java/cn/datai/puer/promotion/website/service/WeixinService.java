package cn.datai.puer.promotion.website.service;




import cn.datai.puer.promotion.website.framework.entity.weixin.JsapiTicket;
import cn.datai.puer.promotion.website.framework.entity.weixin.WeixinUserToken;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 微信服务
 */
public interface WeixinService {

    /**
     * 从微信服务器获取微信用户信息,并更新本地数据库
     * @param weixinUserToken
     * @param appid
     */
    void updateFromRemote(WeixinUserToken weixinUserToken, String appid);

    /**
     * 刷新jsapi_ticket，并缓存
     */
    JsapiTicket refreshJsapiTicket(String weixinAccessToken) throws IOException;


    /**
     * 从缓存获取jsapi_ticket
     * @return
     * @throws IOException
     */
    String getJsapiTicket(HttpServletRequest request) throws IOException;

    /**
     * 获取jsapi 所需签名信息
     * @return
     * @param wholeUrl
     */
    Map<String, String> getJsApiSign(String wholeUrl, HttpServletRequest request) throws IOException;
}
