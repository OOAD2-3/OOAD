package com.ooad.demo.controller.handler;

/**
 * Description:
 *
 * @Author: 17Wang
 * @Date: 13:29 2018/12/12
 */
public class ErrorInfo<T> {
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


    private Integer code;
    private String message;
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
