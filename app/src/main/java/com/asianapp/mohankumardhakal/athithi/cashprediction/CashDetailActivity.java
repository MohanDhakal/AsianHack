package com.asianapp.mohankumardhakal.athithi.cashprediction;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.asianapp.mohankumardhakal.athithi.R;

public class CashDetailActivity extends AppCompatActivity {

    TextView nepaliValue, convertedValue, what1, what2, what3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_detail);

        //find values
        nepaliValue = findViewById(R.id.my_nepali_value);
        convertedValue = findViewById(R.id.my_converted_value);
        what1 = findViewById(R.id.what1);
        what2 = findViewById(R.id.what2);
        what3 = findViewById(R.id.what3);

        //setting values
        nepaliValue.setText(getIntent().getStringExtra("NepaliValue").trim());
        convertedValue.setText(getIntent().getStringExtra("ConvertedValue").trim());
        what1.setText(getIntent().getStringExtra("what1").trim());
        what2.setText(getIntent().getStringExtra("what2").trim());
        what3.setText(getIntent().getStringExtra("what3").trim());
    }
}
