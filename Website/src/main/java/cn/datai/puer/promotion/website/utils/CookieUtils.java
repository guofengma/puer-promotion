package cn.datai.puer.promotion.website.utils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    private static final int OVER_TIME = 50*365*24*60*60;//50年

    public static final String  USER_FALG = "user_flag_";

    /**
     * 获得指定cookie中的值
     *
     * @param request
     * @param cookieName
     *            要查找的cookie的名字
     * @return 返回指定Cookie中的字符串值
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {

        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 找到指定的cookie
                if (cookie != null && cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 设置指定cookie中的值
     */
    public static void setCookie(HttpServletRequest request,HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(OVER_TIME);// 设置Cookie的存活时间
        //cookie.setPath(request.getServletContext().getContextPath());
        response.addCookie(cookie);// 保存cookie
    }

}