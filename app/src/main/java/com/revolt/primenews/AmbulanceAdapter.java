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

public class AmbulanceAdapter extends FirebaseRecyclerAdapter<Emergency,AmbulanceAdapter.myviewholder> {
    public AmbulanceAdapter(@NonNull FirebaseRecyclerOptions<Emergency> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final AmbulanceAdapter.myviewholder myviewholder, final int position, @NonNull Emergency announcements) {
        myviewholder.name.setText(announcements.getName());
        myviewholder.place.setText(announcements.getPlace());
        myviewholder.num.setText(announcements.getPhn());
        myviewholder.deleteAnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(myviewholder.name.getContext());
                builder.setTitle("Delete");
                builder.setMessage("Sure to proceed?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Ambulance_upload")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public AmbulanceAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_model4,parent,false);
        return new AmbulanceAdapter.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView name,place,num;
        ImageButton deleteAnn;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.titleann);
            place=itemView.findViewById(R.id.descann);
            num=itemView.findViewById(R.id.phoneann);
            deleteAnn=itemView.findViewById(R.id.delete);

        }
}
}