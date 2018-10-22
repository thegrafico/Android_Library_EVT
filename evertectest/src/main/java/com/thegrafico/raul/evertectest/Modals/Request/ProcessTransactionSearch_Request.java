package com.thegrafico.raul.evertectest.Modals.Request;

public class ProcessTransactionSearch_Request {

    private String
                    username    = null,
                    password    = null,
                    accountID   = null,
                    trxID       = null,
                    trxAmount   = null;

    public ProcessTransactionSearch_Request(){
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getTrxID() {
        return trxID;
    }

    public void setTrxID(String trxID) {
        this.trxID = trxID;
    }

    public String getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(String trxAmount) {
        this.trxAmount = trxAmount;
    }
}
