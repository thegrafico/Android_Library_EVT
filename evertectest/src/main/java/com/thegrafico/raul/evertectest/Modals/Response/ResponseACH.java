package com.thegrafico.raul.evertectest.Modals.Response;

import com.thegrafico.raul.evertectest.Modals.Response.inheritance.DataResponse;

public class ResponseACH extends DataResponse {

//    authNumber      = null,
//    batchNumber     = null,
//    merchantid      = null,
//    rCode           = null,
//    rMsg            = null,
//    refNumber       = null,
//    requestID       = null,
//    trxID           = null,
//    trxtype         = null;

    private String trxOper = null;

    @Override
    public String toString() {
        return super.toString() +
                "ResponseProcessACH{" +
                "trxOper='" + trxOper + '\'' +
                '}';
    }

    public String getTrxOper() {
        return trxOper;
    }

    public void setTrxOper(String trxOper) {
        this.trxOper = trxOper;
    }
}
