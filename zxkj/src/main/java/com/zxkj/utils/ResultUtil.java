package com.zxkj.utils;

import com.zxkj.bean.Result;
import com.zxkj.bean.ResultEnum;

//消息处理工具类
public class ResultUtil {

    public static Result success(Object obj) { //操作成功的处理方法
        Result<Object> result = new Result<>();
//        result.setCode(ResultEnum.SUCCESS.getCode());
//        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setCode(200);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }
    public static Result success() { //操作成功的处理方法，不返回任何消息数据
        return success(null);
    }
    public static Result error(Integer code,String msg,Object obj){//操作失败处理方法
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }
    public static Result error(Integer code, String msg) {
        return error(code, msg, null);
    }
    public static Result error(ResultEnum resultEnum, Object obj) {
        Result<Object> result = new Result<>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(obj);
        return result;
    }
    public static Result error(ResultEnum resultEnum) {
        Result<Object> result = new Result<>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(null);
        return result;
    }

}
