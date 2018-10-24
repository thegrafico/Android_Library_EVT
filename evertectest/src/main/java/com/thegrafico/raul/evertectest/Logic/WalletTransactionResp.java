package com.thegrafico.raul.evertectest.Logic;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.WalletTransactionListenerResponse;
import com.thegrafico.raul.evertectest.Logic.Request.MakeRequest;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction;


public class WalletTransactionResp extends AsyncTask<String, Void, String> {

    private WalletTransactionListenerResponse completeListener;
    private ProcessWalletTransaction_Request dataToPost;
    private Gson gson;
    private String dataInJson;

    public WalletTransactionResp(ProcessWalletTransaction_Request dataToPost, WalletTransactionListenerResponse completeListener){
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
           ResponseWalletTransaction respuesta = gson.fromJson(s, ResponseWalletTransaction.class);

           completeListener.downloadCompleted(s, respuesta );
       }catch (Exception e){
           Log.d("ERROR", e.getMessage());
       }
    }
}
