package com.thegrafico.raul.evertectest

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import khttp.delete as httpDelete


//Constructor
class ProcessWalletTransactionData{

    //OPERATIONS
    private val txrOperSALE: String = "SALE"
    private val txrOperVOID: String = "VOID"
    private val txrOperREFUND: String = "REFUND"

    //RESPONSE WALLET
    private var walletTransactionResp = WalletTransactionResp()

    //TO Convert string to JSON object
    private var gson: Gson? = null

    //String to get Response
    private var respon: String? = null

    //Context of application
    private var context: Context

    //URL
    private val URL : String = "https://private-f2106d-evertec1.apiary-mock.com/questions"

    //Constructor
    constructor(context: Context){
        this.context = context
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

    fun exe(){
        completionHandler()

   }

    //-----START TESTING PURPOSE-------

    //-----END TESTING PURPOSE-------

    //Solicitud de la libreria Volley
    private fun solicitudHttpVolley() {
        val queue = Volley.newRequestQueue(context)
        val solicitud = StringRequest(Request.Method.POST, URL, Response.Listener<String>{
            response ->
            try{
              var jsonFile = gson!!.toJson(response)
//              var wtResp = new WalltRansactionResp(gson);
//                textView.text = response
                Log.d("\t\tRESPONSE: " ,"ESTOY EN VOLLEY")

            }catch (e: Exception){

            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }

    fun completionHandler(){
        solicitudHttpVolley()
        Log.d("\t\tESTOY EN COMPLETE", "HANDLER!")

    }
}


/*
    TODO: Research about Completion Handlers in Android to make this request asyn
      Idea: se ejecuta el mentodo exe, espera por una respuesta, cuando la respuesta esta completa
            pues que se ejecute el WalletTransation Respons y guarde esa respuesta en un archivo JSON y lo
            envie a Wallet TransactionRespon
*/