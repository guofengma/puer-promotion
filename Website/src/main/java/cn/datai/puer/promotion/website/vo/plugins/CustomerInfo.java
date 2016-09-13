package cn.datai.puer.promotion.website.vo.plugins;

/**
 * Created by Administrator on 2016/8/23.
 */
public class CustomerInfo {

    private String mobileNo;

    private String customerNo;

    private String customerName;

    private String memberNo;

    private String memberName;

    private String openTime;

    private String customerStatus;

    public CustomerInfo(){}

    public CustomerInfo(String mobileNo, String customerNo, String customerName, String memberNo, String memberName, String openTime, String customerStatus) {
        this.mobileNo = mobileNo;
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.openTime = openTime;
        this.customerStatus = customerStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerInfo that = (CustomerInfo) o;

        if (mobileNo != null ? !mobileNo.equals(that.mobileNo) : that.mobileNo != null) return false;
        if (customerNo != null ? !customerNo.equals(that.customerNo) : that.customerNo != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (memberNo != null ? !memberNo.equals(that.memberNo) : that.memberNo != null) return false;
        if (memberName != null ? !memberName.equals(that.memberName) : that.memberName != null) return false;
        if (openTime != null ? !openTime.equals(that.openTime) : that.openTime != null) return false;
        return customerStatus != null ? customerStatus.equals(that.customerStatus) : that.customerStatus == null;

    }

    @Override
    public int hashCode() {
        int result = mobileNo != null ? mobileNo.hashCode() : 0;
        result = 31 * result + (customerNo != null ? customerNo.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (memberNo != null ? memberNo.hashCode() : 0);
        result = 31 * result + (memberName != null ? memberName.hashCode() : 0);
        result = 31 * result + (openTime != null ? openTime.hashCode() : 0);
        result = 31 * result + (customerStatus != null ? customerStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "mobileNo='" + mobileNo + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", memberName='" + memberName + '\'' +
                ", openTime='" + openTime + '\'' +
                ", customerStatus='" + customerStatus + '\'' +
                '}';
    }
}
