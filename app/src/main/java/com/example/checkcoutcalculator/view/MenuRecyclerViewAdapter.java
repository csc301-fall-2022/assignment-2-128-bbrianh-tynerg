package com.example.checkcoutcalculator.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.checkcoutcalculator.R;
import com.example.checkcoutcalculator.viewmodel.MenuItemDisplayInfo;

import java.util.List;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ViewHolder> {

    private List<MenuItemDisplayInfo> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MenuRecyclerViewAdapter(Context context, List<MenuItemDisplayInfo> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.menu_row, parent, false);
        return new ViewHolder(view);
    }


    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItemDisplayInfo item = mData.get(position);
        holder.menuTextView.setText(item.productName);
        holder.menuPriceTextView.setText(String.format("$%.2f", item.price));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView menuTextView;
        TextView menuPriceTextView;
        Button menuButton;

        ViewHolder(View itemView) {
            super(itemView);

            menuTextView = itemView.findViewById(R.id.textview_menu_row_name);
            menuPriceTextView = itemView.findViewById(R.id.textview_menu_row_price);
            menuButton = itemView.findViewById(R.id.button_menu_row);

            menuButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    MenuItemDisplayInfo getItem(int id) {
        return mData.get(id);
    }

    // convenience method for getting data at click position
    void removeItem(int id) {
        mData.remove(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setmData(List<MenuItemDisplayInfo> mData) {
        notifyDataSetChanged();
        this.mData = mData;
    }

}