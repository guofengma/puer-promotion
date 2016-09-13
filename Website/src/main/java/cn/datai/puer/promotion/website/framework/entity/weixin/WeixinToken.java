package cn.datai.puer.promotion.website.framework.entity.weixin;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信服务器返回的令牌
 */
public class WeixinToken implements Serializable{

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private String expiresIn;

    private Long createTimeStamp;

    public WeixinToken() {
        this.createTimeStamp = (new Date()).getTime();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    @Override
    public String toString() {
        return "WeixinToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                ", createTimeStamp=" + createTimeStamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        WeixinToken that = (WeixinToken) o;

        return new EqualsBuilder()
                .append(accessToken, that.accessToken)
                .append(expiresIn, that.expiresIn)
                .append(createTimeStamp, that.createTimeStamp)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(accessToken)
                .append(expiresIn)
                .append(createTimeStamp)
                .toHashCode();
    }
}
