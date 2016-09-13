package cn.datai.puer.promotion.website.sms;


import cn.datai.puer.promotion.website.utils.ConstantUtil;

/**
 * @description 短消息对象
 * @author H.CAAHN
 */
public class SmsMessage extends AbstractMessage {
    private String msmtemp;
    
    private String msmtempid;
    
    public String getType() {
        return ConstantUtil.CAPTCHA_TYPE_MOBILE;
    }
    
    public String getMsmtemp() {
        return msmtemp;
    }
    
    public void setMsmtemp(String msmtemp) {
        this.msmtemp = msmtemp;
    }
    
    public String getMsmtempid() {
        return msmtempid;
    }
    
    public void setMsmtempid(String msmtempid) {
        this.msmtempid = msmtempid;
    }
}
