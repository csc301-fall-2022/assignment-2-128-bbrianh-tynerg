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

import java.util.ArrayList;

public class MenuFragment extends Fragment implements MenuRecyclerViewAdapter.ItemClickListener{

    private FragmentMenuBinding binding;
    private RecyclerView recyclerView;
    MenuRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MenuViewModel menuViewModel =
                new ViewModelProvider(this).get(MenuViewModel.class);

        View menuFragmentLayout = inflater.inflate(R.layout.fragment_menu, container, false);
//        binding = FragmentDashboardBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;

        // Add the following lines to create RecyclerView
        ArrayList<String> menuData = new ArrayList<>();
        menuData.add("Horse");
        menuData.add("Cow");
        menuData.add("Camel");
        menuData.add("Sheep");
        menuData.add("Goat");
        menuData.add("Pig");
        menuData.add("Bird");
        menuData.add("Chicken");
        menuData.add("Duck");
        recyclerView = menuFragmentLayout.findViewById(R.id.recyclerView_menu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(menuFragmentLayout.getContext()));

        adapter = new MenuRecyclerViewAdapter(getContext(), menuData);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return menuFragmentLayout;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "Item " + adapter.getItem(position) + " added to cart! ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}