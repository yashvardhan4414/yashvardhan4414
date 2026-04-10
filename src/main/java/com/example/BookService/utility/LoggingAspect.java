package com.example.BookService.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    // @Before("execution(* com.infy.service.BookServiceImpl.getAllBook(..))")
    // public void before() {
    //     LOGGER.info("getAllBook method of Service class is called.");
    // }
}