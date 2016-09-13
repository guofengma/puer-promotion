package cn.datai.puer.promotion.website.framework.system;


import cn.datai.puer.promotion.website.framework.annotation.Auth;
import cn.datai.puer.promotion.website.framework.entity.system.UserSessionInfo;
import cn.datai.puer.promotion.website.framework.entity.weixin.WeixinUserToken;
import cn.datai.puer.promotion.website.framework.enums.LoginUserType;
import cn.datai.puer.promotion.website.service.WeixinService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 微信登陆拦截器
 * 校验session中的weixinUser值是否为空,如果为空,则为未登录
 * 若未登录，则将页面重定向至微信授权链接，
 * 授权后，页面将继续跳转至之前访问的页面
 * 在拦截器中实现接受微信服务器发送过来的用户openid及能够获取其他信息令牌等相关信息。
 */
@Component
public class WeixinLoginInterceptor extends HandlerInterceptorAdapter{

    private static Logger logger = LoggerFactory.getLogger(WeixinLoginInterceptor.class);

    @Value("${weixin.appid}")
    private String APPID;

    @Value("${weixin.secret}")
    private String SECRET;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeixinService weixinService;


    private UserSessionInfo loginUser;

    private boolean passed;

    private boolean isPassed() {
        return passed;
    }

    private void setPassed(boolean passed) {
        this.passed = passed;
    }

    private UserSessionInfo getLoginUser() {
        return loginUser;
    }

