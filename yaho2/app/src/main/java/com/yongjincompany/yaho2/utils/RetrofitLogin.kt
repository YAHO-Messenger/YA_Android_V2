package com.yongjincompany.yaho2.utils

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitLogin {

    var gson = GsonBuilder().setLenient().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://15.165.28.181:8080")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val service = retrofit.create(LoginInterface::class.java)

}