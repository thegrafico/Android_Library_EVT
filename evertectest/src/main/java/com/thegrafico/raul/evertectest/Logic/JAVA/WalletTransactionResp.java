package com.thegrafico.raul.evertectest.Logic.JAVA;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.CompleteListener;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WalletTransactionResp extends AsyncTask<String, Void, String> {

    String URL = "https://private-f2106d-evertec1.apiary-mock.com/questions";
    private CompleteListener completeListener;
    private ProcessWalletTransaction dataToPost;
    private Gson gson;
    private String dataInJson;

    public WalletTransactionResp(ProcessWalletTransaction dataToPost, CompleteListener completeListener){
        this.completeListener = completeListener;
        this.dataToPost = dataToPost;
        gson = new Gson();

        dataInJson = gson.toJson(dataToPost);
    }

    @Override
    protected String doInBackground(String... strings) {

        return getDataFromRequest(URL);
    }

    @Override
    protected void onPostExecute(String s) {
       try{
           ResponseWalletTransaction respuesta = gson.fromJson(s, ResponseWalletTransaction.class);

           completeListener.downloadCompleted(s, respuesta );
       }finally {

       }
    }

    private String getDataFromRequest(String urlWeb){

        //Object Connection
        HttpURLConnection urlConnectionon = null;
        try{

            URL url = new URL(urlWeb);

            //Object Connection
            urlConnectionon = (HttpURLConnection) url.openConnection();

            //SetUp
            urlConnectionon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnectionon.setRequestProperty("Accept", "application/json");
            urlConnectionon.setDoOutput(true);
            urlConnectionon.setRequestMethod("POST");

            //Open Connection
            urlConnectionon.connect();

            //Send Data setup
            OutputStream os = urlConnectionon.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

            //sending data
            osw.write(dataInJson);

            //
            osw.flush();
            osw.close();

            //To read Data
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(urlConnectionon.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;

            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            streamReader.close();

            //returns the json object
            return responseStrBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (urlConnectionon != null){
                urlConnectionon.disconnect();
            }
        }
        return null;
    }
}