    private void setLoginUser(UserSessionInfo loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HandlerMethod handler2 = (HandlerMethod) handler;
        Auth methodAnnotation = handler2.getMethodAnnotation(Auth.class);
        if (methodAnnotation == null) {
            setPassed(true);
            return isPassed();
        }

        if (request.getHeader("user-agent").indexOf("MicroMessenger") > 0) {
            //是微信浏览器， 给request的上下文中加入userAgent=MicroMessenger
            request.setAttribute("userAgent", "MicroMessenger");
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //上下文中包含微信浏览器这个参数
        if (StringUtils.isNotBlank((String)request.getAttribute("userAgent")) && request.getAttribute("userAgent").equals("MicroMessenger")) {
            modelAndView.addObject("weixinJsSign", weixinService.getJsApiSign(getOriginalUrl(request), request));

            HandlerMethod handler2 = (HandlerMethod) handler;
            Auth methodAnnotation = handler2.getMethodAnnotation(Auth.class);

            setPassed(false);

            HttpSession session = request.getSession();
            Map parameterMap = request.getParameterMap();

            LoginUserType[] loginUserTypes = methodAnnotation.loginUserType();
            loginUser = (UserSessionInfo) request.getSession().getAttribute("loginUser");
            LoginUserType loginUserType = loginUserTypes[0];
//            switch (loginUserType) {
//                case WEIXIN_BASE:
//                    setPassed(weixinBaseLogin(request, response));
//                case WEIXIN_USERINFO:
////              weixinUserinfoLogin();
//            }

        }
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 获取能够得到用户基本信息的令牌，令牌内容包含unionid， openid，过期时间等
     * @param appid
     * @param secret
     * @param code
     * @return
     */
    private WeixinUserToken getWeixinUserAuthInfo(String appid, String secret, String code, HttpServletRequest request, HttpServletResponse response) throws Exception {
        WeixinUserToken weixinUserToken = new WeixinUserToken();
        String o_auth_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        String requestUrl = o_auth_openid_url.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
        logger.debug("本地服务器向微信服务器发送获取用户令牌的请求：{}",  requestUrl);
        JSONObject jsonObject = null;
        try {
            jsonObject = this.httpClientGet(requestUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (jsonObject != null) {
            if (jsonObject.getInteger("errcode") != null) {
                if (jsonObject.getInteger("errcode") == 42003) {
                    logger.info("请求中虽然带有code， 但已超时，将重定向重新获取code");
                    toWeixinAuthPage(request, response);
                } else if (jsonObject.getInteger("errcode") == 40029) {
                    logger.info("请求中虽然带有code， 但无效，将重定向重新获取code");
                    toWeixinAuthPage(request,response);
                }else{
                    logger.error("获取微信服务器发来的用来获取用户信息的令牌失败，原因：{}, {}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
                    throw new Exception("获取微信服务器发来的用来获取用户信息的令牌失败，原因：" + jsonObject.getInteger("errcode") + "," + jsonObject.getString("errmsg"));
                }
            }

            jsonObject = convertToCamelKey(jsonObject);
            weixinUserToken = JSONObject.toJavaObject(jsonObject, WeixinUserToken.class);
            logger.debug("获取微信服务器发来的用来获取用户信息的令牌:{}", JSONObject.toJSONString(weixinUserToken));

        }
        return weixinUserToken;

    }


    /**
     * 微信
     * @return
     */
    private boolean weixinBaseLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Map<String, String[]> parameterMap = request.getParameterMap();
        boolean isPassed = false;
        logger.debug("该请求需要微信静默认证：" + request.getRequestURI());
        if (loginUser == null) {
            logger.debug("未找到用户session");
            if (parameterMap.containsKey("code") && parameterMap.containsKey("state")) {
                logger.debug("未找到用户session，但请求中包含code和state参数，可能为前端在重定向到微信认证页面认证成功后，回跳到此页面并附带上code和state值");
                String code = request.getParameter("code");
                String state = request.getParameter("state");
                logger.debug("微信认证后返回code:{}, state:{}", code, state);
                WeixinUserToken weixinUserAuthInfo = getWeixinUserAuthInfo(APPID, SECRET, code, request, response);
                loginUser = new UserSessionInfo();
                loginUser.setWeixinOpenId(weixinUserAuthInfo.getOpenid());
                loginUser.setWeixinUnionId(weixinUserAuthInfo.getUnionid());
                session.setAttribute("loginUser", loginUser);
                setPassed(true);
            }else{
                logger.debug("未找到用户session，且请求中未包含code和state参数，此请求是没有在微信那做为获取code的第一次认证");
                toWeixinAuthPage(request, response);
            }
        } else {
            setPassed(true);
        }
        return isPassed();
    }

    //TODO
    private boolean weixinUserinfoLogin() {
        return false;
    }


    /**
     * 重定向至微信认证页面，授权获取后一步所需的code
     * @param request
     * @param response
     * @throws IOException
     */
    private void toWeixinAuthPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authPage = buildWeixinOAuthUrl(getWholeURL(request)  , "null",
                request, "snsapi_base");
        logger.debug("返回用户浏览器重定向到微信服务器做第一次认证， redirect：{}", authPage);
        setPassed(false);
        response.sendRedirect(authPage);
    }

    /**
     * 构建微信认证地址
     * @param wholeURL 用户尝试请求的地址
     * @param state
     * @param request
     * @param weixinScopeType 微信授权类型 snsapi_base：静默授权， snsapi_userinfo：获取用户的基本信息，需要用户手动同意，并且由于用户同意过，所以无须关注，就可在授权后获取该用户的基本信息。
     * @return
     */
    private String buildWeixinOAuthUrl(String wholeURL, String state, HttpServletRequest request, String weixinScopeType) throws UnsupportedEncodingException {
        StringBuffer weixinAuthUrl = new StringBuffer("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
        weixinAuthUrl.append(this.APPID)
                .append("&redirect_uri=")
                .append(URLEncoder.encode(wholeURL, "utf-8"))
                .append("&response_type=code&scope=").append(weixinScopeType)
                .append("&state=")
                .append(state)
                .append("#wechat_redirect");
        return weixinAuthUrl.toString();
    }

//    /**
//     * 获取能够得到用户信息的令牌
//     * @param appid
//     * @param secret
//     * @param code
//     * @return
//     */
//    private WeixinUserToken getWeixinUserAuthInfo(String appid, String secret, String code) {
//        WeixinUserToken weixinUserToken = new WeixinUserToken();
//        String o_auth_openid_url = "https://api.weixin.qq" +
//                ".com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//        String requestUrl = o_auth_openid_url.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
//        logger.debug("本地服务器向微信服务器发送获取用户令牌的请求：" + requestUrl);
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = httpClientGet(requestUrl);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (jsonObject != null) {
//            jsonObject = DTJsonObject.convertToCamelKey(jsonObject);
//            weixinUserToken = DTJsonObject.toJavaObject(jsonObject, WeixinUserToken.class);
//            logger.debug("获取微信服务器发来的获取用户信息的令牌:{}", JSONObject.toJSONString(weixinUserToken));
//        }
//
//        return weixinUserToken;
//
//    }



//    /**
//     * 拿取code以后去微信服务器获取用户令牌
//     * @param appid
//     * @param secret
//     * @param code
//     * @return
//     * @throws IOException
//     */
//    private JSONObject getOAuthOpenId(String appid, String secret, String code) throws IOException {
//        Object oAuthInfo = null;
//        String o_auth_openid_url = "https://api.weixin.qq" +
//                ".com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
//        String requestUrl = o_auth_openid_url.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
//
//
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = httpClientGet(requestUrl);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return jsonObject;
//    }


    private class ServerData{
        private String redirectURL;

        public String getRedirectURL() {
            return redirectURL;
        }

        public void setRedirectURL(String redirectURL) {
            this.redirectURL = redirectURL;
        }
    }

    /**
     * 获取完整的url 包括请求参数
     * @return
     */
    private String getWholeURL(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
        for(String key : parameterMap.keySet()){
            if(!"code".equals(key) && !"state".equals(key)){
                uriComponentsBuilder.queryParam(key,parameterMap.get(key));
            }
        }
        return uriComponentsBuilder.build().toString();
    }
    public JSONObject httpClientGet(String requestUrl) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        CloseableHttpResponse response = null;
        JSONObject jsonObject = new JSONObject();
        try {
            response = client.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new Exception("失败!");
            }

            System.out.println(response.getStatusLine().toString());
            jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
            logger.info("获取用户令牌:{}", jsonObject.toJSONString());
            response.close();
            client.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 将微信的下划线keyname转换为驼峰类型 如：head_img_url-->headImgUrl
     * @param jsonObj
     * @return
     */
    public static JSONObject convertToCamelKey(JSONObject jsonObj) {
        Set<String> keys = jsonObj.keySet();
        Iterator<String> it = keys.iterator();
        JSONObject camelJsonObj = new JSONObject();
        while (it.hasNext()) {
            String key = it.next();
            String camelKey = toCamelStr(key);
            camelJsonObj.put(camelKey, jsonObj.get(key));
        }
        return camelJsonObj;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br> 例如：HELLO_WORLD->HelloWorld
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String toCamelStr(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }


    public String getOriginalUrl(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer(request.getScheme());
        sb.append("://").append(request.getServerName());
        if (request.getServerPort() != 80 && request.getServerPort() != 443) {
            sb.append(":" + request.getServerPort());
        }
        sb.append(request.getRequestURI());
        if (StringUtils.isNotBlank(request.getQueryString())) {
            sb.append("?").append(request.getQueryString());
        }
        return sb.toString();
    }


}
