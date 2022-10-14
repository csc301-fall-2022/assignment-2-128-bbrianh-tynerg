package com.example.checkoutcalculator.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.checkoutcalculator.db.CartRepository;
import com.example.checkoutcalculator.db.MenuItem;
import com.example.checkoutcalculator.db.MenuRepository;

import java.util.ArrayList;
import java.util.List;

public class MenuViewModel extends AndroidViewModel {

    private final MenuRepository menuRepository;
    private final CartRepository cartRepository;
    private final MutableLiveData<List<MenuItemDisplayInfo>> mMenu;

    public MenuViewModel(Application application) {
        super(application);
        menuRepository = new MenuRepository(application);
        cartRepository = new CartRepository(application);
        mMenu = new MutableLiveData<>();
        // get menu data from database
        fetchMenuData();
    }

    public void fetchMenuData() {
        List<MenuItemDisplayInfo> displayInfos = new ArrayList<>();
        for (MenuItem menuItem : menuRepository.getAllItems()) {
            displayInfos.add(new MenuItemDisplayInfo(
                    menuItem.uid, menuItem.itemName, menuItem.price));
        }
        mMenu.setValue(displayInfos);
    }

    public LiveData<List<MenuItemDisplayInfo>> getMenu() {
        return mMenu;
    }

    public void addItemToCart(int productId) {
        cartRepository.addItem(productId);
    }
}