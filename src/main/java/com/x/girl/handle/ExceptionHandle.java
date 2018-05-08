package com.x.girl.handle;

import com.x.girl.domain.Girl;
import com.x.girl.dto.Result;
import com.x.girl.enums.ResultEnum;
import com.x.girl.exception.GirlException;
import com.x.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException exception = (GirlException) e;
            return ResultUtil.error(exception);
        } else {
            logger.error("【系统异常】 {}",e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR);
        }
    }
}
