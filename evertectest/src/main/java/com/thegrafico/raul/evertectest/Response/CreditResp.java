package com.thegrafico.raul.evertectest.Response;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.CreditListenerResponse;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessCredit_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseCredit;
import com.thegrafico.raul.evertectest.Request.MakeRequest;

public class CreditResp extends AsyncTask<String, Void, String>  {

    //Classes
    private ProcessCredit_Request dataToPost;
    private CreditListenerResponse completedListener;

    //GSON
    private Gson gson;
    private String dataInJson;


    //Constructor
    public CreditResp(ProcessCredit_Request dataToPost, CreditListenerResponse completeListener){

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
            ResponseCredit respuesta = gson.fromJson(s, ResponseCredit.class);
            completedListener.downloadCompleted(s, respuesta);
        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
    }

}

