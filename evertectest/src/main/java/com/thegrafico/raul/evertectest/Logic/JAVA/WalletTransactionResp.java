package com.thegrafico.raul.evertectest.Logic.JAVA;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.thegrafico.raul.evertectest.CompleteListener;
import com.thegrafico.raul.evertectest.Modals.ProcessWalletTransactionData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WalletTransactionResp extends AsyncTask<String, Void, String> {

    private CompleteListener completeListener;
    private ProcessWalletTransactionData dataToPost;
    private Gson gson;
    private String dataInJson = "";

    public WalletTransactionResp(ProcessWalletTransactionData dataToPost, CompleteListener completeListener){
        this.completeListener = completeListener;
        this.dataToPost = dataToPost;
        gson = new Gson();

        dataInJson = gson.toJson(dataToPost);
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
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
            return gson.toJson(responseStrBuilder);


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
