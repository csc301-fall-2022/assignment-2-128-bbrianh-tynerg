package com.example.checkcoutcalculator.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.checkcoutcalculator.R;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    private List<String> cData;
    private LayoutInflater cInflater;
    private ItemClickListener cClickListener;

    // data is passed into the constructor
    CartRecyclerViewAdapter(Context context, List<String> data) {
        this.cInflater = LayoutInflater.from(context);
        this.cData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = cInflater.inflate(R.layout.cart_row, parent, false);
        return new ViewHolder(view);
    }


    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = cData.get(position);
        holder.cartTextView.setText(item);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return cData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView cartTextView;
        TextView cartPriceTextView;
        Button cartButtonRemove;
//        private WeakReference<ItemClickListener> listenerRef;

        ViewHolder(View itemView) {
            super(itemView);

            cartTextView = itemView.findViewById(R.id.textview_menu_row_name);
            cartPriceTextView = itemView.findViewById(R.id.textview_cart_row_price);
            cartButtonRemove = itemView.findViewById(R.id.button_cart_row);

//            itemView.setOnClickListener(this);
            cartButtonRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (cClickListener != null) cClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return cData.get(id);
    }

    // convenience method for getting data at click position
    void removeItem(int id) {
        cData.remove(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.cClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}