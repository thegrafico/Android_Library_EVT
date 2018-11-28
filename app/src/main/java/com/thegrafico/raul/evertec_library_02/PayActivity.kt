package com.thegrafico.raul.evertec_library_02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.*


class PayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)


        //resourse Data
        val intent = intent
        val price: String = intent.getStringExtra(homeAdapter.PRICE)
        val desc: String = intent.getStringExtra(homeAdapter.DESCP)

        var bundle: Bundle = getIntent().extras

        if(bundle != null){
            var resId: Int = bundle.getInt(homeAdapter.RESOURSER)
            //image
            val imgView = findViewById<ImageView>(R.id.imageViewpay)
            imgView.setImageResource(resId)
        }

        //textfiel price
        val texView = findViewById<TextView>(R.id.textviewNamePay)
        texView.text = price

        //text description
        val description = findViewById<TextView>(R.id.textViewDescriptionpay)
        description.text = desc

        val imgViewCheck = findViewById<ImageView>(R.id.imageViewchecked)
        val textComplete = findViewById<TextView>(R.id.textView4)
        val btn = findViewById<Button>(R.id.btnPay)

        btn.setOnClickListener {
            v ->
            btn.text = "Go Back"
            imgViewCheck.setImageResource(R.drawable.checkmar)
            textComplete.text = "Payment Completed"
            imgViewCheck.visibility = View.VISIBLE

        }
    }
}
