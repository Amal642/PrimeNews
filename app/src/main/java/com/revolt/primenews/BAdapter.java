package com.revolt.primenews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class BAdapter extends RecyclerView.Adapter<BAdapter.RecyclerViewHolder>{

    private Context mContext;
    private List<BusStatDetails> teachers;
    String entity;
    public BAdapter(Context context, List<BusStatDetails> uploads, String name) {
        mContext = context;
        teachers = uploads;
        entity=name;
    }



    @Override
    public BAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_model3, parent, false);
        return new BAdapter.RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final BAdapter.RecyclerViewHolder holder, int position) {
        final BusStatDetails currentTeacher = teachers.get(position);
        holder.nameTextView.setText(currentTeacher.getBusname());
        holder.service.setText(currentTeacher.getBservice());
        holder.busclass.setText(currentTeacher.getBclass());
        holder.route.setText(currentTeacher.getBroute());
        holder.time.setText(currentTeacher.getBtime());


    }
    @Override
    public int getItemCount() {
        return teachers.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView,service,time,route,busclass;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nameTextView =itemView.findViewById ( R.id.busname);
            service=itemView.findViewById(R.id.busservice);
            time=itemView.findViewById(R.id.bustime);
            route=itemView.findViewById(R.id.busroute);
            busclass=itemView.findViewById(R.id.busclass);

        }



    }

}
