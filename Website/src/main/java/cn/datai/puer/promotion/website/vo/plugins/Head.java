package cn.datai.puer.promotion.website.vo.plugins;

/**
 * Created by Administrator on 2016/8/23.
 */
public class Head {

    private String msg;

    private String code;

    public Head(){}

    public Head(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Head head = (Head) o;

        if (msg != null ? !msg.equals(head.msg) : head.msg != null) return false;
        return code != null ? code.equals(head.code) : head.code == null;

    }

    @Override
    public int hashCode() {
        int result = msg != null ? msg.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Head{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
