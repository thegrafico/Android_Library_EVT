package com.thegrafico.raul.evertectest

data class ResponseWalletTransation(
    var authNumber:String? = null,
    var bachNumber:String? = null,
    var merchantid:String? =  null,
    var postingdate:String? = null,
    var rCode: String? = null,
    var rMgs: String? = null,
    var refNumber: String? = null,
    var requestID: String?= null,
    var systemTrace: String? = null,
    var trxDataTime :String? = null,
    var trxID: String? = null,
    var trxoper: String? = null,
    var trxtype: String? = null
)

