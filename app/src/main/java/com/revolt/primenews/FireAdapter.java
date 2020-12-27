package com.revolt.primenews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FireAdapter extends RecyclerView.Adapter<FireAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<fire> teachers;
    public FireAdapter(Context context, List<fire> uploads) {
        mContext = context;
        teachers = uploads;
    }


    @Override
    public FireAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_model4, parent, false);
        return new FireAdapter.RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final FireAdapter.RecyclerViewHolder holder, int position) {
        final fire currentTeacher = teachers.get(position);
        holder.nameTextView.setText(currentTeacher.getName());
        holder.placee.setText(currentTeacher.getPlace());
        holder.time.setText(currentTeacher.getPhn());

    }
    @Override
    public int getItemCount() {
        return teachers.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView,placee,time;
        public ImageButton call;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nameTextView =itemView.findViewById ( R.id.titleann);
            placee=itemView.findViewById(R.id.descann);
            time=itemView.findViewById(R.id.phoneann);
            call=itemView.findViewById(R.id.call);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String pdescription = teachers.get(getAdapterPosition()).getPhn();
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+pdescription));
                    mContext.startActivity(i);
                }
            });


        }



    }
}
