package com.thegrafico.raul.evertectest

import android.content.Context
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
//Constructor
class ProcessWalletTransactionData {

    //OPERATIONS
    private val txrOperSALE: String = "SALE"
    private val txrOperVOID: String = "VOID"
    private val txrOperREFUND: String = "REFUND"

    //TO Convert string to JSON object
    private var gson: Gson? = null

    //String to get Response
    private var respon: String? = null

    //Constructor
    constructor(){
        gson = GsonBuilder().setPrettyPrinting().create()
    }

    //Set and Getter of Variables
    var username: String? = null
    var password: String? = null
    var accountNumber: String? = null
    var trxID: String? = null
    var trxAmout: String? = null
    var refNumber: String? = null
    var trxDescription: String? = null
    var filler1: String? = null

    //GetTheOperation
    fun SALE():String{return txrOperSALE}
    fun VOID():String{return txrOperSALE}
    fun REFUN():String{return txrOperSALE}

    fun exe(context: Context, textView: TextView){
        if (!username.isNullOrEmpty()){
            solicitudHttpVolley(context,textView)
        }
    }

    //Solicitud de la libreria Volley
    private fun solicitudHttpVolley(context: Context, textView: TextView){
        var url = "https://private-f2106d-evertec1.apiary-mock.com/questions"
        val queue = Volley.newRequestQueue(context)
        val solicitud = StringRequest(Request.Method.POST, url, Response.Listener<String>{
            response ->
            try{
//              var jsonFile = gson!!.toJson(response)
                textView.text = response
                respon = response
            }catch (e: Exception){
                textView.text = e.message
            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }
}
