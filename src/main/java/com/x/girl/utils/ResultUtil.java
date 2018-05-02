package com.x.girl.utils;

import com.x.girl.dto.Result;
import com.x.girl.enums.ResultEnum;

public class ResultUtil {
    public static Result success(Object obj) {
        return new Result(0, "成功", obj);
    }

    public static Result success() {
        return new Result(0, "成功", null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static Result error(ResultEnum e) {
        return error(e.getCode(), e.getMsg());
    }
}
