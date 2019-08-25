package com.asianapp.mohankumardhakal.athithi.foodprediction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.asianapp.mohankumardhakal.athithi.R;
import com.asianapp.mohankumardhakal.athithi.random.MainMenu;

public class FoodDetailActivity extends AppCompatActivity {
    TextView food_name, food_type, cultural_importance, ingredients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        food_name = findViewById(R.id.food_name);
        ingredients = findViewById(R.id.food_ingredients);
        food_type = findViewById(R.id.food_type);
        cultural_importance = findViewById(R.id.cultural_importance);
        food_name.setText(getIntent().getStringExtra("cuisine_name"));
        cultural_importance.setText(getIntent().getStringExtra("description"));
        food_type.setText(getIntent().getStringExtra("food_type"));
        ingredients.setText(getIntent().getStringExtra("ingredients"));
        setDialog(getIntent().getStringExtra("food_type"));
    }

    private void setDialog(String foodType) {
        final Dialog dialog=new Dialog(FoodDetailActivity.this,R.style.Dialog);
        dialog.setTitle("Alert!!");

        View view= LayoutInflater.from(FoodDetailActivity.this).inflate(R.layout.dialog_to_choose, null);
        TextView alertMessage=view.findViewById(R.id.alert);

        alertMessage.setText(foodType);
        dialog.setContentView(view);
        dialog.show();
        dialog.setCancelable(false);
        Button okay= view.findViewById(R.id.capture);

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FoodDetailActivity.this, MainMenu.class));
        finish();
    }
}
