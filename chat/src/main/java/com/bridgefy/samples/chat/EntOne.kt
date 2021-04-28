package com.bridgefy.samples.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntOne : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_ent)

        findViewById<Button>(R.id.btn1).setOnClickListener({
            val intent: Intent = Intent (this,  EntTwo::class.java)
            startActivity(intent)
        })
    }
}