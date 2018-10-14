package com.thegrafico.raul.evertectest;


import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ProcessWalletTransaction_TEST_{

    private Gson gson;
    private ProcessWalletTransactionData processWalletTransaction;

    public ProcessWalletTransaction_TEST_(ProcessWalletTransactionData processWalletTransaction){

        this.processWalletTransaction = processWalletTransaction;

        gson = new GsonBuilder().setPrettyPrinting().create();


    }
    //TODO: ME quede convirtiendo la url en una variable global
    //Conver to JSON FILE
    public String exec(){
        return gson.toJson(processWalletTransaction);
    }
}
