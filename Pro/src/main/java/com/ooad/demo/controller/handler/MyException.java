package com.ooad.demo.controller.handler;

/**
 * Description:
 *
 * @Author: 17Wang
 * @Date: 13:24 2018/12/12
 */
public class MyException extends Exception{
    private int stateCode;

    public MyException(String info,int stateCode){
        super(info);
        this.stateCode=stateCode;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }
}
