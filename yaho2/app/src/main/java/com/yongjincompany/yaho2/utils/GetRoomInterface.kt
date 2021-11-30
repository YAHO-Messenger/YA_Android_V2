package com.yongjincompany.yaho2.utils

import com.yongjincompany.yaho2.data.Room
import retrofit2.Response
import retrofit2.http.GET

interface GetRoomInterface {

    @GET("/api/auth/chat")
    suspend fun getRooms(): Response<List<Room>>
}