package com.revolt.primenews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewLinksActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinkAdapter adapter;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_links);

        recyclerView =(RecyclerView)findViewById(R.id.recviewlink);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Link> options =
                new FirebaseRecyclerOptions.Builder<Link>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Link_upload"),Link.class)
                        .build();

        adapter= new LinkAdapter(options,this);
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