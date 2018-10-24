package com.thegrafico.raul.evertectest.Modals.Response.inheritance;

public class DataResponse {

    private String
        authNumber      = null,
        batchNumber     = null,
        merchantid      = null,
        rCode           = null,
        rMsg            = null,
        refNumber       = null,
        requestID       = null,
        trxID           = null,
        trxtype         = null;

    public DataResponse(){}

    @Override
    public String toString() {
        return "DataResponse{" +
                "authNumber='" + authNumber + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", merchantid='" + merchantid + '\'' +
                ", rCode='" + rCode + '\'' +
                ", rMsg='" + rMsg + '\'' +
                ", refNumber='" + refNumber + '\'' +
                ", requestID='" + requestID + '\'' +
                ", trxID='" + trxID + '\'' +
                ", trxtype='" + trxtype + '\'' +
                '}';
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public void setAuthNumber(String authNumber) {
        this.authNumber = authNumber;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public String getrMsg() {
        return rMsg;
    }

    public void setrMsg(String rMsg) {
        this.rMsg = rMsg;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getTrxID() {
        return trxID;
    }

    public void setTrxID(String trxID) {
        this.trxID = trxID;
    }

    public String getTrxtype() {
        return trxtype;
    }

    public void setTrxtype(String trxtype) {
        this.trxtype = trxtype;
    }
}
