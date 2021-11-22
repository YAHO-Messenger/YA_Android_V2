package com.yongjincompany.yaho2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yongjincompany.yaho2.R
import com.yongjincompany.yaho2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}