package com.bridgefy.samples.chat.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bridgefy.samples.chat.R
import com.bridgefy.samples.chat.TabsActivity
import com.google.android.material.appbar.MaterialToolbar

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var topAppBar3: MaterialToolbar =  findViewById(R.id.topAppBar3)

        topAppBar3.setOnClickListener ({
            val intent: Intent = Intent (this,  TabsActivity::class.java)
            startActivity(intent)
        })
    }
}