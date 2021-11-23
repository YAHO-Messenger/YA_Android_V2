package com.yongjincompany.yaho2.utils

import com.yongjincompany.yaho2.data.Login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterInterface {
    @POST("/api/auth/signin")
    fun register(@Body login: Login) : Call<String>
}