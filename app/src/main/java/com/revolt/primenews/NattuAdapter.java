package com.revolt.primenews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NattuAdapter extends RecyclerView.Adapter<NattuAdapter.RecyclerViewHolder>{

    private Context mContext;
    private List<Nattu> teachers;
    private NattuAdapter.OnItemClickListener mListener;

    public NattuAdapter(Context context, List<Nattu> uploads) {
        mContext = context;
        teachers = uploads;
    }


    @Override
    public NattuAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_modelnaatu, parent, false);
        return new NattuAdapter.RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final NattuAdapter.RecyclerViewHolder holder, final int position) {
        final Nattu currentTeacher = teachers.get(position);
        holder.nameTextView.setText(currentTeacher.getSadhanam());
        holder.price.setText(currentTeacher.getPrice());

        Picasso.get()
                .load(currentTeacher.getImageurl())
                .fit()
                .centerCrop()
                .into(holder.teacherImageView);
    }
    @Override
    public int getItemCount() {
        return teachers.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView nameTextView,price;
        public ImageView teacherImageView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nameTextView =itemView.findViewById ( R.id.itemname1);
            price=itemView.findViewById(R.id.itemprice1);
            teacherImageView = itemView.findViewById(R.id.picnaatu);
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
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
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem showItem = menu.add( Menu.NONE, 1, 1, "Show");
            showItem.setOnMenuItemClickListener(this);
        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    switch (item.getItemId()) {
                        case 1:
                            mListener.onShowItemClick(position);
                            return true;

                    }
                }
            }
            return false;
        }

    }


    public interface OnItemClickListener {
        void onItemClick(int position);
        void onShowItemClick(int position);
    }
    public void setOnItemClickListener(NattuAdapter.OnItemClickListener listener) {
        mListener = listener;
    }
}
