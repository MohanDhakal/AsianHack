package com.asianapp.mohankumardhakal.athithi.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asianapp.mohankumardhakal.athithi.R;
import com.asianapp.mohankumardhakal.athithi.cashprediction.CashFlow;
import com.asianapp.mohankumardhakal.athithi.foodprediction.PythonFlask;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button currencyConverter,foodDetector,hotelFinder;
        currencyConverter=findViewById(R.id.currencyDetection);
        currencyConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainMenu.this, CashFlow.class);
                startActivity(intent);
            }
        });
        foodDetector=findViewById(R.id.foodDetection);
        foodDetector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(MainMenu.this, PythonFlask.class);
            startActivity(intent);
            }
        });
        hotelFinder=findViewById(R.id.hotelFinder);
        hotelFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(MainMenu.this,MainActivity.class);
            startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
