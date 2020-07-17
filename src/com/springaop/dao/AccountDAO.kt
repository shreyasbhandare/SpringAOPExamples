package com.springaop.dao

import com.springaop.demo.Account
import org.springframework.stereotype.Component

@Component
open class AccountDAO {

    var name : String? = null
    var serviceCode : String? = null

    open fun addAccount(theAccount: Account) {
        println("Doing my DB work : Adding an Account")
    }

    open fun findAccounts(tripWire : Boolean) : MutableList<Account> {
        if(tripWire){
            throw RuntimeException("No Soup for you!")
        }
        Thread.sleep(5000)
        return mutableListOf(Account("John", "Gold"), Account("Madhur", "Silver"))
    }
}