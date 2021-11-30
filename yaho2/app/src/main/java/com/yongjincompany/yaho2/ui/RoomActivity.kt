package com.yongjincompany.yaho2.ui

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yongjincompany.yaho2.R
import com.yongjincompany.yaho2.data.Login
import com.yongjincompany.yaho2.data.Room
import com.yongjincompany.yaho2.databinding.ActivityRoomBinding
import com.yongjincompany.yaho2.utils.RetrofitLogin
import com.yongjincompany.yaho2.utils.RetrofitRoom
import com.yongjincompany.yaho2.utils.RetrofitRoomGet
import com.yongjincompany.yaho2.utils.RoomAdapter
import kotlinx.android.synthetic.main.dialog_view.*
import kotlinx.android.synthetic.main.dialog_view.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


const val TAG = "RoomActivity"
class RoomActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRoomBinding

    private lateinit var roomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitRoomGet.service4.getRooms()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, 인터넷연결 해라")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, 응답이 어디갔을까요?")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                roomAdapter.rooms = response.body()!!
            } else {
                Log.e(TAG, "Responce가 실패합니다")
            }
            binding.progressBar.isVisible = false
        }






        binding.madeRoomBtn.setOnClickListener {
            val view = View.inflate(this, R.layout.dialog_view, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)

            view.made_room_dialog.setOnClickListener {


                RetrofitRoom.service3.room("xfsfdf").enqueue(object : Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        val result = response.body()
                        Log.e("방 생성", "${result}")

                        dialog.dismiss()
                    }

                    override fun onFailure(call: Call<String>, t:Throwable) {
                        Log.e("방 생성", "${t.localizedMessage}")
                        val text = "방 생성에 실패했습니다!"
                        val duration = Toast.LENGTH_SHORT

                        val toast = Toast.makeText(applicationContext, text, duration)
                        toast.show()
                    }
                })

            }
        }
    }
    private fun setupRecyclerView() = binding.list.apply {
        roomAdapter = RoomAdapter()
        adapter = roomAdapter
        layoutManager = LinearLayoutManager(this@RoomActivity)
    }
}