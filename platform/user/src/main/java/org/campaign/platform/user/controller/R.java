package org.campaign.platform.user.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.campaign.platform.user.ErrorCode;
import org.campaign.platform.user.controller.model.BaseResp;

@Getter
@Setter
public class R <T> {

    private BaseResp baseResp;

    private T data;

    public static <T> R<T> SUCCESS() {
        R<T> r = new R<>();
        BaseResp baseResp = new BaseResp();
        baseResp.code = ErrorCode.SUCCESS.getCode();
        baseResp.msg = ErrorCode.SUCCESS.getMessage();
        r.baseResp = baseResp;
        return r;
    }


    public static <T> R<T> SUCCESS(T data) {
        R<T> r = new R<>();
        r.data = data;
        BaseResp baseResp = new BaseResp();
        baseResp.code = ErrorCode.SUCCESS.getCode();
        baseResp.msg = ErrorCode.SUCCESS.getMessage();
        r.baseResp = baseResp;
        return r;
    }

    public static <T> R<T> FAIL(T data) {
        R<T> r = new R<>();
        BaseResp baseResp = new BaseResp();
        baseResp.code = ErrorCode.FAIL.getCode();
        baseResp.msg = ErrorCode.FAIL.getMessage();
        r.baseResp = baseResp;
        r.data = data;
        return r;
    }


    public static <T> R<T> FAIL() {
        R<T> r = new R<>();
        BaseResp baseResp = new BaseResp();
        baseResp.code = ErrorCode.FAIL.getCode();
        baseResp.msg = ErrorCode.FAIL.getMessage();
        r.baseResp = baseResp;
        return r;
    }

    public static <T> R<T> returnWithCode(ErrorCode errorCode, T data) {
        R<T> r = new R<>();
        BaseResp baseResp = new BaseResp();
        baseResp.code = errorCode.getCode();
        baseResp.msg = errorCode.getMessage();
        r.baseResp = baseResp;
        r.data = data;
        return r;
    }
}
