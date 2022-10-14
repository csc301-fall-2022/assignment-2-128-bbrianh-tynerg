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
import com.example.checkcoutcalculator.viewmodel.CartItemDisplayInfo;
import com.example.checkcoutcalculator.viewmodel.CartViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class CartFragment extends Fragment implements CartRecyclerViewAdapter.ItemClickListener{

    private FragmentCartBinding binding;
    private RecyclerView recyclerView;
    private CartViewModel cartViewModel;
    CartRecyclerViewAdapter adapter;
    View cartFragmentLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        cartFragmentLayout = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = cartFragmentLayout.findViewById(R.id.recyclerView_cart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(cartFragmentLayout.getContext()));

        adapter = new CartRecyclerViewAdapter(getContext(), null);
        cartViewModel.getCartItems().observe(getViewLifecycleOwner(),
                cartItems -> adapter.setcData(cartItems));
        adapter.setCartClickListener(this);
        recyclerView.setAdapter(adapter);
        updateCheckOutBar(cartFragmentLayout);

        // onc
        cartFragmentLayout.findViewById(R.id.button_cart_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText textInputView = cartFragmentLayout
                        .findViewById(R.id.textInputEditText_cart_card);

                String discount_str = textInputView.getText().toString();
                double discount;
                if (discount_str.equals("")){
                    discount = 0.0;
                } else {
                    discount = Double.parseDouble(discount_str);
                }

                if (discount > 100){
                    Toast.makeText(getActivity(),
                            "Greed is a sin",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    cartViewModel.setDiscount(discount);
                    updateCheckOutBar(cartFragmentLayout);
                    Toast.makeText(getActivity(),
                            "Discount applied",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


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
        updateCheckOutBar(cartFragmentLayout);

    }

    @Override
    public void onMinusClick(View view, CartItemDisplayInfo item) {
        if (item.quantity - 1 > 0) {
            cartViewModel.decreaseItemQuantity(item.productId);
        }
        updateCheckOutBar(cartFragmentLayout);
    }

    @Override
    public void onRemoveClick(View view, CartItemDisplayInfo item) {
        cartViewModel.removeItemFromCart(item.productId);
        updateCheckOutBar(cartFragmentLayout);

    }

    public void updateCheckOutBar(View view) {
        TextView subTotal = view.findViewById(R.id.textView_cart_card_subtotal);
        TextView taxPortion = view.findViewById(R.id.textView_cart_card_tax);
        TextView total = view.findViewById(R.id.textView_cart_card_total);
        subTotal.setText(String.format("Subtotal: $%.2f", cartViewModel.getBeforeTaxTotal()));
        taxPortion.setText(String.format("Tax (13%%): $%.2f", cartViewModel.getTaxPortion()));
        total.setText(String.format("Total: $%.2f", cartViewModel.getFinalPrice()));
    }
}