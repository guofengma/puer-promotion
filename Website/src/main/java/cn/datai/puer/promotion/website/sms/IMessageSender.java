package cn.datai.puer.promotion.website.sms;


import cn.datai.puer.promotion.website.sms.rsp.MessageResponse;

/**
 * @description 消息发送器
 * @author H.CAAHN
 */
public interface IMessageSender {
    /**
     * 发送消息
     * @param message
     * @return
     * @throws Exception
     */
    public MessageResponse send(AbstractMessage message) throws Exception;
    
    public void callback(MessageResponse rsp);
    
    public void callbackException(String id);
    
    /**
     * 消息发送器所能处理的消息类型
     * @return
     */
    public String getType();
    
    /**
     * 判断消息发送器是否被关闭
     * @return
     */
    public boolean testOpen();
}
