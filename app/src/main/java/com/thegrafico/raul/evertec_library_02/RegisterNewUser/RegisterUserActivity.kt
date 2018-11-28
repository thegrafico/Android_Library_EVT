package com.thegrafico.raul.evertec_library_02.RegisterNewUser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.thegrafico.raul.evertec_library_02.R
import com.thegrafico.raul.evertectest.ConectorListener.WalletListenerResponse
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction_Request
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction
import com.thegrafico.raul.evertectest.Response.ProcessResponse

class RegisterUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        var fullName: TextInputEditText = findViewById(R.id.fullName)
        var userName: TextInputEditText = findViewById(R.id.userName)
        var pass: TextInputEditText = findViewById(R.id.password)
        var accNumber: TextInputEditText = findViewById(R.id.accountNumber)

        findViewById<Button>(R.id.btnCreateAccount).setOnClickListener {
            v ->
                if(validateInfo(fullName) && validateInfo(userName)
                        && validateInfo(pass) && validateInfo(accNumber)){

                    //PROCESS WALLET TRANSACTION HERE
                    val processPW = ProcessWalletTransaction_Request()

                    processPW.username = userName.toString()
                    processPW.password = pass.toString()
                    processPW.accountNumber = accNumber.toString()
                    processPW.filler1 = fullName.toString()


                    ProcessResponse(processPW, object : WalletListenerResponse {
                        override fun downloadCompleted(result: String, response: ResponseWalletTransaction?) {

                            Toast.makeText(applicationContext, "Account Created", Toast.LENGTH_LONG).show()
                            Log.d("Result", result)
                            Log.d("Response", response.toString())
                        }
                    }).execute()
                }
        }

    }
    //just to set some "Parameters" (is needed more validation)
    fun validateInfo(texInfo: TextInputEditText): Boolean{

        if(texInfo.text.isNullOrEmpty() || texInfo.text!!.length < 3){
            texInfo.error = "Must be 3 characters"
            return false
        }
        return true
    }

}
