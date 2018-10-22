package com.thegrafico.raul.evertec_library_02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.thegrafico.raul.evertectest.ConectorListener.ResponseListenerCheckoutPayment
import com.thegrafico.raul.evertectest.ConectorListener.ResponseWalletListener
import com.thegrafico.raul.evertectest.Logic.CheckoutPaymentResp
import com.thegrafico.raul.evertectest.Logic.WalletTransactionResp
import com.thegrafico.raul.evertectest.Modals.Request.ProcessCheckoutPayment
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction
import com.thegrafico.raul.evertectest.Modals.Response.ResponseCheckoutPayment
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var volleyBtn: Button = findViewById(R.id.vRequest)

        volleyBtn.setOnClickListener {
            processCheckoutPay()
        }
    }

    //Process WalletTransaction
    fun processWalletTrans(){
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

    //Process CheckoutPayment
    fun processCheckoutPay(){
        val checkoutPayment = ProcessCheckoutPayment()
        checkoutPayment.username          = "Jesus123"
        checkoutPayment.password          = "1234"
        checkoutPayment.accountID         = "001"
        checkoutPayment.customerName      = "jesus"
        checkoutPayment.customerEmail     = "test@test.com"
        checkoutPayment.address1          = "addres1"
        checkoutPayment.address2          = "addres2"
        checkoutPayment.city              = "SJ"
        checkoutPayment.state             = "PR"
        checkoutPayment.zipcode           = "00960"
        checkoutPayment.phone             = "787-953-6363"
        checkoutPayment.fax               = "787657895"
        checkoutPayment.trxDescription    = "Pago"
        checkoutPayment.trxAmount         = "0.1"
        checkoutPayment.language          = "en"
        checkoutPayment.ignoreValues      = " "

        for(i in 0..4){
            checkoutPayment.taxAmount[i] = "taxt$i"
        }
        for(i in 0..2){
            checkoutPayment.filler[i] = "filler$i"
        }

        //WALLET en JAVA
        CheckoutPaymentResp(checkoutPayment, object: ResponseListenerCheckoutPayment{
            override fun downloadCompleted(result: String?, response: ResponseCheckoutPayment?) {
                Log.d("\t\tRESULT", result)
                Log.d("\t\tResponse", response.toString())
            }

        }).execute()

    }

    fun processTransSearch(){

    }

}
