package com.farmilify.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class Landing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val buttonLog = findViewById<Button>(R.id.keLogin)
        buttonLog.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent) }

        val buttonDaftar = findViewById<Button>(R.id.keDaftar)
        buttonDaftar.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent) }
    }

}