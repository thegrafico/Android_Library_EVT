package com.thegrafico.raul.evertectest

import android.os.AsyncTask
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

@Suppress("UNREACHABLE_CODE")

private val URL:String = "https://private-f2106d-evertec1.apiary-mock.com/questions"

class WalletTransationResp(var completeListener: CompleteListener?): AsyncTask<String, Void, String>() {

    //to Transfor JSON
    val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    //HERE WE GET THE INFO AND SEND TO A LISTENER
    override fun doInBackground(vararg params: String): String? {

        try {
            var respJSON = gson.toJson(donwloadData(URL))
            val response = gson.fromJson(donwloadData(URL), ResponseWalletTransation::class.java)
            Log.d("\t\t\tResponse", response.authNumber)
            return  respJSON
        }catch (e:IOException){
            Log.d("\t\t\tResponse", e.message)
        }

        return null
    }

    override fun onPostExecute(result: String) {

        try {
            completeListener?.downloadCompleted(result)
            Log.d("\t\t\tPOST",result)
        }catch (e:IOException){

        }
    }

    @Throws (IOException::class)
    private fun donwloadData(url:String): String{

        var inputStream: InputStream? = null

        try{

            val url = URL(url)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.connect()

            inputStream = conn.inputStream

            return inputStream.bufferedReader().use {
                it.readText()
            }
        }finally {
            if(inputStream != null){
                inputStream.close()
            }
        }
    }


}