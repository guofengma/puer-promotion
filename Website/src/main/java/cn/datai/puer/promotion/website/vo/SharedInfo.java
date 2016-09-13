package cn.datai.puer.promotion.website.vo;

import java.io.Serializable;
import java.util.Date;

public class SharedInfo implements Serializable {
    public static final long serialVersionUID = 1315071360L;

    /**
     * 被分享信息ID(自生成，uuid): SHARED_INFO.SHARED_ID
     * @author MyBatis Generator
     */
    private String sharedId;

    /**
     * 分享信息ID: SHARED_INFO.SHARE_ID
     * @author MyBatis Generator
     */
    private String shareId;

    /**
     * 新用户手机号(被分享人): SHARED_INFO.SHARED_PHONE
     * @author MyBatis Generator
     */
    private String sharedPhone;

    /**
     * 所属会员单位: SHARED_INFO.MEMBER_ID
     * @author MyBatis Generator
     */
    private String memberId;

    /**
     * 被分享时间: SHARED_INFO.SHARED_TIME
     * @author MyBatis Generator
     */
    private Date sharedTime;

    /**
     * 开户时间: SHARED_INFO.OPEN_ACCOUNT_TIME
     * @author MyBatis Generator
     */
    private Date openAccountTime;

    /**
     * 开户状态: SHARED_INFO.OPEN_ACCOUNT_STATUS
     * @author MyBatis Generator
     */
    private String openAccountStatus;

    /**
     * 被分享渠道(1.微信，2.QQ，3.QQ空间，4.微博，5.其他): SHARED_INFO.SHARE_CHANNEL
     * @author MyBatis Generator
     */
    private String shareChannel;

    /**
     * 签名: SHARED_INFO.SIGN
     * @author MyBatis Generator
     */
    private String sign;

    /**
     * 获取被分享信息ID(自生成，uuid): SHARED_INFO.SHARED_ID
     * @return 被分享信息ID(自生成，uuid): SHARED_INFO.SHARED_ID
     * @author MyBatis Generator
     */
    public String getSharedId() {
        return sharedId;
    }

    /**
     * 设置被分享信息ID(自生成，uuid): SHARED_INFO.SHARED_ID
     * @param sharedId 映射数据库字段: SHARED_INFO.SHARED_ID
     * @author MyBatis Generator
     */
    public void setSharedId(String sharedId) {
        this.sharedId = sharedId == null ? null : sharedId.trim();
    }

    /**
     * 获取分享信息ID: SHARED_INFO.SHARE_ID
     * @return 分享信息ID: SHARED_INFO.SHARE_ID
     * @author MyBatis Generator
     */
    public String getShareId() {
        return shareId;
    }

    /**
     * 设置分享信息ID: SHARED_INFO.SHARE_ID
     * @param shareId 映射数据库字段: SHARED_INFO.SHARE_ID
     * @author MyBatis Generator
     */
    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    /**
     * 获取新用户手机号(被分享人): SHARED_INFO.SHARED_PHONE
     * @return 新用户手机号(被分享人): SHARED_INFO.SHARED_PHONE
     * @author MyBatis Generator
     */
    public String getSharedPhone() {
        return sharedPhone;
    }

    /**
     * 设置新用户手机号(被分享人): SHARED_INFO.SHARED_PHONE
     * @param sharedPhone 映射数据库字段: SHARED_INFO.SHARED_PHONE
     * @author MyBatis Generator
     */
    public void setSharedPhone(String sharedPhone) {
        this.sharedPhone = sharedPhone == null ? null : sharedPhone.trim();
    }

    /**
     * 获取所属会员单位: SHARED_INFO.MEMBER_ID
     * @return 所属会员单位: SHARED_INFO.MEMBER_ID
     * @author MyBatis Generator
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置所属会员单位: SHARED_INFO.MEMBER_ID
     * @param memberId 映射数据库字段: SHARED_INFO.MEMBER_ID
     * @author MyBatis Generator
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取被分享时间: SHARED_INFO.SHARED_TIME
     * @return 被分享时间: SHARED_INFO.SHARED_TIME
     * @author MyBatis Generator
     */
    public Date getSharedTime() {
        return sharedTime;
    }

    /**
     * 设置被分享时间: SHARED_INFO.SHARED_TIME
     * @param sharedTime 映射数据库字段: SHARED_INFO.SHARED_TIME
     * @author MyBatis Generator
     */
    public void setSharedTime(Date sharedTime) {
        this.sharedTime = sharedTime;
    }

    /**
     * 获取开户时间: SHARED_INFO.OPEN_ACCOUNT_TIME
     * @return 开户时间: SHARED_INFO.OPEN_ACCOUNT_TIME
     * @author MyBatis Generator
     */
    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    /**
     * 设置开户时间: SHARED_INFO.OPEN_ACCOUNT_TIME
     * @param openAccountTime 映射数据库字段: SHARED_INFO.OPEN_ACCOUNT_TIME
     * @author MyBatis Generator
     */
    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    /**
     * 获取开户状态: SHARED_INFO.OPEN_ACCOUNT_STATUS
     * @return 开户状态: SHARED_INFO.OPEN_ACCOUNT_STATUS
     * @author MyBatis Generator
     */
    public String getOpenAccountStatus() {
        return openAccountStatus;
    }

    /**
     * 设置开户状态: SHARED_INFO.OPEN_ACCOUNT_STATUS
     * @param openAccountStatus 映射数据库字段: SHARED_INFO.OPEN_ACCOUNT_STATUS
     * @author MyBatis Generator
     */
    public void setOpenAccountStatus(String openAccountStatus) {
        this.openAccountStatus = openAccountStatus == null ? null : openAccountStatus.trim();
    }

    /**
     * 获取被分享渠道(1.微信，2.QQ，3.QQ空间，4.微博，5.其他): SHARED_INFO.SHARE_CHANNEL
     * @return 被分享渠道(1.微信，2.QQ，3.QQ空间，4.微博，5.其他): SHARED_INFO.SHARE_CHANNEL
     * @author MyBatis Generator
     */
    public String getShareChannel() {
        return shareChannel;
    }

    /**
     * 设置被分享渠道(1.微信，2.QQ，3.QQ空间，4.微博，5.其他): SHARED_INFO.SHARE_CHANNEL
     * @param shareChannel 映射数据库字段: SHARED_INFO.SHARE_CHANNEL
     * @author MyBatis Generator
     */
    public void setShareChannel(String shareChannel) {
        this.shareChannel = shareChannel == null ? null : shareChannel.trim();
    }

    /**
     * 获取签名: SHARED_INFO.SIGN
     * @return 签名: SHARED_INFO.SIGN
     * @author MyBatis Generator
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置签名: SHARED_INFO.SIGN
     * @param sign 映射数据库字段: SHARED_INFO.SIGN
     * @author MyBatis Generator
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }
}