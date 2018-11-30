/*Listener to get the response for Search transaction */

package com.thegrafico.raul.evertectest.ConectorListener;

import com.thegrafico.raul.evertectest.Modals.Response.ResponseTransactionSearch;

public interface TransactionSearchListenerResponse {
    //method response
    void downloadCompleted(String result, ResponseTransactionSearch response);

}
