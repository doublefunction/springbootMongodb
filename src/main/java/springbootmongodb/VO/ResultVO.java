package springbootmongodb.VO;

import lombok.Data;

@Data
public class ResultVO {
    private String code;
    private String msg;
    private Object data;
}
