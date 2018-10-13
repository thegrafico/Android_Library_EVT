package com.thegrafico.raul.evertectest;
class ProcessWalletTransaction_J {

    private String username, password, accountNumber, trxID, trxAmout, refNumber, trxDescription, filler1;

    //Constructor
    public ProcessWalletTransaction_J(){}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getAccountNumber() {return accountNumber;}
    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}

    public String getTrxID() {return trxID;}
    public void setTrxID(String trxID) {this.trxID = trxID;}

    public String getTrxAmout() {return trxAmout;}
    public void setTrxAmout(String trxAmout) {this.trxAmout = trxAmout;}

    public String getRefNumber() {return refNumber;}
    public void setRefNumber(String refNumber) {this.refNumber = refNumber;}

    public String getTrxDescription() {return trxDescription;}
    public void setTrxDescription(String trxDescription) {this.trxDescription = trxDescription;}

    public String getFiller1() {return filler1;}
    public void setFiller1(String filler1) {this.filler1 = filler1;}

//    public void trxOper(String oper){
//        oper = oper.toLowerCase();
//        if(oper == VOID)
//            void_oper();
//        else if(oper == REFUND)
//            refund_oper();
//        else if(oper == SALE)
//            sale_oper();
//
//    }

    //Operations
    private String void_oper(){
        return "Hi, I'm VOID Operation";
    }

    private String refund_oper(){
        return "Hi, I'm REFUND Operation";
    }

    private String sale_oper(){
        return "Hi, I'm SALE Operation";
    }

}
