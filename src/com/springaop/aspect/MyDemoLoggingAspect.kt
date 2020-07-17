package com.springaop.aspect

import com.springaop.demo.Account
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(1)
class MyDemoLoggingAspect {

    @Pointcut("execution(* *addAccount(..))")
    fun forAllAccount() {}

    @Before("execution(* add*(com.springaop.demo.Account))")
    fun beforeAddAccountAdvice(theJoinPoint : JoinPoint) {
        println("===== Executing @Before advice on addAccount(Account) =====")
        val acct = theJoinPoint.args[0]
        if(acct is Account) println("${acct.name} ${acct.level}") else println("...nothing...")
    }

    @Before("forAllAccount()")
    fun beforeAllAddAccountAdvice() {
        println("===== Executing @Before advice on all addAccount() =====")
    }

    @AfterReturning(pointcut = "execution(* *findAccounts(*))", returning = "result")
    fun afterReturningFindAccountsAdvice(theJoinPoint: JoinPoint, result : MutableList<Account>) {
        println(theJoinPoint.signature.toShortString())
        println("===== Executing @AfterReturning advice on all findAccounts() =====")
        println("result = $result")

        // modify returning list
        result.add(Account("Newbie", "Platinum"))
    }

    @AfterThrowing(pointcut = "execution(* *findAccounts(*))", throwing = "exc")
    fun afterThrowingFindAccountsAdvice(theJoinPoint: JoinPoint, exc : Throwable) {
        println(theJoinPoint.signature.toShortString())
        println("The exception is = $exc")
    }

    @After("execution(* *findAccounts(*))")
    fun afterFindAccountsAdvice(theJoinPoint: JoinPoint) {
        println("After Advice - Finally!!!")
    }

    @Around("execution(* *findAccounts(*))")
    fun aroundFindAccountsAdvice(processingJoinPoint: ProceedingJoinPoint) {
        val begin = System.currentTimeMillis()
        processingJoinPoint.proceed()
        val end = System.currentTimeMillis()
        println("time to execute = ${end-begin}")
    }
}