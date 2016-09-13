package cn.datai.puer.promotion.website.framework.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 针对非微信浏览器拦截
 */
public class WeixinAgentInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(WeixinAgentInterceptor.class);

    @Value("${system.puerAppDownloadPage}")
    private String PUER_APP_DOWNLOAD_PAGE;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userAgent = request.getHeader("user-agent");
        if (userAgent.indexOf("MicroMessenger") > 0) {
            logger.debug("该请求来自微信浏览器");
            return true;
        } else {
            logger.debug("该请求来自非微信浏览器");
            response.sendRedirect(PUER_APP_DOWNLOAD_PAGE);
            return false;
        }

    }
}
