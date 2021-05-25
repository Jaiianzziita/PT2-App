package com.bridgefy.samples.chat.Tabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bridgefy.samples.chat.R
import kotlinx.android.synthetic.main.activity_tab.*

class Tab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

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