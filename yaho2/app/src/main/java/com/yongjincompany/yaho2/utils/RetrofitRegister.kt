package com.yongjincompany.yaho2.utils

import com.google.gson.GsonBuilder
import com.yongjincompany.yaho2.utils.RetrofitLogin.retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitRegister {

    val service2 = retrofit.create(RegisterInterface::class.java)
}