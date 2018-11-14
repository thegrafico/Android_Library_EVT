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

    static public String getDataFromRequest(String dataToMakeRequest, int choose){

        //Object Connection
        HttpURLConnection urlConnection = null;
        try{

            URL url = new URL(chooseURL(choose));

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

    private static String chooseURL(int choose){
        String URL = " ";

        switch (choose){
            case 1: //Process Debit Transaction
                URL = "http://192.168.43.118:2000/processDebit/";
                break;
            case 2: //Process Credit Transaction
                URL = "http://192.168.43.118:2000/processCredit/";

                break;
            case 3: //Process ACH Transaction
                URL = "http://192.168.43.118:2000/processACH/";
                break;
            case 4: //Process Wallet Transaction Transaction
                URL = "http://192.168.43.118:2000/processWallet/";
                break;
            case 5: //Process Checkout Payment Transaction
                URL = "http://192.168.43.118:2000/processCheckout/";
                break;
            case 6: //Process Online Transaction
                URL = "http://192.168.43.118:2000/processOnline/";
                break;
            case 7: //Process Transaction Search Transaction
                URL = "http://192.168.43.118:2000/processTransactionSearch/";
                break;
        }

        return URL;
    }
}
