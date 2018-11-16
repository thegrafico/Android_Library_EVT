package com.thegrafico.raul.evertec_library_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.thegrafico.raul.evertectest.ConectorListener.DebitListenerResponse;
import com.thegrafico.raul.evertectest.ConectorListener.WalletListenerResponse;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessDebit_Request;
import com.thegrafico.raul.evertectest.Modals.Request.ProcessWalletTransaction_Request;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseDebit;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseWalletTransaction;
import com.thegrafico.raul.evertectest.Response.ProcessResponse;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processDebit();
            }
        });


    }

    private void processDebit(){
        ProcessDebit_Request processDebit = new ProcessDebit_Request();
        processDebit.setUsername("Jesus123");
        processDebit.setPassword("1234");
        processDebit.setAccountID("001");
        processDebit.setCustomerName("jesus");
        processDebit.setCustomerEmail("test@test.com");
        processDebit.setAddress1("addres1");
        processDebit.setAddress2("addres2");
        processDebit.setCity("SJ");
        processDebit.setState("PR");
        processDebit.setZipcode("00960");
        processDebit.setTrxDescription("Pago");
        processDebit.setTrxAmount("0.1");
        processDebit.setTrxOper("sale");
        processDebit.setTrxID("123");
        processDebit.setRefNumber("123456");
        processDebit.setTrxTermID(" ");
        processDebit.setCardNumber("");
        processDebit.setExpDate("1249");
        processDebit.setExpDate("2846FASDAS44324ASD");

        String [] filler = {"filler$i", "filler$i"};
       processDebit.setFiller(filler);

        new ProcessResponse(processDebit,  new DebitListenerResponse() {
            @Override
            public void downloadCompleted(String result, ResponseDebit response) {
                Log.d("Result: ", result);
                Log.d("Response: ", response.toString());
            }
        }).execute();

    }

    private void WalletTransaction(){
        //create the object
        ProcessWalletTransaction_Request walletT= new ProcessWalletTransaction_Request();
        //fill the object
        walletT.setUsername("Jesus123");
        walletT.setPassword("1234");
        walletT.setAccountNumber("123456");
        walletT.setTrxOper("sale");
        walletT.setTrxID("123456");
        walletT.setTrxAmout("0.01");
        walletT.setRefNumber("");
        walletT.setFiller1("TESTING");
        walletT.setTrxDescription("Jesus");

        //execute the Process with the object Filled.
        new ProcessResponse(walletT,  new WalletListenerResponse() {
            @Override
            public void downloadCompleted(String result, ResponseWalletTransaction response) {
                Log.d("Result: ", result);
                Log.d("Response: ", response.toString());

            }

        }).execute();

    }

}