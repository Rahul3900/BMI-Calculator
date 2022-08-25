package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   android.widget.Button cal;

   TextView currentheight;
   TextView currentage,currentweight;
   ImageView intage,intweight,decage,decweight;
   SeekBar seekforheight;
   RelativeLayout male,female;

   int w = 55;
   int age = 20;
   int cprogress;
   String progress="170";
   String typeofuser="0";
   String weight="55";
   String age2="20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        cal = findViewById(R.id.calculateBMI);
        currentage = findViewById(R.id.currentage);
        currentheight = findViewById(R.id.currentheight);
        currentweight = findViewById(R.id.currentweight);
        intage = findViewById(R.id.incrementage);
        intweight = findViewById(R.id.incremetweight);
        decage = findViewById(R.id.decrementage);
        decweight = findViewById(R.id.decrementweight);
        seekforheight = findViewById(R.id.seekbarheight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);



        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.focused));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.notfocused));
                typeofuser="Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.focused));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.notfocused));
                typeofuser="Female";
            }
        });

        seekforheight.setMax(250);
        seekforheight.setProgress(170);
        seekforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cprogress = i;
                progress = String.valueOf(cprogress);
                currentheight.setText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        intage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age=age+1;
                age2 = String.valueOf(age);
                currentage.setText(age2);
            }
        });
        decage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(age!=1){
                age=age-1;
                age2 = String.valueOf(age);
                currentage.setText(age2);}
                else
                {
                    Toast.makeText(getApplicationContext(),"Age cannot be zero",Toast.LENGTH_SHORT).show();
                }
            }
        });

        decweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(w!=1) {
                    w = w - 1;
                    weight = String.valueOf(w);
                    currentweight.setText(weight);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Weight cannot be zero",Toast.LENGTH_SHORT).show();
                }
            }
        });
        intweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w=w+1;
                weight = String.valueOf(w);
                currentweight.setText(weight);
            }
        });



        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(typeofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select your Gender",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,bmical.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",progress);
                    intent.putExtra("weight",weight);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}