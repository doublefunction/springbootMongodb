package springbootmongodb.utils;


import springbootmongodb.VO.ResultVO;
import springbootmongodb.enums.ResultEnums;


/**
 * 返回结果工具类
 */
public class ResultVOUtils {
    /**
     * 操作成功
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {
        ResultVO result = new ResultVO();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setMsg(ResultEnums.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * 操作失败
     * @param object
     * @return
     */
    public static ResultVO error(Object object) {
        ResultVO result = new ResultVO();
        result.setCode(ResultEnums.ERROR.getCode());
        result.setMsg(ResultEnums.ERROR.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * 参数异常
     * @param object
     * @return
     */
    public static ResultVO paramError(Object object){
        ResultVO result = new ResultVO();
        result.setCode(ResultEnums.PARAM_ERROR.getCode());
        result.setMsg(ResultEnums.PARAM_ERROR.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * token过期
     * @return
     */
    public static ResultVO tokenExpire() {
        ResultVO result = new ResultVO();
        result.setCode(ResultEnums.TOKEN_EXPIRE.getCode());
        result.setMsg(ResultEnums.TOKEN_EXPIRE.getMsg());
        result.setData("token过期，请重新登录");
        return  result;
    }

}
