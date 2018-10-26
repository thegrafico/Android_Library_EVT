package com.thegrafico.raul.evertec_library_02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.thegrafico.raul.evertectest.ConectorListener.CheckoutPaymentListenerResponse
import com.thegrafico.raul.evertectest.ConectorListener.DebitListenerResponse
import com.thegrafico.raul.evertectest.ConectorListener.TransactionSearchListenerResponse
import com.thegrafico.raul.evertectest.ConectorListener.WalletTransactionListenerResponse
import com.thegrafico.raul.evertectest.Logic.CheckoutPaymentResp
import com.thegrafico.raul.evertectest.Logic.DebitResp
import com.thegrafico.raul.evertectest.Logic.TransactionSearchResp
import com.thegrafico.raul.evertectest.Logic.WalletTransactionResp
import com.thegrafico.raul.evertectest.Modals.Request.ProcessCheckoutPayment_Request
import com.thegrafico.raul.evertectest.Modals.Request.ProcessDebit_Request
import com.thegrafico.raul.evertectest.Modals.Request.ProcessTransactionSearch_Request
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction_Request
import com.thegrafico.raul.evertectest.Modals.Response.ResponseCheckoutPayment
import com.thegrafico.raul.evertectest.Modals.Response.ResponseDebit
import com.thegrafico.raul.evertectest.Modals.Response.ResponseTransactionSearch
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRequest: Button = findViewById(R.id.vRequest)

        btnRequest.setOnClickListener {
            processDebit()
        }

    }

    //ProcessDebit
    fun processDebit(){
        val processDebit = ProcessDebit_Request()
        processDebit.username          = "Jesus123"
        processDebit.password          = "1234"
        processDebit.accountID         = "001"
        processDebit.customerName      = "jesus"
        processDebit.customerEmail     = "test@test.com"
        processDebit.address1          = "addres1"
        processDebit.address2          = "addres2"
        processDebit.city              = "SJ"
        processDebit.state             = "PR"
        processDebit.zipcode           = "00960"
        processDebit.trxDescription    = "Pago"
        processDebit.trxAmount         = "0.1"
        processDebit.trxOper           = "sale"
        processDebit.trxID             = "123"
        processDebit.refNumber         = "123456"
        processDebit.trxTermID         = " "
        processDebit.cardNumber        = "930840000000036"
        processDebit.expDate           = "1249"
        processDebit.pinblock          = "2846FASDAS44324ASD"

        for(i in 0..2){
            processDebit.filler[i] = "filler$i"
        }

        DebitResp(processDebit, object : DebitListenerResponse{
            override fun downloadCompleted(result: String?, response: ResponseDebit?) {
             Log.d("Result: ", result)
             Log.d("Response: ", response.toString())
            }
        }).execute()

    }


    //Process WalletTransaction
    fun processWalletTrans(){
        val processPW = ProcessWalletTransaction_Request()
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
        WalletTransactionResp(processPW, object : WalletTransactionListenerResponse {

            override fun downloadCompleted(result: String, response: ResponseWalletTransaction?) {
                Log.d("\t\tRESULT", result)
                Log.d("\t\tResponse", response.toString())
            }
        }).execute()
    }

    //Process CheckoutPayment
    fun processCheckoutPay(){
        val checkoutPayment = ProcessCheckoutPayment_Request()
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
        CheckoutPaymentResp(checkoutPayment, object: CheckoutPaymentListenerResponse {
            override fun downloadCompleted(result: String?, response: ResponseCheckoutPayment?) {
                Log.d("\t\tRESULT", result)
                Log.d("\t\tResponse", response.toString())
            }

        }).execute()

    }

    //Process TransactionSearch
    fun processTransSearch(){
        val transactionSearch = ProcessTransactionSearch_Request()
        transactionSearch.username          = "Jesus123"
        transactionSearch.password          = "1234"
        transactionSearch.accountID         = "123456"
        transactionSearch.trxID             = "123456"
        transactionSearch.trxAmount         = "0.1"


        TransactionSearchResp(transactionSearch, object: TransactionSearchListenerResponse {

            override fun downloadCompleted(result: String?, response: ResponseTransactionSearch?) {
                Log.d("\t\tRESULT", result)
                Log.d("\t\tResponse", response.toString())
            }

        }).execute()
    }

}
