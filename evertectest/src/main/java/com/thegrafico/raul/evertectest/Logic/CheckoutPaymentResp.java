package com.thegrafico.raul.evertectest.Logic;


import android.os.AsyncTask;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.CheckoutPaymentListenerResponse;
import com.thegrafico.raul.evertectest.Logic.Request.MakeRequest;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessCheckoutPayment_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseCheckoutPayment;

public class CheckoutPaymentResp extends AsyncTask<String, Void, String> {

    private CheckoutPaymentListenerResponse completeListener;
    private ProcessCheckoutPayment_Request dataToPost;
    private Gson gson;
    private String dataInJson;

    public CheckoutPaymentResp(ProcessCheckoutPayment_Request dataToPost, CheckoutPaymentListenerResponse completeListener){

        this.completeListener = completeListener;
        this.dataToPost = dataToPost;
        gson = new Gson();

        dataInJson = gson.toJson(this.dataToPost);
    }

    @Override
    protected String doInBackground(String... strings) {

        return MakeRequest.getDataFromRequest(dataInJson);
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            ResponseCheckoutPayment respuesta = gson.fromJson(s, ResponseCheckoutPayment.class);

            completeListener.downloadCompleted(s, respuesta );
        }finally {

        }
    }
}
