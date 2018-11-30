package com.thegrafico.raul.evertec_library_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ListView;
import android.widget.Toast;

import com.thegrafico.raul.evertec_library_02.adapter.homeAdapter;
import com.thegrafico.raul.evertec_library_02.adapter.homeItems;
import com.thegrafico.raul.evertectest.Modals.Response.ResponseTransactionSearch;

import java.util.ArrayList;
import java.util.List;

/*Secondary Activity*/

//Main activity Similar to MainActivity.kt but this one is for kt
public class ItemActivity extends AppCompatActivity {

    List<homeItems> itemsList;
    ListView listView;
    ResponseTransactionSearch resp;

    String price1 = "Price: $7.99";
    String price2 = "Price: $9.99";
    String price3 = "Price: $10.00";

    String des1 = "Arroz con Gandules y Pernil. Refresco e IVU incluido";
    String des2 = "Monfogo con Camarones frecos, Salsa roja. Refresco e IVU incluido";
    String des3 = "Flan de queso.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

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
        itemsList.add(new homeItems(R.drawable.pernil, price1, des1, "x" +  accNumber));
        itemsList.add(new homeItems(R.drawable.mofongo_camarones, price2, des2, "x" + accNumber));
        itemsList.add(new homeItems(R.drawable.flan, price3, des3, "x" + accNumber));

        //init the list view
        listView = findViewById(R.id.listview);

        //init the adapter
        homeAdapter adapter = new homeAdapter(this, R.layout.homepage, itemsList);

        //put all together
        listView.setAdapter(adapter);
    }

}
