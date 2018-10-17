package com.thegrafico.raul.evertectest;

import com.google.gson.Gson;

public class WalletTransactionResp {

    public WalletTransactionResp() {
        super();
    }
    private String datos = "";

    public  WalletTransactionResp(String jsonResp) {
        datos = jsonResp;
    }

    public String getDatos(){
        return datos;
    }
    public void setDatos(String datos){
        this.datos = datos;
    }
}
