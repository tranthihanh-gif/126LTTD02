package com.example.intent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            // Đóng gói dữ liệu vào Bundle
            val bundle = Bundle()
            bundle.putString("EXTRA_ID", binding.edtId.text.toString())
            bundle.putString("EXTRA_NAME", binding.edtName.text.toString())
            bundle.putDouble("EXTRA_GPA", binding.edtGpa.text.toString().toDoubleOrNull() ?: 0.0)

            // Explicit Intent + gắn Bundle
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}