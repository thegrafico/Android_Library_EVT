package com.thegrafico.raul.evertectest.ConectorListener;

import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction;

public interface WalletTransactionListenerResponse {

    void downloadCompleted(String result, ResponseWalletTransaction response);

}