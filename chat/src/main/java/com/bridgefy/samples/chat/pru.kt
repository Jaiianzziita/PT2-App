package com.bridgefy.samples.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.bridgefy.samples.chat.databinding.ActivityPruBinding
import com.bridgefy.samples.chat.ui.main.Constants
import com.bridgefy.sdk.logging.Log
import kotlinx.android.synthetic.main.activity_pru.*
import org.json.JSONObject

class pru : AppCompatActivity() {
    private lateinit var mBinding: ActivityPruBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPruBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.swType.setOnCheckedChangeListener { button, checked ->
            button.text = if (checked) getString(R.string.main_type_login)
            else getString(R.string.main_type_register)

            mBinding.btnLogin.text
        }

        mBinding.btnLogin.setOnClickListener{
            login()
        }
    }
// empieza lo que hara dentro del login y register
    private fun login() {
        val typeMethod = if (mBinding.swType.isChecked) Constants.LOGIN_PATH else Constants.REGISTER_PATH
        val url = Constants.BASE_URL+ Constants.USUARIOS_PATH + typeMethod
        val cellphone= mBinding.etcellphone.text.toString().trim()
        val name= mBinding.etname.text.toString().trim()
        val jsonParams = JSONObject()
        if (cellphone.isNotEmpty()){
            jsonParams.put(Constants.CELLPHONE, cellphone)
        }
        if (name.isNotEmpty()){
            jsonParams.put(Constants.NAME, name)
        }
        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url, jsonParams, {response ->
            Log.i("response", response.toString())
            val token =response.optString(Constants.TOKEN)

            //val result= if ()


            updateUI("result")

        }, {
            it.printStackTrace()



        }){
            override fun getHeaders(): MutableMap<String, String> {
                val params =HashMap<String, String>()
                params["Content-Type"]="application/json"
                return params
            }


        }
        LoginApplication.mainApi.addToRequestQueue(jsonObjectRequest)
    }

    private fun updateUI(result: String) {
    mBinding.tvResult.visibility= View.VISIBLE
        mBinding.tvResult.text=result
    }

}