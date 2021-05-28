package com.farmilify.client

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(findViewById(R.id.toolbar))

        val buttonCuaca = findViewById<ImageButton>(R.id.buttonCuaca)
        buttonCuaca.setOnClickListener {
            val intent = Intent(this, Cuaca::class.java)
            startActivity(intent) }

    }
}

