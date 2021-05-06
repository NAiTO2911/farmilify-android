package com.farmilify.client

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(findViewById(R.id.toolbar))

        val button = findViewById<Button>(R.id.keDashboard)
        button.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent) }
    }

}
