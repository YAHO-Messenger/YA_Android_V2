package com.yongjincompany.yaho2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yongjincompany.yaho2.data.Register
import com.yongjincompany.yaho2.databinding.ActivityRegisterBinding
import com.yongjincompany.yaho2.utils.RetrofitRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.haveAccount.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.registerBtn.setOnClickListener {

            val username = binding.userEt2.text.toString()
            val email = binding.idEt2.text.toString()
            val password = binding.passwordEt2.text.toString()
            RetrofitRegister.service2.register(Register(username, email, password)).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val result = response.body()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java ))
                    Log.e("회원가입", "${result}")
                }

                override fun onFailure(call: Call<String>, t:Throwable) {
                    Log.e("회원가입", "${t.localizedMessage}")
                    val text = "회원가입에 실패했습니다!"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                }
            })
        }
    }
}