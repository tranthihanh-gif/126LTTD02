package com.example.hanh_bt2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hanh_bt2.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.textView2.text = "Quản Lý Sinh Viên"

        val student = Student(
            id = 1,
            name = "Tran Thi Hanh",
            age = 20,
            email = "2415141122103@sv.ute.udn.vn"
        )

        val student2 = student.copy(name = "Test")
        val display = """
            ID: ${student.id}
            Name: ${student.name}
            Age: ${student.age}
            Email: ${student.email}
        """.trimIndent()
        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "Hello $display", Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}