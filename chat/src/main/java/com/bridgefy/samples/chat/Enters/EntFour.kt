package com.bridgefy.samples.chat.Enters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bridgefy.samples.chat.*

class EntFour : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ent_four)


        findViewById<Button>(R.id.btn4).setOnClickListener({
            val intent: Intent = Intent (this,  LoginActivity::class.java)
            startActivity(intent)
        })
    }
}