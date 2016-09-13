package cn.datai.puer.promotion.website.controller.basic;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import cn.datai.puer.promotion.website.vo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class BaseController implements ApplicationContextAware {

    /** spring应用上下文 */
    protected ApplicationContext context;

    @Autowired
    private HttpServletRequest request;


    public static UserInfo getLoginUser(HttpSession session){
        UserInfo loginUser = (UserInfo) session.getAttribute("loginUser");
        return loginUser;
    }

    public static void setLoginUser(UserInfo userInfo, HttpSession session){
        session.setAttribute("loginUser", userInfo);
    }

    /**
     * spring在装配所有bean的时候会装入一个spring应用上下文。
     */
    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }

    public String getOriginalUrl() {
        StringBuffer sb = new StringBuffer(this.request.getScheme());
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
