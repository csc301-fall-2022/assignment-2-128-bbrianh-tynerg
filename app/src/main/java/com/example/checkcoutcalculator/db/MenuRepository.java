package com.example.checkcoutcalculator.db;

import android.app.Application;

import java.util.List;

public class MenuRepository {
    private final ItemDao itemDao;

    public MenuRepository (Application application) {
        ItemDatabase db = ItemDatabase.getDbInstance(application);
        itemDao = db.itemDao();
    }

    public List<MenuItem> getAllItems() {
        return itemDao.getAllItemOnMenu();
    }

    public void addItem(String itemName, double price, boolean taxable) {
        MenuItem item = new MenuItem(itemName, price, taxable);
        itemDao.insertMenuItem(item);
    }

    public MenuItem searchItem(int uid) {
        return itemDao.getMenuItem(uid);
    }

}
