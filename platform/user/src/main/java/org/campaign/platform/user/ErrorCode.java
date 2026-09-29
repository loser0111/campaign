package org.campaign.platform.user;

import lombok.Getter;

/**
 * 对外的错误码
 */
public enum ErrorCode {

    SUCCESS(200L, "SUCCESS"),
    FAIL(500L, "FAIL");

    ErrorCode(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    final Long code;
    final String message;

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }



}
