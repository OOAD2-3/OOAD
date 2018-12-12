package com.ooad.demo.exception;

/**
 * Description:
 *
 * @Author: 17Wang
 * @Date: 13:24 2018/12/12
 */
public class MyException extends Exception {
    /**
     * 不知名错误
     */
    public static final Integer ERROR = 400;

    /**
     * id格式错误
     */
    public static final Integer ID_FORMAT_ERROR = 400;
    /**
     * 需要权限错误
     */
    public static final Integer AUTHORIZATION_ERROR = 403;
    /**
     * 资源没找到错误
     */
    public static final Integer NOT_FOUND_ERROR = 404;

    private int stateCode;

    public MyException(String info, int stateCode) {
        super(info);
        this.stateCode = stateCode;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }
}
