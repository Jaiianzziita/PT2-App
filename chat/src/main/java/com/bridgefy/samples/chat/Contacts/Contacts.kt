package com.bridgefy.samples.chat.Contacts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bridgefy.samples.chat.R
import kotlinx.android.synthetic.main.activity_contacts.*

class Contacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)



        topAppBar2.setNavigationOnClickListener({view ->

            val intent: Intent = Intent (this, AgregarContacto::class.java)
            startActivity(intent)

           /* Snackbar.make(view, "mandar a perfil", Snackbar.LENGTH_SHORT )
                    .show()*/
        })
    }


    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_add->{
                return true
            }
            else  ->return super.onOptionsItemSelected(item)

        }
    }*/


}
