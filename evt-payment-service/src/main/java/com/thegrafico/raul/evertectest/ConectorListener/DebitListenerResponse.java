/*Listener to get the response for Debit Transaction transaction */

package com.thegrafico.raul.evertectest.ConectorListener;

import com.thegrafico.raul.evertectest.Modals.Response.ResponseDebit;

public interface DebitListenerResponse {
    //method response
    void downloadCompleted(String result, ResponseDebit response);

}
