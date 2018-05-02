package com.x.girl.exception;

import com.x.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum e) {
        super(e.getMsg());
        this.code = e.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
