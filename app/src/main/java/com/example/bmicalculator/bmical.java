package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmical extends AppCompatActivity {

    android.widget.Button back;
    TextView bmidis,bmicat,gen;
    Intent intent;
    ImageView imview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout background;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmical);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();


        back = findViewById(R.id.back);
        bmidis = findViewById(R.id.bmidisplay);
        bmicat = findViewById(R.id.bmicategory);
        gen = findViewById(R.id.gengerdisplay);
        imview = findViewById(R.id.imageview);
        background = findViewById(R.id.contentLayout);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight/100;
        intbmi = intweight/(intheight*intheight);
        mbmi = String.valueOf(String.format("%.2f",intbmi));
        bmidis.setText(mbmi);
        if(intbmi<18.5) {
            bmicat.setText("Underweight");
            background.setBackgroundColor(Color.RED);
            imview.setImageResource(R.drawable.warning);
        }
        else if(intbmi>=18.5 && intbmi<25) {
            bmicat.setText("Healthy");
            imview.setImageResource(R.drawable.ok);
        }
        else if(intbmi>=25 && intbmi<30) {
            bmicat.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            imview.setImageResource(R.drawable.warning);
        }
        else if(intbmi>30) {
            bmicat.setText("Obesity");
            background.setBackgroundColor(Color.RED);
            imview.setImageResource(R.drawable.crosss);
        }

        gen.setText(intent.getStringExtra("gender"));







        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bmical.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}