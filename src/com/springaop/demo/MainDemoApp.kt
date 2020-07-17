package com.springaop.demo

import com.springaop.dao.AccountDAO
import com.springaop.dao.MembershipDAO
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val context = AnnotationConfigApplicationContext(DemoConfig::class.java)

    val theAccountDAO = context.getBean("accountDAO", AccountDAO::class.java)
    val theMembershipDAO = context.getBean("membershipDAO", MembershipDAO::class.java)

    theAccountDAO.addAccount(Account())

    try {
        val tripWire = false
        val acctList = theAccountDAO.findAccounts(tripWire)
        println(acctList)
    }catch (exe : Exception){
        println("Main program caught exception")
    }

    theMembershipDAO.addAccount()

    context.close()
}