package com.zxkj.bean;

public enum ResultEnum {
    SUCCESS(200, "成功"),
    SystemException(-1, "系统异常"),
    UnknownException(01, "未知异常"),
    ServiceException(02, "服务异常"),
    InfoException(03, "提示级错误"),
    DBException(04, "数据库操作异常"),
    ParamException(05, "参数验证错误"),
    GoodsNotExists(06, "商品不存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
