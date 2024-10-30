package com.example.tugasfrag

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mFragmentManager = supportFragmentManager
        val mfSatu = hal1()

        mFragmentManager.beginTransaction()
            .add(R.id.main, mfSatu, hal1::class.java.simpleName)
            .commit()



        val _halSatu = findViewById<TextView>(R.id.halSatu)
        _halSatu.setOnClickListener {
            val data = intent.getStringExtra("DATA") ?: "0"
            val amount = data.toIntOrNull()?.minus(1)

            val mfSatu = hal1().apply {
                arguments = Bundle().apply {
                    putString("DATA", amount.toString())
                }
            }
            mFragmentManager.beginTransaction()
                .replace(R.id.main, mfSatu, hal1::class.java.simpleName)
                .commit()
        }

        val _halDua = findViewById<TextView>(R.id.halDua)
        _halDua.setOnClickListener {
            val data = intent.getStringExtra("DATA") ?: "0"
            val amount = data.toIntOrNull()?.minus(2)

            val mfDua = hal2().apply {
                arguments = Bundle().apply {
                    putString("DATA", amount.toString())
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, mfDua, hal2::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }

        val _halTiga = findViewById<TextView>(R.id.halTiga)
        _halTiga.setOnClickListener {
            val data = intent.getStringExtra("DATA") ?: "0"
            val amount = data.toIntOrNull()?.minus(3)

            val mfTiga = hal3().apply {
                arguments = Bundle().apply {
                    putString("DATA", amount.toString())
                }
            }
            mFragmentManager.beginTransaction()
                .replace(R.id.main, mfTiga, hal3::class.java.simpleName)
                .commit()
        }
    }
}