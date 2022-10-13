package com.example.checkcoutcalculator.db;

import android.app.Application;

import java.util.List;

public class MenuRepository {
    private final ItemDao itemDao;

    public MenuRepository (Application application) {
        ItemDatabase db = ItemDatabase.getDbInstance(application);
        itemDao = db.itemDao();
    }

    /**
     * Return a list of menuitem from database
     * @return a list of menuitem from database
     */
    public List<MenuItem> getAllItems() {
        return itemDao.getAllItemOnMenu();
    }

    /**
     * Return the corresponding product with the given uid
     * @param uid the product id
     * @return the menu item of the uid
     */
    public MenuItem searchItem(int uid) {
        return itemDao.getMenuItem(uid);
    }

}
