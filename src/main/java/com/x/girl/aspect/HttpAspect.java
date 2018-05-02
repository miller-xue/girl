package com.x.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面编程
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution(public * com.x.girl.controller.GirlController.*(..))")
    public void log() {
    }

    @Before(value = "log()")
    public void doBefore(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        //参数
        logger.info("args={}", point.getArgs());
    }

    @After(value = "log()")
    public void doAfter() {
        logger.info("2222222222222222222222222222222222");
    }

    @AfterReturning(returning = "object", value = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }
}
