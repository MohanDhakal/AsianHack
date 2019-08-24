package com.asianapp.mohankumardhakal.athithi.cashprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.asianapp.mohankumardhakal.athithi.R;
import com.asianapp.mohankumardhakal.athithi.random.MainActivity;
import com.asianapp.mohankumardhakal.athithi.random.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class Preference extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String nationalityList[]={"United Stated","Austrailia","Indonesia","India"};
    String currencyList[]={"US Dollar","Aus Dollar","Indian Rupee","Yuan"};
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference);
        save =findViewById(R.id.saveButton);
        Spinner spinner1,spinner2;
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.spinner_item,currencyList);
        ArrayAdapter arrayAdapter2=new ArrayAdapter(this,R.layout.spinner_item,nationalityList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Preference.this, MainMenu.class));

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(), nationalityList[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
