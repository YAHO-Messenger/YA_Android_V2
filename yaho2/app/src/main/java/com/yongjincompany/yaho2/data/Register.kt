package com.yongjincompany.yaho2.data

data class Register(
    val email: String,
    val password: String,
    val role: List<String>,
    val username: String
)