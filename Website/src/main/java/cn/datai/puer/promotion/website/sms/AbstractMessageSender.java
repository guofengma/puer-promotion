package cn.datai.puer.promotion.website.sms;

import org.apache.commons.lang.StringUtils;


/**
 * @description 抽象的消息发送器
 * @author H.CAAHN
 */
public abstract class AbstractMessageSender implements IMessageSender {
    /** 指定的发送HOST地址 */
    protected String submitUrl;
    
    /** 帐号 */
    protected String account;
    
    /** 密码 */
    protected String password;
    
    /** 是否开启发送 */
    protected boolean        open;
    
    
    public void setSubmitUrl(String submitUrl) {
        this.submitUrl = submitUrl;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setOpen(String open) {
        if (StringUtils.isNotBlank(open)) {
            this.open = Boolean.valueOf(open);
        }
    }
}
