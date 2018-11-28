package com.thegrafico.raul.evertec_library_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//Main activity Similar to MainActivity.kt but this one is for kt
public class Main2Activity extends AppCompatActivity {

    List<homeItems> itemsList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent infoAcc = getIntent();

//        String acc = infoAcc.getStringExtra(homeAdapter.ACCNUMBER);

        itemsList = new ArrayList<>();

        itemsList.add(new homeItems(R.drawable.reloj, "Price: $300.00", "luxury watch for any occasion", "x6789"));
        itemsList.add(new homeItems(R.drawable.laptop, "Price: $799.99", "2019 Newest Flagship HP. 1TB Memory, 16GB Ram", "x6789"));

        listView = findViewById(R.id.listview);

        homeAdapter adapter = new homeAdapter(this, R.layout.homepage, itemsList);

        listView.setAdapter(adapter);
    }

}
