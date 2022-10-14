package com.example.checkcoutcalculator.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkcoutcalculator.R;
import com.example.checkcoutcalculator.databinding.FragmentMenuBinding;
import com.example.checkcoutcalculator.viewmodel.CartItemDisplayInfo;
import com.example.checkcoutcalculator.viewmodel.CartViewModel;
import com.example.checkcoutcalculator.viewmodel.MenuViewModel;

import java.util.ArrayList;

public class CartFragment extends Fragment implements CartRecyclerViewAdapter.ItemClickListener{

    private FragmentMenuBinding binding;
    private RecyclerView recyclerView;
    private CartViewModel cartViewModel;
    CartRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        View cartFragmentLayout = inflater.inflate(R.layout.fragment_cart, container, false);
//        binding = FragmentDashboardBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;

        recyclerView = cartFragmentLayout.findViewById(R.id.recyclerView_cart);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(cartFragmentLayout.getContext()));

        adapter = new CartRecyclerViewAdapter(getContext(), null);
        cartViewModel.getCartItems().observe(getViewLifecycleOwner(),
                cartItems -> adapter.setcData(cartItems));
        adapter.setCartClickListener(this);
        recyclerView.setAdapter(adapter);

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
    }

    @Override
    public void onMinusClick(View view, CartItemDisplayInfo item) {
        cartViewModel.decreaseItemQuantity(item.productId);
    }

    @Override
    public void onRemoveClick(View view, CartItemDisplayInfo item) {
        cartViewModel.removeItemFromCart(item.productId);
    }
}