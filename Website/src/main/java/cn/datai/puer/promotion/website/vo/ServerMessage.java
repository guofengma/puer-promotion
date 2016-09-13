package cn.datai.puer.promotion.website.vo;


public class ServerMessage {

    private String requestId;

    private Result result;

    public ServerMessage() {
        this.requestId = null;
        this.result = new Result();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {

        private String msg;

        private int code;

        private Object data;

        public Result() {
            this.msg = "成功";
            this.code = 2000;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "msg='" + msg + '\'' +
                    ", code=" + code +
                    ", data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ServerMessage{" +
                "requestId='" + requestId + '\'' +
                ", result=" + result +
                '}';
    }
}
