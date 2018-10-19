package com.thegrafico.raul.evertectest

import android.os.AsyncTask
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.io.OutputStreamWriter


@Suppress("UNREACHABLE_CODE")

private val URL:String = "http://httpbin.org/post"

class WalletTransationResp(var completeListener: CompleteListener?,var dataToPost: ProcessWalletTransactionData): AsyncTask<String, Void, String>() {

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


            val resp = gson.fromJson(result, ResponseWalletTransation::class.java)

            completeListener?.downloadCompleted(result, resp)

        }finally {

        }
    }

    //POST OR GET REQUEST
    @Throws (IOException::class)
    private fun donwloadData(url:String): String{

        var inputStream: InputStream? = null

        try{

            val url = URL(url)
            val conn = url.openConnection() as HttpURLConnection
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
            conn.setRequestProperty("Accept", "application/json")
            conn.doOutput = true

            conn.requestMethod = "POST"
            conn.connect()

            //send data
            val wr = OutputStreamWriter(conn.getOutputStream())
            wr.write(jsonDataToPost().toString())

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

    fun jsonDataToPost():JSONObject{
        var data = JSONObject()

        data.put("username", dataToPost.username)
        data.put("password", dataToPost.password)
        data.put("accountNumber", dataToPost.accountNumber)
        data.put("trxID", dataToPost.trxID)
        data.put("trxAmout", dataToPost.trxAmout)
        data.put("refNumber", dataToPost.refNumber)
        data.put("trxDescription", dataToPost.trxDescription)
        data.put("filler1", dataToPost.filler1)
        data.put("trxOper",dataToPost.trxOper )

         return data
    }

}