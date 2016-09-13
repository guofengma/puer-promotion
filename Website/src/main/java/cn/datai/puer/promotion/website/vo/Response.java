package cn.datai.puer.promotion.website.vo;


/**
 * Created by zhangxiang on 2016/8/24.
 */
public class Response {
    private ResponseHead head;
    private Object body;

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (head != null ? !head.equals(response.head) : response.head != null) return false;
        return body != null ? body.equals(response.body) : response.body == null;

    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}
