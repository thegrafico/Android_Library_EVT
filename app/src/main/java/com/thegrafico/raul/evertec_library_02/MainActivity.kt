package com.thegrafico.raul.evertec_library_02

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.thegrafico.raul.evertec_library_02.RegisterNewUser.RegisterUserActivity
import com.thegrafico.raul.evertectest.ConectorListener.*
import com.thegrafico.raul.evertectest.Modals.Request.*
import com.thegrafico.raul.evertectest.Modals.Response.*
import com.thegrafico.raul.evertectest.Response.*


class MainActivity : AppCompatActivity() {

    val PROCESS_TRANSACTION: String = "transaction"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //intent for activities
        val loginIntent = Intent(this, ItemActivity::class.java)
        val signUpIntent= Intent(this, RegisterUserActivity::class.java)

        //Buttons
        val singBTN: Button = findViewById(R.id.signBtn)
        val loginBTN: Button = findViewById(R.id.loginBtn)

        //==============================LOGIN BTN=====================================
        loginBTN.setOnClickListener {

            // ========================LOGIC============================
            //we get the data on the firts parameter, the second paramenter is the response listener
            ProcessResponse(processTransSearch(), TransactionSearchListenerResponse { result, response ->
                loginIntent.putExtra(PROCESS_TRANSACTION, response)
                loginIntent.putExtra("ACCNUMBER",processTransSearch().accountID)
                if(response!!.responseValidated == "TRUE")
                    startActivity(loginIntent)
                else
                    Toast.makeText(applicationContext, "User not register", Toast.LENGTH_SHORT).show()
            }).execute()
          // =======================================================
        }

        //====================SiGN up BUTTOn=================
        singBTN.setOnClickListener {
            startActivityForResult(signUpIntent,1)
        }

    }

    //ProcessDebit
    private fun processDebit(){
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

        //here we get the response
        ProcessResponse(processDebit, object : DebitListenerResponse{
            override fun downloadCompleted(result: String?, response: ResponseDebit?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())

            }

        }).execute()

    }

    //ProcessCredit
    private fun processCredit(){
        //----------------------CREDIT Request------------------------

        val processCredit = ProcessCredit_Request()
        processCredit.username          = "Jesus123"
        processCredit.password          = "1234"
        processCredit.accountID         = "001"
        processCredit.customerName      = "jesus"
        processCredit.customerEmail     = "test@test.com"
        processCredit.address1          = "addres1"
        processCredit.address2          = "addres2"
        processCredit.city              = "SJ"
        processCredit.state             = "PR"
        processCredit.zipcode           = "00960"
        processCredit.trxDescription    = "Pago"
        processCredit.trxAmount         = "0.1"
        processCredit.trxOper           = "sale"
        processCredit.trxID             = "123"
        processCredit.refNumber         = "123456"
        processCredit.trxTermID         = " "
        processCredit.cardNumber        = "930840000000036"
        processCredit.expDate           = "1249"
        processCredit.cvv               = "781"
        processCredit.trxTipAmount      = ""
        processCredit.trxTax1           = ""
        processCredit.trxTax2           = ""

        for(i in 0..2){
            processCredit.filler[i] = "filler$i"
        }

        //Credit Response
        ProcessResponse(processCredit, object : CreditListenerResponse{
            override fun downloadCompleted(result: String?, response: ResponseCredit?) {

                Log.d("Result", result);
                Log.d("Response", response.toString())

            }

        }).execute()

    }

    //ProcessACH
    private fun processACH(){
        val processACH = ProcessACH_Request()
        processACH.username          = "Jesus123"
        processACH.password          = "1234"
        processACH.accountID         = "001"
        processACH.customerName      = "jesus"
        processACH.customerEmail     = "test@test.com"
        processACH.address1          = "addres1"
        processACH.address2          = "addres2"
        processACH.city              = "SJ"
        processACH.state             = "PR"
        processACH.zipcode           = "00960"
        processACH.trxDescription    = "Pago"
        processACH.trxAmount         = "0.1"
        processACH.trxOper           = "sale"
        processACH.trxID             = "123"
        processACH.refNumber         = "123456"
        processACH.trxTermID         = " "
        processACH.backAccount       = "13465754"
        processACH.routing           = "asdsadasda"
        processACH.accType           = "w"


        for(i in 0..2){
            processACH.filler[i] = "filler$i"
        }

        //here we get the response
        ProcessResponse(processACH, object : ACHResponseListener{
            override fun downloadCompleted(result: String?, response: ResponseACH?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())

            }

        }).execute()


    }

    //Process Online Response
    private fun processOnlineResponse(){
        val processOnlineR = ProcessOnline_Request()
        processOnlineR.username          = "Jesus123"
        processOnlineR.password          = "1234"
        processOnlineR.accountID         = "001"
        processOnlineR.trxDescription    = "Pago"
        processOnlineR.trxAmount         = "0.1"
        processOnlineR.trxID             = "123"
        processOnlineR.paymentMethod     = "addres1"
        processOnlineR.authNumber        = "city"
        processOnlineR.confNumber        = "state"
        processOnlineR.filler            = "00960"


        ProcessResponse(processOnlineR, object : OnlineListenerResponse{
            override fun downloadCompleted(result: String?, response: ResponseOnlineResponse?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())
            }
        }).execute()

    }

    //Process WalletTransaction
    private fun processWalletTrans(){

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


        ProcessResponse(processPW, object : WalletListenerResponse {
            override fun downloadCompleted(result: String, response: ResponseWalletTransaction?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())
            }
        }).execute()

    }

    //Process CheckoutPayment
    private fun processCheckoutPay(){
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

        ProcessResponse(checkoutPayment, object : CheckoutPaymentListenerResponse {
            override fun downloadCompleted(result: String, response: ResponseCheckoutPayment?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())
            }
        }).execute()

    }

    //Process TransactionSearch
    private fun processTransSearch(): ProcessTransactionSearch_Request{
        val transactionSearch = ProcessTransactionSearch_Request()
        transactionSearch.username          = "Jesus123"
        transactionSearch.password          = "1234"
        transactionSearch.accountID         = "3456"
        transactionSearch.trxID             = "123456"
        transactionSearch.trxAmount         = "0.1"

//          //Lo comento aqui porque lo uso arriba
//        ProcessResponse(transactionSearch, object : TransactionSearchListenerResponse {
//            override fun downloadCompleted(result: String, response: ResponseTransactionSearch?) {
//                Log.d("Result", result);
//                Log.d("Response", response.toString())
//            }
//        }).execute()
//
        return transactionSearch
    }
    //---------------------------------------------------------
}
