package com.thegrafico.raul.evertectest.Response;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.ConectorListener.ACHResponseListener;
import com.thegrafico.raul.evertectest.ConectorListener.DebitListenerResponse;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessACH_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseACH;
import com.thegrafico.raul.evertectest.Request.MakeRequest;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessDebit_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseDebit;

public class ACHResp extends AsyncTask<String, Void, String>  {

    //Classes
    private ProcessACH_Request dataToPost;
    private ACHResponseListener completedListener;

    //TODO: MAKE ENUM OG METHOD
//    private enum paymentType{}
//    private paymentType pt;
//
    //GSON
    private Gson gson;
    private String dataInJson;


    //Constructor
    public ACHResp(ProcessACH_Request dataToPost, ACHResponseListener completeListener){

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
            ResponseACH respuesta = gson.fromJson(s, ResponseACH.class);
            completedListener.downloadCompleted(s, respuesta);
        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
    }

}