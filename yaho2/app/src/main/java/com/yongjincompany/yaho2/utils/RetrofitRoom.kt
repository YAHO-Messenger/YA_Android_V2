package com.yongjincompany.yaho2.utils

import com.yongjincompany.yaho2.utils.RetrofitLogin.retrofit

object RetrofitRoom {

    val service3 = retrofit.create(RoomInterface::class.java)
}