package com.example.ex_book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
public class AspectLog {
    @Pointcut("execution(* com.example.ex_book.controller.BookController.returnBook(..))")
    public void allMethodPointCut(){}
    @Pointcut("execution(* com.example.ex_book.controller.BookController.success(..))")
    public void allMethodPointCutOrder(){}



    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("Start method name: "+" "+ joinPoint.getSignature().getName()+" Time: " + LocalDateTime.now());

    }

    @After("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.out.println("End method name: "+" "+ joinPoint.getSignature().getName()+" Time: " + LocalDateTime.now());
        System.out.println("hành động khiến trạng thái sách của thư viện bị thay đổi "+ joinPoint.getSignature().getName() );
    }
    @After("allMethodPointCutOrder()")
    public void allMethodPointCutOrder(JoinPoint joinPoint){
        System.out.println("End method name: "+" "+ joinPoint.getSignature().getName()+" Time: " + LocalDateTime.now());
        System.out.println("hành động khiến trạng thái sách của thư viện bị thay đổi "+ joinPoint.getSignature().getName() );
    }
}
