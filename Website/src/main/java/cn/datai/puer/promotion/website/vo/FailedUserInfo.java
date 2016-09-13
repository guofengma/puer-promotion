package cn.datai.puer.promotion.website.vo;

/**
 * Created by zhangxiang on 2016/8/24.
 */
public class FailedUserInfo {
    private String mobileNo;
    private String memberNo;
    private String memberName;
    private String timestamp;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FailedUserInfo that = (FailedUserInfo) o;

        if (!mobileNo.equals(that.mobileNo)) return false;
        if (!memberNo.equals(that.memberNo)) return false;
        if (!memberName.equals(that.memberName)) return false;
        return timestamp.equals(that.timestamp);

    }

    @Override
    public int hashCode() {
        int result = mobileNo.hashCode();
        result = 31 * result + memberNo.hashCode();
        result = 31 * result + memberName.hashCode();
        result = 31 * result + timestamp.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FailedUserInfo{" +
                "mobileNo='" + mobileNo + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", memberName='" + memberName + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
