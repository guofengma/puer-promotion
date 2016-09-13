package cn.datai.puer.promotion.website.sms;

/**
 * @description 抽象的消息, 如短信(SmsMessage), 邮件(EmailMessage)
 * @author H.CAAHN
 */
public abstract class AbstractMessage {
    private String id;
    
    private String address;
    
    private String content;

    private int    maxcount;

    private int    retry;
    
    private long   createtime;
    
    private int    mininterval;
    
    public abstract String getType();
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public long getCreatetime() {
        return createtime;
    }
    
    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public int getMaxcount() {
        return maxcount;
    }

    public void setMaxcount(int maxcount) {
        this.maxcount = maxcount;
    }

    public int getRetry() {
        return retry;
    }
    
    public void increaseRetry() {
        ++retry;
    }

    public int getMininterval() {
        return mininterval;
    }

    public void setMininterval(int mininterval) {
        this.mininterval = mininterval;
    }
    
    
}
