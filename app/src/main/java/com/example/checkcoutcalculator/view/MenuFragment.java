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
import com.example.checkcoutcalculator.viewmodel.MenuViewModel;

public class MenuFragment extends Fragment implements MenuRecyclerViewAdapter.ItemClickListener{

    private FragmentMenuBinding binding;
    private RecyclerView recyclerView;
    MenuRecyclerViewAdapter adapter;
    private MenuViewModel menuViewModel;
    private Toast onShowingToast;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuViewModel = new ViewModelProvider(this).get(MenuViewModel.class);

        View menuFragmentLayout = inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerView = menuFragmentLayout.findViewById(R.id.recyclerView_menu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(menuFragmentLayout.getContext()));

        adapter = new MenuRecyclerViewAdapter(getContext(), null);
        menuViewModel.getMenu().observe(getViewLifecycleOwner(),
                menuItems -> adapter.setmData(menuItems));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return menuFragmentLayout;
    }

    @Override
    public void onItemClick(View view, int position) {
        // Show Tost
        if (onShowingToast != null) {
            onShowingToast.cancel();
        }
        onShowingToast = Toast.makeText(getActivity(),
                "Item " + adapter.getItem(position).productName + " added to cart! ",
                Toast.LENGTH_SHORT);
        onShowingToast.show();

        // add Item to cart
        menuViewModel.addItemToCart(adapter.getItem(position).productId);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}