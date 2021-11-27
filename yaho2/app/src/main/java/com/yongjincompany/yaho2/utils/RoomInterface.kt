package com.yongjincompany.yaho2.utils

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RoomInterface {
    @FormUrlEncoded
    @POST("/api/auth/chat")
    fun made_room(@Field ("roomname") name: String) : Call<String>
}