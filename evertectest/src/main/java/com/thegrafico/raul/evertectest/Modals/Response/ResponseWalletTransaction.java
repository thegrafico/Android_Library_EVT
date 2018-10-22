package com.thegrafico.raul.evertectest.Modals.Response;

public class ResponseWalletTransaction {


    private String
            authNumber  = null,
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

    public void setAuthNumber(String authNumber) {
        this.authNumber = authNumber;
    }

    public String getBachNumber() {
        return bachNumber;
    }

    public void setBachNumber(String bachNumber) {
        this.bachNumber = bachNumber;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getPostingdate() {
        return postingdate;
    }

    public void setPostingdate(String postingdate) {
        this.postingdate = postingdate;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public String getrMgs() {
        return rMgs;
    }

    public void setrMgs(String rMgs) {
        this.rMgs = rMgs;
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

    public String getSystemTrace() {
        return systemTrace;
    }

    public void setSystemTrace(String systemTrace) {
        this.systemTrace = systemTrace;
    }

    public String getTrxDataTime() {
        return trxDataTime;
    }

    public void setTrxDataTime(String trxDataTime) {
        this.trxDataTime = trxDataTime;
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
        return "ResponseWalletTransaction{" +
                "authNumber='" + authNumber + '\'' +
                ", bachNumber='" + bachNumber + '\'' +
                ", merchantid='" + merchantid + '\'' +
                ", postingdate='" + postingdate + '\'' +
                ", rCode='" + rCode + '\'' +
                ", rMgs='" + rMgs + '\'' +
                ", refNumber='" + refNumber + '\'' +
                ", requestID='" + requestID + '\'' +
                ", systemTrace='" + systemTrace + '\'' +
                ", trxDataTime='" + trxDataTime + '\'' +
                ", trxID='" + trxID + '\'' +
                ", trxoper='" + trxoper + '\'' +
                ", trxtype='" + trxtype + '\'' +
                '}';
    }

}
