package com.example.intent   // giữ dòng package gốc của bạn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lấy Bundle từ Intent
        val bundle = intent.extras

        val id = bundle?.getString("EXTRA_ID") ?: "Chưa có"
        val name = bundle?.getString("EXTRA_NAME") ?: ""
        val gpa = bundle?.getDouble("EXTRA_GPA", 0.0) ?: 0.0

        binding.tvId.text = "MSSV: $id"
        binding.tvName.text = "Họ tên: $name"
        binding.tvGpa.text = "GPA: $gpa"

        // Back về màn hình 1
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}