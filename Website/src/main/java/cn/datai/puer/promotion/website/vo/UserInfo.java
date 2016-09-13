package cn.datai.puer.promotion.website.vo;

import java.math.BigDecimal;

public class UserInfo {
    /**
     * 用户id(自增长): user_info.USER_INFO_ID
     * @author MyBatis Generator
     */
    private Long userInfoId;

    /**
     * 普通用户的标识，对当前公众号唯一: user_info.OPENID
     * @author MyBatis Generator
     */
    private String openid;

    /**
     * 用于业务登陆的唯一性标识，不含中文字符: user_info.USERNAME
     * @author MyBatis Generator
     */
    private String username;

    /**
     * 经过加密的密码: user_info.PASSWORD
     * @author MyBatis Generator
     */
    private String password;

    /**
     * 手机号: user_info.PHONE_NUM
     * @author MyBatis Generator
     */
    private String phoneNum;

    /**
     * 账户余额: user_info.ACCOUNT_BALANCE
     * @author MyBatis Generator
     */
    private BigDecimal accountBalance;

    /**
     * 获取用户id(自增长): user_info.USER_INFO_ID
     * @return 用户id(自增长): user_info.USER_INFO_ID
     * @author MyBatis Generator
     */
    public Long getUserInfoId() {
        return userInfoId;
    }

    /**
     * 设置用户id(自增长): user_info.USER_INFO_ID
     * @param userInfoId 映射数据库字段: user_info.USER_INFO_ID
     * @author MyBatis Generator
     */
    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * 获取普通用户的标识，对当前公众号唯一: user_info.OPENID
     * @return 普通用户的标识，对当前公众号唯一: user_info.OPENID
     * @author MyBatis Generator
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置普通用户的标识，对当前公众号唯一: user_info.OPENID
     * @param openid 映射数据库字段: user_info.OPENID
     * @author MyBatis Generator
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取用于业务登陆的唯一性标识，不含中文字符: user_info.USERNAME
     * @return 用于业务登陆的唯一性标识，不含中文字符: user_info.USERNAME
     * @author MyBatis Generator
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用于业务登陆的唯一性标识，不含中文字符: user_info.USERNAME
     * @param username 映射数据库字段: user_info.USERNAME
     * @author MyBatis Generator
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取经过加密的密码: user_info.PASSWORD
     * @return 经过加密的密码: user_info.PASSWORD
     * @author MyBatis Generator
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置经过加密的密码: user_info.PASSWORD
     * @param password 映射数据库字段: user_info.PASSWORD
     * @author MyBatis Generator
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取手机号: user_info.PHONE_NUM
     * @return 手机号: user_info.PHONE_NUM
     * @author MyBatis Generator
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置手机号: user_info.PHONE_NUM
     * @param phoneNum 映射数据库字段: user_info.PHONE_NUM
     * @author MyBatis Generator
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * 获取账户余额: user_info.ACCOUNT_BALANCE
     * @return 账户余额: user_info.ACCOUNT_BALANCE
     * @author MyBatis Generator
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * 设置账户余额: user_info.ACCOUNT_BALANCE
     * @param accountBalance 映射数据库字段: user_info.ACCOUNT_BALANCE
     * @author MyBatis Generator
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}