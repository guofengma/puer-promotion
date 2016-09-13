package cn.datai.puer.promotion.website.vo;

import java.io.Serializable;
import java.util.Date;

public class ShareInfo implements Serializable {
    public static final long serialVersionUID = 1981315264L;

    /**
     * 分享信息表（自生成，uuid）: SHARE_INFO.SHARE_ID
     * @author MyBatis Generator
     */
    private String shareId;

    /**
     * 分享人手机号: SHARE_INFO.SHARE_PHONE
     * @author MyBatis Generator
     */
    private String sharePhone;

    /**
     * 分享人所属会员单位ID: SHARE_INFO.SHARE_MEMBER_ID
     * @author MyBatis Generator
     */
    private String shareMemberId;

    /**
     * 分享人开户的账号: SHARE_INFO.SHARE_ACCOUNT
     * @author MyBatis Generator
     */
    private String shareAccount;

    /**
     * 分享人姓名: SHARE_INFO.SHARE_NAME
     * @author MyBatis Generator
     */
    private String shareName;

    /**
     * 分享的URL: SHARE_INFO.SHARE_URL
     * @author MyBatis Generator
     */
    private String shareUrl;

    /**
     * 分享时间(生成连接的时间): SHARE_INFO.SHARE_TIME
     * @author MyBatis Generator
     */
    private Date shareTime;

    /**
     * 获取分享信息表（自生成，uuid）: SHARE_INFO.SHARE_ID
     * @return 分享信息表（自生成，uuid）: SHARE_INFO.SHARE_ID
     * @author MyBatis Generator
     */
    public String getShareId() {
        return shareId;
    }

    /**
     * 设置分享信息表（自生成，uuid）: SHARE_INFO.SHARE_ID
     * @param shareId 映射数据库字段: SHARE_INFO.SHARE_ID
     * @author MyBatis Generator
     */
    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    /**
     * 获取分享人手机号: SHARE_INFO.SHARE_PHONE
     * @return 分享人手机号: SHARE_INFO.SHARE_PHONE
     * @author MyBatis Generator
     */
    public String getSharePhone() {
        return sharePhone;
    }

    /**
     * 设置分享人手机号: SHARE_INFO.SHARE_PHONE
     * @param sharePhone 映射数据库字段: SHARE_INFO.SHARE_PHONE
     * @author MyBatis Generator
     */
    public void setSharePhone(String sharePhone) {
        this.sharePhone = sharePhone == null ? null : sharePhone.trim();
    }

    /**
     * 获取分享人所属会员单位ID: SHARE_INFO.SHARE_MEMBER_ID
     * @return 分享人所属会员单位ID: SHARE_INFO.SHARE_MEMBER_ID
     * @author MyBatis Generator
     */
    public String getShareMemberId() {
        return shareMemberId;
    }

    /**
     * 设置分享人所属会员单位ID: SHARE_INFO.SHARE_MEMBER_ID
     * @param shareMemberId 映射数据库字段: SHARE_INFO.SHARE_MEMBER_ID
     * @author MyBatis Generator
     */
    public void setShareMemberId(String shareMemberId) {
        this.shareMemberId = shareMemberId == null ? null : shareMemberId.trim();
    }

    /**
     * 获取分享人开户的账号: SHARE_INFO.SHARE_ACCOUNT
     * @return 分享人开户的账号: SHARE_INFO.SHARE_ACCOUNT
     * @author MyBatis Generator
     */
    public String getShareAccount() {
        return shareAccount;
    }

    /**
     * 设置分享人开户的账号: SHARE_INFO.SHARE_ACCOUNT
     * @param shareAccount 映射数据库字段: SHARE_INFO.SHARE_ACCOUNT
     * @author MyBatis Generator
     */
    public void setShareAccount(String shareAccount) {
        this.shareAccount = shareAccount == null ? null : shareAccount.trim();
    }

    /**
     * 获取分享人姓名: SHARE_INFO.SHARE_NAME
     * @return 分享人姓名: SHARE_INFO.SHARE_NAME
     * @author MyBatis Generator
     */
    public String getShareName() {
        return shareName;
    }

    /**
     * 设置分享人姓名: SHARE_INFO.SHARE_NAME
     * @param shareName 映射数据库字段: SHARE_INFO.SHARE_NAME
     * @author MyBatis Generator
     */
    public void setShareName(String shareName) {
        this.shareName = shareName == null ? null : shareName.trim();
    }

    /**
     * 获取分享的URL: SHARE_INFO.SHARE_URL
     * @return 分享的URL: SHARE_INFO.SHARE_URL
     * @author MyBatis Generator
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 设置分享的URL: SHARE_INFO.SHARE_URL
     * @param shareUrl 映射数据库字段: SHARE_INFO.SHARE_URL
     * @author MyBatis Generator
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    /**
     * 获取分享时间(生成连接的时间): SHARE_INFO.SHARE_TIME
     * @return 分享时间(生成连接的时间): SHARE_INFO.SHARE_TIME
     * @author MyBatis Generator
     */
    public Date getShareTime() {
        return shareTime;
    }

    /**
     * 设置分享时间(生成连接的时间): SHARE_INFO.SHARE_TIME
     * @param shareTime 映射数据库字段: SHARE_INFO.SHARE_TIME
     * @author MyBatis Generator
     */
    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }
}