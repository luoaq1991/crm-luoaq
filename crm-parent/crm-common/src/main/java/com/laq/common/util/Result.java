package com.laq.common.util;

import java.io.Serializable;

import com.laq.framework.constant.ResultConstant;

/**
 * 返回的结果
 *
 * @param <T>
 * @author Mr.YongGan.Zhang
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4715302481089778942L;

    private String code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result success(String msg, Object data) {
        Result<Object> result = new Result();
        result.setCode(ResultConstant.SUCCESS_CODE);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result success(String msg) {

        Result<Object> result = new Result();
        result.setCode(ResultConstant.SUCCESS_CODE);
        result.setMsg(msg);
        return result;
    }

    public static Result fail(String msg, Object data) {
        Result<Object> result = new Result();
        result.setCode(ResultConstant.FAIL_CODE);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg) {

        Result<Object> result = new Result();
        result.setCode(ResultConstant.FAIL_CODE);
        result.setMsg(msg);
        return result;
    }

    public static Result fail(String code, String msg) {
        Result<Object> result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
