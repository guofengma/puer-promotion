package cn.datai.puer.promotion.website.sms.rsp;

/**
 * @description 短消息返回编码
 * @author H.CAAHN
 */
public enum ResultCode {
    /** 成功, 飞拓0#1#1 */
    SUCCESS,
    
    /** 失败, 飞拓100 */
    FAIL_REMOTE,
    
    /** 帐号或密码错误, 飞拓101 */
    FAIL_ACCOUNT_AUTH,
    
    /** 帐号已禁用, 飞拓102 */
    FAIL_ACCOUNT_FREEZE,
    
    /** 参数不正确, 飞拓103 */
    FAIL_ARGS,
    
    /** 提交过于频繁, 飞拓104 */
    FAIL_FREQUENT,
    
    /** 短信内容超长, 为空, 格式不正确, 飞拓105 */
    FAIL_CONTENT,
    
    /** 手机号码不合法, 飞拓106 */
    FAIL_MOBILENO,
    
    /** 余额不足, 飞拓108 */
    FAIL_BALANCE,
    
    /** IP错误, 飞拓109 */
    FAIL_IP,
    
    /** 敏感内容或关键字, 飞拓110# */
    FAIL_KEYWORD,
    
    /** 模版短信不存在, 飞拓114 */
    FAIL_TEMPLATE,
    
    /** 签名标签不存在, 飞拓115 */
    FAIL_SIGN,
    
    /** 接口返回为空 */
    ERR_RESULT_EMPTY,
    
    /** 接口返回未定义 */
    ERR_RESULT_UNDEFINE,
    
    /** 关闭短信接口 */
    ERR_CLOSE,
    
    /** 远程调用失败 */
    ERR_REMOTE
}
