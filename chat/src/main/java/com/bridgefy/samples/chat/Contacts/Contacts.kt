package com.bridgefy.samples.chat.Contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bridgefy.samples.chat.R
import com.bridgefy.samples.chat.TabsActivity
import com.google.android.material.appbar.MaterialToolbar

class Contacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val topAppBar2 : MaterialToolbar = findViewById(R.id.topAppBar2)


        topAppBar2.setOnClickListener ({
            val intent: Intent = Intent (this,  TabsActivity::class.java)
            startActivity(intent)
        })
    }
}