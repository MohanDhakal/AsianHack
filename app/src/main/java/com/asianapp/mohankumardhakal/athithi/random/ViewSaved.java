package com.asianapp.mohankumardhakal.athithi.random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.asianapp.mohankumardhakal.athithi.R;

import java.util.ArrayList;

public class ViewSaved extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saved);
        recyclerView=findViewById(R.id.recyclerSavedView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter=new ViewAdapter(this,MainActivity.savedItem);
        recyclerView.setAdapter(mAdapter);
        Context context=this;
    }
}
