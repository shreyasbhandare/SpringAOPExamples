package com.springaop.dao

import org.springframework.stereotype.Component

@Component
open class MembershipDAO {

    open fun addAccount() {
        println("Doing my DB work : Adding a Membership Account")
    }
}