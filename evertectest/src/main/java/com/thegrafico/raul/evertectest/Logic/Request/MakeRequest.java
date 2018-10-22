package com.thegrafico.raul.evertectest.Logic.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MakeRequest {

   static String URL = "https://private-f2106d-evertec1.apiary-mock.com/questions";

    static public String getDataFromRequest(String dataToMakeRequest){

        //Object Connection
        HttpURLConnection urlConnectionon = null;
        try{

            URL url = new URL(URL);

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
            osw.write(dataToMakeRequest);

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
