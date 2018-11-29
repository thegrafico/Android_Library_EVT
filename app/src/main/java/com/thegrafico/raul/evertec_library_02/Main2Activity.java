package com.thegrafico.raul.evertec_library_02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.widget.ListView;
import android.widget.Toast;

import com.thegrafico.raul.evertectest.Modals.Response.ResponseTransactionSearch;

import java.util.ArrayList;
import java.util.List;

//Main activity Similar to MainActivity.kt but this one is for kt
public class Main2Activity extends AppCompatActivity {

    List<homeItems> itemsList;
    ListView listView;
    ResponseTransactionSearch resp;

    String price1 = "Price: $300.00";
    String price2 = "Price: $799.99";
    String price3 = "Price: $250.00";

    String des1 = "luxury watch for any occasion. Gold & black";
    String des2 = "2019 Newest Flagship HP. 1TB Memory, 16GB Ram";
    String des3 = "2017 Flagship HP. 500TB Memory, 8GB Ram";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //get the intent info
        Intent infoAcc = getIntent();

        //here we get the object
        resp = (ResponseTransactionSearch) infoAcc.getSerializableExtra("transaction");
        String accNumber = infoAcc.getStringExtra("ACCNUMBER");

        if(accNumber == null){
         accNumber = infoAcc.getStringExtra("accNumber");
        }

        //if the object is not null, this is for testing
        if(resp != null)
            Toast.makeText(this, resp.getRequestID(), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "No se pudo obtener el objeto", Toast.LENGTH_SHORT).show();

        //fill up the intemsList
        itemsList = new ArrayList<>();
        itemsList.add(new homeItems(R.drawable.reloj, price1, des1, "x" +  accNumber));
        itemsList.add(new homeItems(R.drawable.laptop, price2, des2, "x" + accNumber));
        itemsList.add(new homeItems(R.drawable.laptop, price3, des3, "x" + accNumber));

        //init the list view
        listView = findViewById(R.id.listview);

        //init the adapter
        homeAdapter adapter = new homeAdapter(this, R.layout.homepage, itemsList);

        //put all together
        listView.setAdapter(adapter);
    }

}
