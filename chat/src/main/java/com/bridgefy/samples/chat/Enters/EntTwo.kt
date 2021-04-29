package com.bridgefy.samples.chat.Enters

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bridgefy.samples.chat.MainActivity
import com.bridgefy.samples.chat.R

class EntTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_ent)

        findViewById<Button>(R.id.btn2).setOnClickListener({
            val intent: Intent = Intent (this,  EntThr::class.java)
            startActivity(intent)
        })


    }


}