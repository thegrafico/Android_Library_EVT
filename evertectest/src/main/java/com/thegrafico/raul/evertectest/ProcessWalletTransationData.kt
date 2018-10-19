package com.thegrafico.raul.evertectest
//Constructor
class ProcessWalletTransactionData{


    //OPERATIONS
    private val txrOperSALE: String = "SALE"
    private val txrOperVOID: String = "VOID"
    private val txrOperREFUND: String = "REFUND"

    //Set and Getter of Variables
    var username: String? = null
    var password: String? = null
    var accountNumber: String? = null
    var trxID: String? = null
    var trxAmout: String? = null
    var refNumber: String? = null
    var trxDescription: String? = null
    var filler1: String? = null
    var trxOper:String? = null

    //GetTheOperation
    fun SALE():String{return txrOperSALE}
    fun VOID():String{return txrOperSALE}
    fun REFUN():String{return txrOperSALE}
}

