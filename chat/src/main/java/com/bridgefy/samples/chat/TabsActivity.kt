package com.bridgefy.samples.chat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bridgefy.samples.chat.Maps.Maps
import com.bridgefy.samples.chat.ui.main.SectionsPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
*/
            val intent: Intent = Intent (this,  MainActivity::class.java)
            startActivity(intent)
        }

        topAppBar.setNavigationOnClickListener({view ->

            val intent: Intent = Intent (this, Maps::class.java)
            startActivity(intent)

            Snackbar.make(view, "mandar a perfil", Snackbar.LENGTH_SHORT )
                    .show()
        })
    }
}