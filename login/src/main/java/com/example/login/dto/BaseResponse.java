package com.example.login.dto;

import lombok.Data;

@Data
public class BaseResponse {

    private boolean success;
    private String code;
    private String message;
    private Object data;

    public BaseResponse() {
    }

    public BaseResponse(boolean success) {
        this.success = success;
    }

    public BaseResponse(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public  static  BaseResponse ok(Object data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("200");
        baseResponse.setData(data);
        baseResponse.setSuccess(true);
        return baseResponse;

    }

    public  static  BaseResponse ok(String data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("200");
        baseResponse.setSuccess(true);
        baseResponse.setMessage(data);
        return baseResponse;

    }

    public  static  BaseResponse ok(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("200");
        baseResponse.setSuccess(true);
        return baseResponse;

    }

    public  static  BaseResponse fail(String data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("201");
        baseResponse.setMessage(data);
        baseResponse.setSuccess(false);
        return baseResponse;

    }

    public  static  BaseResponse fail(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("201");
        baseResponse.setSuccess(false);
        return baseResponse;

    }


}
