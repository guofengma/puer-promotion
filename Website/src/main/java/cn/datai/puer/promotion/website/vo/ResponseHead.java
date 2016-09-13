package cn.datai.puer.promotion.website.vo;

/**
 * Created by js on 2016/8/24 checkdown.
 */
public class ResponseHead {
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseHead that = (ResponseHead) o;

        if (!code.equals(that.code)) return false;
        return msg.equals(that.msg);

    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + msg.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ResponseHead{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
