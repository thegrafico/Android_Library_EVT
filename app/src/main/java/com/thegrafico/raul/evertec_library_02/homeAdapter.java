package com.thegrafico.raul.evertec_library_02;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class homeAdapter extends ArrayAdapter<homeItems> {

    Context context;
    int resourse;
    List<homeItems> itemsHome;

    static String PRICE = "price";
    static String DESCP = "descri";
    static String RESOURSER = "resourse";

    Intent intent;
    public homeAdapter(Context context, int resource, List<homeItems> itemsHome){
        super(context, resource, itemsHome);

        this.context = context;
        this.resourse = resource;
        this.itemsHome = itemsHome;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(resourse, null);

        TextView textViewname = view.findViewById(R.id.textviewName);

        TextView textViewDescrip = view.findViewById(R.id.textViewDescription);

        ImageView imgView = view.findViewById(R.id.imageView);

        //getting the item
        homeItems items = itemsHome.get(position);

        textViewname.setText(items.getName());
        textViewDescrip.setText(items.getDescription());
        imgView.setImageDrawable(context.getResources().getDrawable(items.getImage()));

        view.findViewById(R.id.btndelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyItem(position);
            }
        });

        return view;
    }

    private void buyItem(int i){
        intent = new Intent(context, PayActivity.class);
        intent.putExtra(PRICE, itemsHome.get(i).name);
        intent.putExtra(DESCP, itemsHome.get(i).getDescription());
        intent.putExtra(RESOURSER, itemsHome.get(i).getImage());

        Toast.makeText(context, "Press: " + itemsHome.get(i).name, Toast.LENGTH_LONG).show();
        context.startActivity(intent);

    }
}
