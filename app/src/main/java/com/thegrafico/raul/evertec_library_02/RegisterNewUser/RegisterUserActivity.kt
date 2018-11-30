package com.thegrafico.raul.evertec_library_02.RegisterNewUser

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.Toast
import com.thegrafico.raul.evertec_library_02.ItemActivity
import com.thegrafico.raul.evertec_library_02.R
import com.thegrafico.raul.evertectest.ConectorListener.TransactionSearchListenerResponse
import com.thegrafico.raul.evertectest.Modals.Request.ProcessTransactionSearch_Request
import com.thegrafico.raul.evertectest.Response.ProcessResponse

class RegisterUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)


        val signUp = Intent(this, ItemActivity::class.java)

        var fullName: TextInputEditText = findViewById(R.id.fullName)
        var userName: TextInputEditText = findViewById(R.id.userName)
        var pass: TextInputEditText = findViewById(R.id.password)
        var accNumber: TextInputEditText = findViewById(R.id.accountNumber)

        findViewById<Button>(R.id.btnCreateAccount).setOnClickListener {
            v ->

            if(validateInfo(fullName) && validateInfo(userName)
                    && validateInfo(pass) && validateInfo(accNumber)){

                val transactionSearch = ProcessTransactionSearch_Request()
                transactionSearch.username          = userName.text.toString()
                transactionSearch.password          = pass.text.toString()
                transactionSearch.accountID         = accNumber.text.toString()

                ProcessResponse(transactionSearch, TransactionSearchListenerResponse { result, response ->

                    if(response != null && response.responseValidated == "TRUE"){
                        signUp.putExtra("accNumber", accNumber.text.toString())
                        startActivity(signUp)
                    }else
                        Toast.makeText(applicationContext, "No se puede Procesar la operacion", Toast.LENGTH_SHORT).show()

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
