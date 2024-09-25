package com.gzy.springlab.entity

import java.io.Serializable


data class User(
    val id: Long? = null,
    val name: String? = null,
    val age: Int? = null,
    val email: String? = null
) : Serializable
