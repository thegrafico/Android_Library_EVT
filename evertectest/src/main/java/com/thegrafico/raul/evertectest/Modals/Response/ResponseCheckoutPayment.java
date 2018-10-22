package com.thegrafico.raul.evertectest.Modals.Response;

public class ResponseCheckoutPayment {

    private String
                    rCode = null,
                    rMsg  = null,
                    requestID = null;

    public ResponseCheckoutPayment(){super();}

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

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @Override
    public String toString() {
        return "ResponseCheckoutPayment{" +
                "rCode='" + rCode + '\'' +
                ", rMsg='" + rMsg + '\'' +
                ", requestID='" + requestID + '\'' +
                '}';
    }
}
