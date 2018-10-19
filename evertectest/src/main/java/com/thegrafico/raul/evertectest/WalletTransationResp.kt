package com.thegrafico.raul.evertectest

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

@Suppress("UNREACHABLE_CODE")

private val URL:String = "https://private-f2106d-evertec1.apiary-mock.com/questions"

class WalletTransationResp(var completeListener: CompleteListener?): AsyncTask<String, Void, String>() {


    //HERE WE GET THE INFO AND SEND TO A LISTENER
    override fun doInBackground(vararg params: String): String? {

        try {
            return  donwloadData(URL)
        }catch (e:IOException){
            return null
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