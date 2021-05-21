package com.farmilify.client

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.content.SharedPreferences
import android.widget.ImageButton

class Landing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = this@Landing.getSharedPreferences("mysharedpref", Context.MODE_PRIVATE)
        val hasLogin = sharedPreferences.getBoolean("hasLogin", false)
        if (hasLogin){
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            setContentView(R.layout.activity_landing)
            val buttonLog = findViewById<ImageButton>(R.id.keLogin)
            buttonLog.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent) }

            val buttonDaftar = findViewById<ImageButton>(R.id.keRegister)
            buttonDaftar.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent) }
        }
    }

}