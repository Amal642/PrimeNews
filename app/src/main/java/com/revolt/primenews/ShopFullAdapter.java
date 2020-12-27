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

public class ShopFullAdapter extends RecyclerView.Adapter<ShopFullAdapter.RecyclerViewHolder>{


    private Context mContext;
    private List<Taxifull> teachers;
    String entity;
    public ShopFullAdapter(Context context, List<Taxifull> uploads, String name) {
        mContext = context;
        teachers = uploads;
        entity=name;
    }


    @Override
    public ShopFullAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_model4, parent, false);
        return new ShopFullAdapter.RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ShopFullAdapter.RecyclerViewHolder holder, int position) {
        final Taxifull currentTeacher = teachers.get(position);
        holder.nameTextView.setText(currentTeacher.getBusname());
        holder.place.setText(currentTeacher.getBservice());
        holder.phone.setText(currentTeacher.getBtime());


    }
    @Override
    public int getItemCount() {
        return teachers.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView,place,phone;
        public ImageButton call;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nameTextView =itemView.findViewById(R.id.titleann);
            place=itemView.findViewById(R.id.descann);
            phone=itemView.findViewById(R.id.phoneann);
            call=itemView.findViewById(R.id.call);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String pdescription = teachers.get(getAdapterPosition()).getBtime();
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+pdescription));
                    mContext.startActivity(i);
                }
            });

        }



    }
}
