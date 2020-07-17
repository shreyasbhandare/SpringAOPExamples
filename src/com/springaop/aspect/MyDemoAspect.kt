package com.springaop.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(2)
class MyDemoAspect {
    @Before("execution(* add*(com.springaop.demo.Account))")
    fun beforeAddAccountAdvice() {
        println("===== Order check Demo Aspect  =====")
    }
}