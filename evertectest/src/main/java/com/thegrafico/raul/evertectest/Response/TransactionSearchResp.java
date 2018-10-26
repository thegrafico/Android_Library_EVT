package com.thegrafico.raul.evertectest.Response;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.TransactionSearchListenerResponse;
import com.thegrafico.raul.evertectest.Request.MakeRequest;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessTransactionSearch_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseTransactionSearch;

public class TransactionSearchResp extends AsyncTask<String, Void, String> {


    //Listener
    private TransactionSearchListenerResponse completeListener;

    //RESQUEST DATA
    private ProcessTransactionSearch_Request dataToPost;

    private Gson gson;
    private String dataInJson;

    public TransactionSearchResp(ProcessTransactionSearch_Request dataToPost, TransactionSearchListenerResponse completeListener){

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
            ResponseTransactionSearch respuesta = gson.fromJson(s, ResponseTransactionSearch.class);

            completeListener.downloadCompleted(s, respuesta );
        }catch (Exception e){
            Log.d("ERROR", e.getMessage());
        }
    }
}
