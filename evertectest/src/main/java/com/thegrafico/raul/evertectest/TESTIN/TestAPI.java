package com.thegrafico.raul.evertectest.TESTIN;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.ACHResponseListener;
import com.thegrafico.raul.evertectest.ConectorListener.CheckoutPaymentListenerResponse;
import com.thegrafico.raul.evertectest.ConectorListener.CreditListenerResponse;
import com.thegrafico.raul.evertectest.ConectorListener.DebitListenerResponse;
import com.thegrafico.raul.evertectest.ConectorListener.OnlineListenerResponse;
import com.thegrafico.raul.evertectest.ConectorListener.TransactionSearchListenerResponse;
import com.thegrafico.raul.evertectest.ConectorListener.WalletTransactionListenerResponse;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessACH_Request;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessCheckoutPayment_Request;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessCredit_Request;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessDebit_Request;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessOnline_Request;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessTransactionSearch_Request;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseACH;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseCheckoutPayment;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseCredit;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseDebit;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseOnlineResponse;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseTransactionSearch;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction;
import com.thegrafico.raul.evertectest.Request.MakeRequest;

public class TestAPI extends AsyncTask<String, Void, String> {

    //GENERAL OBJECT
    private Object request;

    //LISTENER
    private TestListener testListener;

    //VARIABLES
    private int count = 0;
    private Gson gson = new Gson();

    //Process Debit
    public TestAPI(TestRequest request, TestListener downloadComplete){
        //COUNT FOR SWITCH
        count = 1;

        this.request = request;
        //responseListener

        testListener = downloadComplete;
    }


    //---------------Thread background Process-------------------
    @Override
    protected String doInBackground(String... strings) {

        try{
            return MakeRequest.getDataFromRequest(gson.toJson(request));
        }catch (Exception e){
            Log.d("Error", "Download can't be completed\n" + e.getMessage());
        }
        return null;
    }

    //before download complete
    @Override
    protected void onPostExecute(String s) {
        try{
           testListener.downloadCompleted(s);
        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
    }

    //-------------------END CHOSE--------------------------------------------
}

