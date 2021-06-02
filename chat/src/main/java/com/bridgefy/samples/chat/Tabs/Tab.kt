package com.bridgefy.samples.chat.Tabs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bridgefy.samples.chat.Contacts.Contacts
import com.bridgefy.samples.chat.MainActivity
import com.bridgefy.samples.chat.Profile.Profile
import com.bridgefy.samples.chat.R
import com.getbase.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_tab.*

class Tab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)


        val fab1: FloatingActionButton =findViewById(R.id.fab1)
        fab1.setOnClickListener{view ->
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val fab2: FloatingActionButton =findViewById(R.id.fab2)
        fab2.setOnClickListener{view ->
            val intent: Intent = Intent(this, Contacts::class.java)
            startActivity(intent)
        }
        val fab3: FloatingActionButton =findViewById(R.id.fab3)
        fab3.setOnClickListener{view ->
            val intent: Intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }



        setUpTabs()
    }
    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ChatFragment(), "CHATS")
        adapter.addFragment(GroupFragment(), "GRUPOS")
        adapter.addFragment(UbicationFragment(), "UBICACION")
        viewPager.adapter= adapter
        tabss.setupWithViewPager(viewPager)

        tabss.getTabAt(0)!!.setIcon(R.drawable.ic_chat)
        tabss.getTabAt(1)!!.setIcon(R.drawable.ic_groups)
        tabss.getTabAt(2)!!.setIcon(R.drawable.ic_location)

    }
}