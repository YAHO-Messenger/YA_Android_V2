package com.yongjincompany.yaho2.utils


import com.yongjincompany.yaho2.data.Register
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterInterface {
    @POST("/api/auth/signin")
    fun register(@Body register: Register) : Call<String>
}