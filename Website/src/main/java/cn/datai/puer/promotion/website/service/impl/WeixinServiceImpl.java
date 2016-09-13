package cn.datai.puer.promotion.website.service.impl;


import cn.datai.puer.promotion.website.framework.entity.weixin.JsapiTicket;
import cn.datai.puer.promotion.website.framework.entity.weixin.WeixinUserToken;
import cn.datai.puer.promotion.website.service.WeixinService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class WeixinServiceImpl implements WeixinService {

    private Logger logger = LoggerFactory.getLogger(WeixinServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServletContext servletContext;

    @Override
    public void updateFromRemote(WeixinUserToken weixinUserToken, String appid) {

    }

    @Override
    public JsapiTicket refreshJsapiTicket(String weixinAccessToken) throws IOException {
        String url = (new StringBuffer("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="))
                .append(weixinAccessToken)
                .append("&type=jsapi")
                .toString();
        String jsapiTicketJson = restTemplate.getForObject(url, String.class);
        JsapiTicket jsapiTicket = (new ObjectMapper()).readValue(jsapiTicketJson, JsapiTicket.class);
//        redisTemplate.opsForValue().set("jsapi_ticket", (new ObjectMapper()).writeValueAsString(jsapiTicket), jsapiTicket.getExpires_in(), TimeUnit.SECONDS);
        servletContext.setAttribute("jsapiTicket", jsapiTicket.getTicket());
        logger.info("获取jsapi_ticket成功");
        return jsapiTicket;
    }

    @Override
    public String getJsapiTicket(HttpServletRequest request) throws IOException {

        String jsapiTicket = (String)request.getServletContext().getAttribute("jsapiTicket");

//        String jsapiTicketStr = redisTemplate.opsForValue().get("jsapi_ticket");
//        if (StringUtils.isNotBlank(jsapiTicketStr)) {
//            jsapiTicket = (new ObjectMapper()).readValue(jsapiTicketStr, JsapiTicket.class);
//        }
        return jsapiTicket;
    }

    @Override
    public Map<String, String> getJsApiSign(String wholeUrl, HttpServletRequest request) throws IOException {
        String jsapiTicketStr = this.getJsapiTicket(request);
        HashMap<String, String> ret = new HashMap<>();
        String nonceStr = createNonceStr();
        String timestamp = createTimestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapiTicketStr +
                "&noncestr=" + nonceStr +
                "&timestamp=" + timestamp +
                "&url=" + wholeUrl;
        System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", wholeUrl);
        ret.put("jsapiTicket", jsapiTicketStr);
        ret.put("nonceStr", nonceStr);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }


    private static String createNonceStr() {
        return UUID.randomUUID().toString();
    }

    private static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

}
