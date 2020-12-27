package com.revolt.primenews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class PoliceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PoliceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        recyclerView =(RecyclerView)findViewById(R.id.recviewpolice);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<police> options =
                new FirebaseRecyclerOptions.Builder<police>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("pol_upload"),police.class)
                        .build();

        adapter= new PoliceAdapter(options);
        recyclerView.setAdapter(adapter);


    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}