package com.thegrafico.raul.evertec_library_02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.thegrafico.raul.evertectest.CompleteListener
import com.thegrafico.raul.evertectest.ProcessWalletTransactionData
import com.thegrafico.raul.evertectest.WalletTransationResp


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var volleyBtn: Button = findViewById(R.id.vRequest)

        volleyBtn.setOnClickListener {

            val processPW = ProcessWalletTransactionData(this)
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

//            processPW.exe()
            //TESTING
//            processPW.makeHttpRequest()
            //END TESTING
            // exe.(this, responseListener {})

            WalletTransationResp(object : CompleteListener{
                override fun downloadCompleted(result: String) {
                    Log.d("\t\t\tDownload Completed", result)
                }
            }).execute()
        }
    }


}