package com.thegrafico.raul.evertectest.Modals.Request;

import com.thegrafico.raul.evertectest.Modals.Request.InheritanceData.Data;

public class ProcessCredit_Request extends Data {

    private String
            cvv             = null,
            trxTipAmount    = null,
            trxTax1         = null,
            trxTax2         = null,
            cardNumber      = null,
            expDate         = null;

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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

}
