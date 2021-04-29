package com.bridgefy.samples.chat.Enters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bridgefy.samples.chat.R

class EntThr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ent_thr)

        findViewById<Button>(R.id.btn3).setOnClickListener({
            val intent: Intent = Intent (this,  EntFour::class.java)
            startActivity(intent)
        })
    }



}