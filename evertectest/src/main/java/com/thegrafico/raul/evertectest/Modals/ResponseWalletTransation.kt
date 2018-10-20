package com.thegrafico.raul.evertectest.Modals

data class ResponseWalletTransaction(
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
) {
    override fun toString(): String {
        return "ResponseWalletTransation(authNumber=$authNumber, bachNumber=$bachNumber, merchantid=$merchantid, postingdate=$postingdate, rCode=$rCode, rMgs=$rMgs, refNumber=$refNumber, requestID=$requestID, systemTrace=$systemTrace, trxDataTime=$trxDataTime, trxID=$trxID, trxoper=$trxoper, trxtype=$trxtype)"
    }
}

//val response = gson.fromJson(respJSON, ResponseWalletTransation::class.java)

//TODO CREAR JERARQUIA