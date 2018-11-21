package com.thegrafico.raul.evertec_library_02

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.thegrafico.raul.evertectest.ConectorListener.*
import com.thegrafico.raul.evertectest.Modals.Request.*
import com.thegrafico.raul.evertectest.Modals.Response.*
import com.thegrafico.raul.evertectest.Modals.User
import com.thegrafico.raul.evertectest.Request.MakeRequest
import com.thegrafico.raul.evertectest.Response.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var singBTN: Button = findViewById(R.id.signBtn)

        var loginBTN: Button = findViewById(R.id.loginBtn)

        var username_emailET: TextInputEditText = findViewById(R.id.email_username)
        var passET: EditText = findViewById(R.id.password)

        //login
        loginBTN.setOnClickListener {
            if(username_emailET.text.isNullOrEmpty() || username_emailET.text!!.length < 5){
                Toast.makeText(this, "Invalid username", Toast.LENGTH_SHORT).show()
            }else{
               var user = User()
                user.username = username_emailET.text.toString()
                user.pass = passET.text.toString()

                Toast.makeText(this, MakeRequest.validateUser(user), Toast.LENGTH_LONG).show()
            }
        }

        //SiGN up
        singBTN.setOnClickListener {

        }




    }


    //GENERAL CLASS
    fun generalClass(){

        //Debit
        processDebit()

        //Credit
        processCredit()

        //ACH
        processACH()

        //OnlineResponse
        processOnlineResponse()

        //Wallet Transaction
        processWalletTrans()

        //checkoutPayment
        processCheckoutPay()

        //TransactionSearch
        processTransSearch()
    }


    //-------------------ALL PROCESS FUNCTION-----------------
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

        //here we get the response
        ProcessResponse(processDebit, object : DebitListenerResponse{
            override fun downloadCompleted(result: String?, response: ResponseDebit?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())

            }

        }).execute()

    }

    //ProcessCredit
    fun processCredit(){
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
    fun processACH(){
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
    fun processOnlineResponse(){
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

        ProcessResponse(processPW, object : WalletListenerResponse {
            override fun downloadCompleted(result: String, response: ResponseWalletTransaction?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())
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

        ProcessResponse(checkoutPayment, object : CheckoutPaymentListenerResponse {
            override fun downloadCompleted(result: String, response: ResponseCheckoutPayment?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())
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


        ProcessResponse(transactionSearch, object : TransactionSearchListenerResponse {
            override fun downloadCompleted(result: String, response: ResponseTransactionSearch?) {
                Log.d("Result", result);
                Log.d("Response", response.toString())
            }
        }).execute()
    }
    //---------------------------------------------------------

}
