package com.thegrafico.raul.evertectest.Logic;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.CheckoutPaymentListenerResponse;
import com.thegrafico.raul.evertectest.Logic.Request.MakeRequest;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessCheckoutPayment_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseCheckoutPayment;

import java.util.concurrent.ExecutionException;

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

        try{
            return MakeRequest.getDataFromRequest(dataInJson);
        }catch (Exception e){
            Log.d("Error", "Download can't be completed\n" + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            ResponseCheckoutPayment respuesta = gson.fromJson(s, ResponseCheckoutPayment.class);

            completeListener.downloadCompleted(s, respuesta );
        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
    }
}
