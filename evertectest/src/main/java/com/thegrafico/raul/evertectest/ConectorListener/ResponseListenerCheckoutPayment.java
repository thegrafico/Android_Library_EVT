package com.thegrafico.raul.evertectest.ConectorListener;

import com.thegrafico.raul.evertectest.Modals.Response.ResponseCheckoutPayment;

public interface ResponseListenerCheckoutPayment {

    void downloadCompleted(String result, ResponseCheckoutPayment response);

}
