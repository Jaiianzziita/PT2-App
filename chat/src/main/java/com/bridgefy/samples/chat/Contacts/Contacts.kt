package com.bridgefy.samples.chat.Contacts

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bridgefy.samples.chat.R
import kotlinx.android.synthetic.main.activity_contacts.*

class Contacts : AppCompatActivity() {

    val contactoAdmin = AdminContacto()

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

    override fun onStart() {
        super.onStart()
        crearLista()

    }


    fun crearLista(){ //cuando la aplicacion empiece se cree la lista y obrenga los datos de la base de datos
        val nombres= contactoAdmin.getAllNames()
        val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, nombres!!)
        listContactos.adapter= adaptador

        //Al seleccionar un elemento de la lista
        listContactos.onItemClickListener= AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val item = nombres!!.get(i)
            Toast.makeText(AppContactos.CONTEXT, item, Toast.LENGTH_SHORT).show()
        }

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
