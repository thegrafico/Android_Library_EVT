package com.thegrafico.raul.evertec_library_02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.thegrafico.raul.evertectest.ConectorListener.ResponseWalletListener
import com.thegrafico.raul.evertectest.Logic.JAVA.WalletTransactionResp
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var volleyBtn: Button = findViewById(R.id.vRequest)

        volleyBtn.setOnClickListener {

            val processPW = ProcessWalletTransaction()
            processPW.username = "Pedrito"
            processPW.password = "1234"
            processPW.accountNumber = "147258"
            processPW.trxID = "12304561"
            processPW.accountNumber = "00000000"
            processPW.trxAmout = "0.01"
            processPW.refNumber = "159236"
            processPW.trxDescription = "Sale of materials"
            processPW.filler1 = "data"
            processPW.trxOper = "REFUND"

            //WALLET en JAVA
            WalletTransactionResp(processPW, object : ResponseWalletListener {

                 override fun downloadCompleted(result: String, response: ResponseWalletTransaction?) {
                     Log.d("\t\tRESULT", result)
                     Log.d("\t\tResponse", response.toString())
                 }
             }).execute()
        }
    }


}