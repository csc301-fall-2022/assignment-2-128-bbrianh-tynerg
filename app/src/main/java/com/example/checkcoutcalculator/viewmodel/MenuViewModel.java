package com.example.checkcoutcalculator.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.checkcoutcalculator.db.MenuItem;
import com.example.checkcoutcalculator.db.MenuRepository;

import java.io.Closeable;
import java.util.List;

public class MenuViewModel extends ViewModel {

    private final MenuRepository menuRepository;
    private final MutableLiveData<List<MenuItem>> mMenu;

    public MenuViewModel(Application application) {
        super(application);
        menuRepository = new MenuRepository(application);
        mMenu = new MutableLiveData<>();
        mMenu.setValue(menuRepository.getAllItems());
    }

    public LiveData<List<MenuItem>> getMenu() {
        return mMenu;
    }
}