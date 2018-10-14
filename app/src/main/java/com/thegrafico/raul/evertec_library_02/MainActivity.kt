package com.thegrafico.raul.evertec_library_02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import android.os.StrictMode
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.thegrafico.raul.evertectest.ProcessWalletTransactionData
import com.thegrafico.raul.evertectest.ProcessWalletTransaction_TEST_



class MainActivity : AppCompatActivity() {

    //URL == can be change in the values String files
    val URL: String  = "https://private-f2106d-evertec1.apiary-mock.com/questions"
    val SDK_INT = android.os.Build.VERSION.SDK_INT
    private var gson: Gson? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.button)
        var volleyBtn: Button = findViewById(R.id.vRequest)
        var textView: TextView = findViewById(R.id.text01)

        gson = GsonBuilder().setPrettyPrinting().create()

        if (SDK_INT > 8) {
            val policy = StrictMode.ThreadPolicy.Builder()
                    .permitAll().build()
            StrictMode.setThreadPolicy(policy)
            //your codes here

            button.setOnClickListener {
//                val response: Response = khttp.post(URL, data = getJSONObjet())
//                val obj: JSONObject = response.jsonObject
//                textView.text = (obj).toString()
            }
        }

        volleyBtn.setOnClickListener {

            var processPW = ProcessWalletTransactionData()
            processPW.username = "Pedrito"
            processPW.password = "1234"
            processPW.accountNumber = "147258"
            processPW.trxID = "12304561"
            processPW.accountNumber = "00000000"
            processPW.trxAmout = "0.01"
            processPW.refNumber = "159236"
            processPW.trxDescription = "Sale of materials"
            processPW.filler1 = "data"
            processPW.REFUN()
            processPW.exe(this, textView)

        }
    }
}