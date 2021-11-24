package com.yongjincompany.yaho2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yongjincompany.yaho2.R
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
                }

                override fun onFailure(call: Call<String>, t:Throwable) {
                    Log.e("로그인", "${t.localizedMessage}")
                }
            })
        }
    }
}