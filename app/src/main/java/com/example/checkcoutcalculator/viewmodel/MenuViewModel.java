package com.example.checkcoutcalculator.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.checkcoutcalculator.db.MenuItem;
import com.example.checkcoutcalculator.db.MenuRepository;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends AndroidViewModel {

    private final MenuRepository menuRepository;
    private final MutableLiveData<List<MenuItem>> mMenu;

    public MenuViewModel(Application application) {
        super(application);
        menuRepository = new MenuRepository(application);
        mMenu = new MutableLiveData<>();
        mMenu.setValue(menuRepository.getAllItems());
    }

    public LiveData<List<String>> getMenu() {
        List<String> ret = new ArrayList<>();
        if (mMenu != null) {
            for (MenuItem menuItem : mMenu.getValue()) {
                ret.add(menuItem.itemName);
            }
        }

        MutableLiveData<List<String>> wrap = new MutableLiveData<> ();
        wrap.setValue(ret);
        return wrap;
    }
}