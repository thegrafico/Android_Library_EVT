package com.thegrafico.raul.evertectest.Logic

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.thegrafico.raul.evertectest.CompleteListener
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.io.OutputStreamWriter

private val URL:String = "https://private-f2106d-evertec1.apiary-mock.com/questions"

class WalletTransationResp(var completeListener: CompleteListener?, var dataToPost: ProcessWalletTransaction): AsyncTask<String, Void, String>() {

    //to Transfor JSON
    val gson: Gson = GsonBuilder().setPrettyPrinting().create() // for pretty print feature

    //Process running in Background
    override fun doInBackground(vararg params: String): String? {

        try {
            return (donwloadData(URL))
        }catch (e:IOException){
            return null
        }

        return null
    }

    //DATA COMMUNICATION
    override fun onPostExecute(result: String) {

        try {
            val resp = gson.fromJson(result, ResponseWalletTransaction::class.java)

            completeListener?.downloadCompleted(result, resp)

        }finally {}
    }

    //POST OR GET REQUEST
    @Throws (IOException::class)
    private fun donwloadData(url:String): String{

        var inputStream: InputStream? = null

        try{

            //Our URL goes Here
            val url = URL(url)

            //Make HTTP request
            val conn = url.openConnection() as HttpURLConnection

            //-------------setup----------------------
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
            conn.setRequestProperty("Accept", "application/json")
            conn.doOutput = true
            conn.requestMethod = "POST"
            conn.connect()

            //send data
            val wr = OutputStreamWriter(conn.getOutputStream())

            //Here dataToPost is JSON Object
            wr.write(Gson().toJson(dataToPost))

            wr.flush()
            wr.close()

            //retrieve data
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