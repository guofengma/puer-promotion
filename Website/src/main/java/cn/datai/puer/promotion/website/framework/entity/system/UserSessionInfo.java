package cn.datai.puer.promotion.website.framework.entity.system;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.io.Serializable;

/**
 * session登录用户信息
 */
public class UserSessionInfo implements Serializable{
    private String weixinOpenId;

    private String userInfoId;

    private String weixinUnionId;

    private String agentId;

    private String agentNo;

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getWeixinUnionId() {
        return weixinUnionId;
    }

    public void setWeixinUnionId(String weixinUnionId) {
        this.weixinUnionId = weixinUnionId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserSessionInfo that = (UserSessionInfo) o;

        return new EqualsBuilder()
                .append(weixinOpenId, that.weixinOpenId)
                .append(userInfoId, that.userInfoId)
                .append(weixinUnionId, that.weixinUnionId)
                .append(agentId, that.agentId)
                .append(agentNo, that.agentNo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        int result = weixinOpenId != null ? weixinOpenId.hashCode() : 0;
        result = 31 * result + (userInfoId != null ? userInfoId.hashCode() : 0);
        result = 31 * result + (weixinUnionId != null ? weixinUnionId.hashCode() : 0);
        result = 31 * result + (agentId != null ? agentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserSessionInfo{" +
                "weixinOpenId='" + weixinOpenId + '\'' +
                ", userInfoId='" + userInfoId + '\'' +
                ", weixinUnionId='" + weixinUnionId + '\'' +
                ", agentId='" + agentId + '\'' +
                ", agentNo='" + agentNo + '\'' +
                '}';
    }
}
