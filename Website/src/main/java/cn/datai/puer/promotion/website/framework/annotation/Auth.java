package cn.datai.puer.promotion.website.framework.annotation;



import cn.datai.puer.promotion.website.framework.enums.LoginUserType;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Auth {

    /**
     * 用户类型
     * @return
     */
    LoginUserType[] loginUserType() default {LoginUserType.WEIXIN_BASE};

}
