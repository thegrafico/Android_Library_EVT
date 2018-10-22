package com.thegrafico.raul.evertectest.Modals.Response;

public class ResponseTransactionSearch {

    private String
                    authNumber      = null,
                    bathNumber      = null,
                    merchantid      = null,
                    rCode           = null,
                    rMsg            = null,
                    refNumber       = null,
                    resquestID      = null,
                    statusCode      = null,
                    trxDateTime     = null,
                    trxID           = null,
                    trxoper         = null,
                    trxtype         = null;

    public ResponseTransactionSearch(){
        super();
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public void setAuthNumber(String authNumber) {
        this.authNumber = authNumber;
    }

    public String getBathNumber() {
        return bathNumber;
    }

    public void setBathNumber(String bathNumber) {
        this.bathNumber = bathNumber;
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

    public String getResquestID() {
        return resquestID;
    }

    public void setResquestID(String resquestID) {
        this.resquestID = resquestID;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTrxDateTime() {
        return trxDateTime;
    }

    public void setTrxDateTime(String trxDateTime) {
        this.trxDateTime = trxDateTime;
    }

    public String getTrxID() {
        return trxID;
    }

    public void setTrxID(String trxID) {
        this.trxID = trxID;
    }

    public String getTrxoper() {
        return trxoper;
    }

    public void setTrxoper(String trxoper) {
        this.trxoper = trxoper;
    }

    public String getTrxtype() {
        return trxtype;
    }

    public void setTrxtype(String trxtype) {
        this.trxtype = trxtype;
    }

    @Override
    public String toString() {
        return "ResponseTransactionSearch{" +
                "authNumber='" + authNumber + '\'' +
                ", bathNumber='" + bathNumber + '\'' +
                ", merchantid='" + merchantid + '\'' +
                ", rCode='" + rCode + '\'' +
                ", rMsg='" + rMsg + '\'' +
                ", refNumber='" + refNumber + '\'' +
                ", resquestID='" + resquestID + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", trxDateTime='" + trxDateTime + '\'' +
                ", trxID='" + trxID + '\'' +
                ", trxoper='" + trxoper + '\'' +
                ", trxtype='" + trxtype + '\'' +
                '}';
    }
}
