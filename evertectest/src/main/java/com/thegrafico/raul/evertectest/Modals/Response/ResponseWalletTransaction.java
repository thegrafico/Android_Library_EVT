package com.thegrafico.raul.evertectest.Modals.Response;

public class ResponseWalletTransaction {


    private String      authNumber  = null,
                        bachNumber  = null,
                        merchantid  = null,
                        postingdate = null,
                        rCode       = null,
                        rMgs        = null,
                        refNumber   = null,
                        requestID   = null,
                        systemTrace = null,
                        trxDataTime = null,
                        trxID       = null,
                        trxoper     = null,
                        trxtype     = null;

    public ResponseWalletTransaction(){
        super();
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public String getBachNumber() {
        return bachNumber;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public String getPostingdate() {
        return postingdate;
    }

    public String getrCode() {
        return rCode;
    }

    public String getrMgs() {
        return rMgs;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public String getRequestID() {
        return requestID;
    }

    public String getSystemTrace() {
        return systemTrace;
    }

    public String getTrxDataTime() {
        return trxDataTime;
    }

    public String getTrxID() {
        return trxID;
    }

    public String getTrxoper() {
        return trxoper;
    }

    public String getTrxtype() {
        return trxtype;
    }
}
