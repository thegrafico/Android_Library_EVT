package com.thegrafico.raul.evertectest.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MakeRequest {

   static String URL = "http://10.0.2.2:2000/processDebit/";

    static public String getDataFromRequest(String dataToMakeRequest){

        //Object Connection
        HttpURLConnection urlConnection = null;
        try{

            URL url = new URL(URL);

            //Object Connection
            urlConnection = (HttpURLConnection) url.openConnection();

            //SetUp
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");

            //Open Connection
            urlConnection.connect();

            //Send Data setup
            OutputStream os = urlConnection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");

            //sending data
            osw.write(dataToMakeRequest);

            //clean/close sending data
            osw.flush();
            osw.close();

            //To read Data

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;

            //while there is data to read
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            //close de streamReader
            streamReader.close();

            //returns the json object
            return responseStrBuilder.toString();

            //error handle
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if (urlConnection != null){
                urlConnection.disconnect();
            }
        }

        //if everything go well, never end in this point
        return null;
    }
}
