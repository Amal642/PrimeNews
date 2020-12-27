package com.revolt.primenews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.RecyclerViewHolder>{

    private Context mContext;
    private List<Taxi> teachers;
    private WorkerAdapter.OnItemClickListener mListener;

    public WorkerAdapter(Context context, List<Taxi> uploads) {
        mContext = context;
        teachers = uploads;
    }


    @Override
    public WorkerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_modellink, parent, false);
        return new WorkerAdapter.RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final WorkerAdapter.RecyclerViewHolder holder, int position) {
        final Taxi currentTeacher = teachers.get(position);
        holder.nameTextView.setText(currentTeacher.getName());

    }
    @Override
    public int getItemCount() {
        return teachers.size();
    }



    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nameTextView;
        public ImageButton show;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nameTextView =itemView.findViewById ( R.id.titleann);
            show=itemView.findViewById(R.id.showlink);
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);

                        }
                    }
                }
            });
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);

                }
            }

        }


    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(WorkerAdapter.OnItemClickListener listener) {
        mListener = listener;
    }
}
