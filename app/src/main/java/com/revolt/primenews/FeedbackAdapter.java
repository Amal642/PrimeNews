package com.revolt.primenews;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackAdapter extends FirebaseRecyclerAdapter<Feedback,FeedbackAdapter.myviewholder> {
    public FeedbackAdapter(@NonNull FirebaseRecyclerOptions<Feedback> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final FeedbackAdapter.myviewholder myviewholder, final int position, @NonNull Feedback announcements) {
        myviewholder.name.setText(announcements.getName());
        myviewholder.place.setText(announcements.getText());

    }

    @NonNull
    @Override
    public FeedbackAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_model2,parent,false);
        return new FeedbackAdapter.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView name,place;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.titleann);
            place=itemView.findViewById(R.id.descann);

        }
    }
}
