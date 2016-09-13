package cn.datai.puer.promotion.website.framework.enums;

/**
 * 登录的用户类型
 */
public enum LoginUserType {
    /**
     * 微信静默登录（ 不获取用户信息，只拿openid，用户无感知）
     */
    WEIXIN_BASE,

    /**
     * 微信用户登录（除了获取openid，还需要用户基础信息, 需要用户点击授权按钮）
     */
    WEIXIN_USERINFO;


    private LoginUserType() {
    }

    

}