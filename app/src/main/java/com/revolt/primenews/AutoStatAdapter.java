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

public class AutoStatAdapter extends RecyclerView.Adapter<AutoStatAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<Autostations> teachers;
    private AutoStatAdapter.OnItemClickListener mListener;

    public AutoStatAdapter(Context context, List<Autostations> uploads) {
        mContext = context;
        teachers = uploads;
    }


    @Override
    public AutoStatAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_modellink, parent, false);
        return new AutoStatAdapter.RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final AutoStatAdapter.RecyclerViewHolder holder, int position) {
        final Autostations currentTeacher = teachers.get(position);
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
            itemView.setOnClickListener(this);
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
    public void setOnItemClickListener(AutoStatAdapter.OnItemClickListener listener) {
        mListener = listener;
    }
}

