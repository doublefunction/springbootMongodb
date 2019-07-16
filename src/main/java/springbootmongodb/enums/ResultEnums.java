package springbootmongodb.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {
    SUCCESS("0000", "成功"),
    ERROR("0001", "失败"),
    SYS_FAIL("9999", "系统内部错误"),
    NOT_FOUND("1001", "查询接口不存在"),
    PARAM_ERROR("1004", "参数错误"),
    TOKEN_EXPIRE("4001", "token过期"),
    ;

    private String code;
    private String msg;

    ResultEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
