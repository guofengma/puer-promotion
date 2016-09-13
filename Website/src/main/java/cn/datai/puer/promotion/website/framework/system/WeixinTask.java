package cn.datai.puer.promotion.website.framework.system;

import cn.datai.puer.promotion.website.framework.entity.weixin.JsapiTicket;
import cn.datai.puer.promotion.website.framework.entity.weixin.WeixinToken;
import cn.datai.puer.promotion.website.service.WeixinService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created by zhangyutao on 2016/6/27.
 */
public class WeixinTask {

    @Value("${weixin.appid}")
    private String appid;

    @Value("${weixin.secret}")
    private String secret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private WeixinService weixinService;

    private Logger logger = LoggerFactory.getLogger(WeixinTask.class);

    public WeixinToken refreshToken() {
        try {
            StringBuffer apiURL = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&&appid=");
            apiURL.append(this.appid)
                    .append("&secret=")
                    .append(this.secret);
            String tokenJson = restTemplate.getForObject(apiURL.toString(), String.class);
            logger.debug("获取微信服务器令牌：{}", tokenJson);
            ObjectMapper jsonMapper = new ObjectMapper();
            WeixinToken weixinToken = jsonMapper.readValue(tokenJson, WeixinToken.class);
//            redisTemplate.opsForValue().set("weixinToken", weixinToken.getAccessToken(), Long.parseLong(weixinToken.getExpiresIn()), TimeUnit.SECONDS);
            servletContext.setAttribute("weixinToken", weixinToken.getAccessToken());
            logger.info("刷新微信服务器令牌成功");
            JsapiTicket jsapiTicket = this.refreshJsapiTicket();
            logger.info("刷新jsapiTicket成功");
            return weixinToken;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        return null;
    }


    public JsapiTicket refreshJsapiTicket() throws IOException {
        String weixinToken = (String)servletContext.getAttribute("weixinToken");
        return weixinService.refreshJsapiTicket(weixinToken);
    }

}
