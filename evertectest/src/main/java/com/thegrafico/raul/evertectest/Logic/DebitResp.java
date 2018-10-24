package com.thegrafico.raul.evertectest.Logic;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.DebitListenerResponse;
import com.thegrafico.raul.evertectest.Logic.Request.MakeRequest;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessDebit_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseDebit;

public class DebitResp extends AsyncTask<String, Void, String> {

    private DebitListenerResponse completeListener;
    private ProcessDebit_Request dataToPost;
    private Gson gson;
    private String dataInJson;

    public DebitResp(ProcessDebit_Request dataToPost, DebitListenerResponse completeListener){

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
            ResponseDebit respuesta = gson.fromJson(s, ResponseDebit.class);

            completeListener.downloadCompleted(s, respuesta );
        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
    }
}
