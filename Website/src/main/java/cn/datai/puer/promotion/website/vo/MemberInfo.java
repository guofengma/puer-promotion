package cn.datai.puer.promotion.website.vo;

import java.io.Serializable;

public class MemberInfo implements Serializable {
    public static final long serialVersionUID = 1758208309L;

    /**
     * 会员单位ID: MEMBER_INFO.MEMBER_ID
     * @author MyBatis Generator
     */
    private String memberId;

    /**
     * 会员单位名称: MEMBER_INFO.MEMBER_NAME
     * @author MyBatis Generator
     */
    private String memberName;

    /**
     * 会员单位专属URL: MEMBER_INFO.MEMBER_URL
     * @author MyBatis Generator
     */
    private String memberUrl;

    /**
     * 会员状态(N:正常 C:注销 D：冻结): MEMBER_INFO.MEMBER_STATUS
     * @author MyBatis Generator
     */
    private String memberStatus;

    /**
     * 获取会员单位ID: MEMBER_INFO.MEMBER_ID
     * @return 会员单位ID: MEMBER_INFO.MEMBER_ID
     * @author MyBatis Generator
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置会员单位ID: MEMBER_INFO.MEMBER_ID
     * @param memberId 映射数据库字段: MEMBER_INFO.MEMBER_ID
     * @author MyBatis Generator
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * 获取会员单位名称: MEMBER_INFO.MEMBER_NAME
     * @return 会员单位名称: MEMBER_INFO.MEMBER_NAME
     * @author MyBatis Generator
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 设置会员单位名称: MEMBER_INFO.MEMBER_NAME
     * @param memberName 映射数据库字段: MEMBER_INFO.MEMBER_NAME
     * @author MyBatis Generator
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 获取会员单位专属URL: MEMBER_INFO.MEMBER_URL
     * @return 会员单位专属URL: MEMBER_INFO.MEMBER_URL
     * @author MyBatis Generator
     */
    public String getMemberUrl() {
        return memberUrl;
    }

    /**
     * 设置会员单位专属URL: MEMBER_INFO.MEMBER_URL
     * @param memberUrl 映射数据库字段: MEMBER_INFO.MEMBER_URL
     * @author MyBatis Generator
     */
    public void setMemberUrl(String memberUrl) {
        this.memberUrl = memberUrl == null ? null : memberUrl.trim();
    }

    /**
     * 获取会员状态(N:正常 C:注销 D：冻结): MEMBER_INFO.MEMBER_STATUS
     * @return 会员状态(N:正常 C:注销 D：冻结): MEMBER_INFO.MEMBER_STATUS
     * @author MyBatis Generator
     */
    public String getMemberStatus() {
        return memberStatus;
    }

    /**
     * 设置会员状态(N:正常 C:注销 D：冻结): MEMBER_INFO.MEMBER_STATUS
     * @param memberStatus 映射数据库字段: MEMBER_INFO.MEMBER_STATUS
     * @author MyBatis Generator
     */
    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus == null ? null : memberStatus.trim();
    }
}