package com.example.checkcoutcalculator.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkcoutcalculator.R;
import com.example.checkcoutcalculator.databinding.FragmentCartBinding;
import com.example.checkcoutcalculator.databinding.FragmentMenuBinding;
import com.example.checkcoutcalculator.viewmodel.CartItemDisplayInfo;
import com.example.checkcoutcalculator.viewmodel.CartViewModel;
import com.example.checkcoutcalculator.viewmodel.MenuViewModel;

import java.util.ArrayList;

public class CartFragment extends Fragment implements CartRecyclerViewAdapter.ItemClickListener{

    private FragmentCartBinding binding;
    private RecyclerView recyclerView;
    private CartViewModel cartViewModel;
    CartRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        View cartFragmentLayout = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = cartFragmentLayout.findViewById(R.id.recyclerView_cart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(cartFragmentLayout.getContext()));

        adapter = new CartRecyclerViewAdapter(getContext(), null);
        cartViewModel.getCartItems().observe(getViewLifecycleOwner(),
                cartItems -> adapter.setcData(cartItems));
        adapter.setCartClickListener(this);
        recyclerView.setAdapter(adapter);


        binding = FragmentCartBinding.inflate(inflater, container, false);
        updateCheckOutBar();
        return cartFragmentLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAddClick(View view, CartItemDisplayInfo item) {
        cartViewModel.increaseItemQuantity(item.productId);
        updateCheckOutBar();

    }

    @Override
    public void onMinusClick(View view, CartItemDisplayInfo item) {
        if (item.quantity - 1 > 0) {
            cartViewModel.decreaseItemQuantity(item.productId);
        }
        updateCheckOutBar();
    }

    @Override
    public void onRemoveClick(View view, CartItemDisplayInfo item) {
        cartViewModel.removeItemFromCart(item.productId);
        updateCheckOutBar();

    }

    public void updateCheckOutBar() {
        TextView subTotal = binding.getRoot().findViewById(R.id.textView_cart_card_subtotal);
        TextView taxPortion = binding.getRoot().findViewById(R.id.textView_cart_card_tax);
        TextView total = binding.getRoot().findViewById(R.id.textView_cart_card_total);
        subTotal.setText(String.format("$%.2f", cartViewModel.getBeforeTaxTotal()));
        taxPortion.setText(String.format("$%.2f", cartViewModel.getTaxPortion()));
        total.setText(String.format("$%.2f", cartViewModel.getFinalPrice()));
    }
}