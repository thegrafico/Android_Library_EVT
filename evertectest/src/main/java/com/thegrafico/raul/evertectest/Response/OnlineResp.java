package com.thegrafico.raul.evertectest.Response;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.ACHResponseListener;
import com.thegrafico.raul.evertectest.ConectorListener.DebitListenerResponse;
import com.thegrafico.raul.evertectest.ConectorListener.OnlineListenerResponse;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessOnline_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseOnlineResponse;
import com.thegrafico.raul.evertectest.Request.MakeRequest;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessDebit_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseDebit;

public class OnlineResp extends AsyncTask<String, Void, String>  {

    //Classes
    private ProcessOnline_Request dataToPost;
    private OnlineListenerResponse completedListener;

    //TODO: MAKE ENUM OG METHOD
//    private enum paymentType{}
//    private paymentType pt;
//
    //GSON
    private Gson gson;
    private String dataInJson;


    //Constructor
    public OnlineResp(ProcessOnline_Request dataToPost, OnlineListenerResponse completeListener){

        //REQUEST
        this.dataToPost =  dataToPost;

        //LISTENER
        completedListener = completeListener;

        //MAKE REQUEST JSON OBJECT
        gson = new Gson();
        dataInJson = gson.toJson(this.dataToPost);
    }

    //Thread background
    @Override
    protected String doInBackground(String... strings) {

        try{
            return MakeRequest.getDataFromRequest(dataInJson);
        }catch (Exception e){
            Log.d("Error", "Download can't be completed\n" + e.getMessage());
        }
        return null;
    }

    //before download complete
    @Override
    protected void onPostExecute(String s) {
        try{
            ResponseOnlineResponse respuesta = gson.fromJson(s, ResponseOnlineResponse.class);
            completedListener.downloadCompleted(s, respuesta);
        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
    }

}

