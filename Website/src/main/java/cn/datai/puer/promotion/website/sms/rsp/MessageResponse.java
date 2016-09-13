package cn.datai.puer.promotion.website.sms.rsp;


import cn.datai.puer.promotion.website.sms.AbstractMessage;

/**
 * @description 消息处理结果
 * @author H.CAAHN
 */
public class MessageResponse {
    protected AbstractMessage message;
    
    protected String rspstr;
    
    protected ResultCode      result;
    
    public String getRspstr() {
        return rspstr;
    }
    
    public void setRspstr(String rspstr) {
        this.rspstr = rspstr;
    }
    
    public ResultCode getResult() {
        return result;
    }
    
    public void setResult(ResultCode result) {
        this.result = result;
    }
    
    public AbstractMessage getMessage() {
        return message;
    }
    
    public void setMessage(AbstractMessage message) {
        this.message = message;
    }
}
