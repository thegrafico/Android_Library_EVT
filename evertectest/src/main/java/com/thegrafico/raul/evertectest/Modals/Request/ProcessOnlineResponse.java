package com.thegrafico.raul.evertectest.Modals.Request;

public class ProcessOnlineResponse extends ProcessTransactionSearch_Request {

    private String
            paymentMethod       = null,
            trxDescription      = null,
            authNumber          = null,
            confNumber          = null,
            filler              = null;

    public ProcessOnlineResponse(){}

    @Override
    public String toString() {
        return "ProcessOnlineResponse{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", trxDescription='" + trxDescription + '\'' +
                ", authNumber='" + authNumber + '\'' +
                ", confNumber='" + confNumber + '\'' +
                ", filler='" + filler + '\'' +
                '}';
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTrxDescription() {
        return trxDescription;
    }

    public void setTrxDescription(String trxDescription) {
        this.trxDescription = trxDescription;
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public void setAuthNumber(String authNumber) {
        this.authNumber = authNumber;
    }

    public String getConfNumber() {
        return confNumber;
    }

    public void setConfNumber(String confNumber) {
        this.confNumber = confNumber;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }
}
