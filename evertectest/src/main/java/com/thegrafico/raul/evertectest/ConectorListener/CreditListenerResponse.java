package com.thegrafico.raul.evertectest.ConectorListener;

import com.thegrafico.raul.evertectest.Modals.Response.ResponseCredit;

public interface CreditListenerResponse {

    void downloadCompleted(String result, ResponseCredit response);

}
