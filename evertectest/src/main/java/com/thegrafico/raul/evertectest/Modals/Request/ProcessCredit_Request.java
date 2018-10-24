package com.thegrafico.raul.evertectest.Modals.Request;

public class ProcessCredit_Request extends ProcessDebit_Request {

    private String
            cvv             = null,
            trxTipAmount    = null,
            trxTax1         = null,
            trxTax2         = null;

   public ProcessCredit_Request(){}

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getTrxTipAmount() {
        return trxTipAmount;
    }

    public void setTrxTipAmount(String trxTipAmount) {
        this.trxTipAmount = trxTipAmount;
    }

    public String getTrxTax1() {
        return trxTax1;
    }

    public void setTrxTax1(String trxTax1) {
        this.trxTax1 = trxTax1;
    }

    public String getTrxTax2() {
        return trxTax2;
    }

    public void setTrxTax2(String trxTax2) {
        this.trxTax2 = trxTax2;
    }
}
