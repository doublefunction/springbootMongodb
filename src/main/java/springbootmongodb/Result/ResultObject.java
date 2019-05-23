package springbootmongodb.Result;

public class ResultObject {
    private Integer status;
    private Object data;
    private String message;

    @Override
    public String toString() {
        return "ResultObject{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public ResultObject(Integer status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ResultObject(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResultObject(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
