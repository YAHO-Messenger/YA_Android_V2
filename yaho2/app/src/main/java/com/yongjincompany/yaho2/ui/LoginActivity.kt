package com.yongjincompany.yaho2.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yongjincompany.yaho2.data.Login
import com.yongjincompany.yaho2.databinding.ActivityLoginBinding
import com.yongjincompany.yaho2.utils.RetrofitLogin.service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.noAccount.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        binding.loginBtn.setOnClickListener {

            val username = binding.idEt.text.toString()
            val password = binding.passwordEt.text.toString()
            service.login(Login(username, password)).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val result = response.body()
                    Log.e("로그인", "${result}")
                    startActivity(Intent(this@LoginActivity,RoomActivity::class.java))
                    finish()
                }

                override fun onFailure(call: Call<String>, t:Throwable) {
                    Log.e("로그인", "${t.localizedMessage}")
                    val text = "로그인에 실패했습니다!"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                }
            })
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }

}