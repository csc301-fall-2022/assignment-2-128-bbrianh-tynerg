package com.example.checkcoutcalculator.db;

import android.content.Context;

import java.util.List;

public class CartRepository {

    private final ItemDao itemDao;

    public CartRepository (Context context) {
        ItemDatabase db = ItemDatabase.getDbInstance(context);
        itemDao = db.itemDao();
    }

    public List<CartItem> getAllItems() {
        return itemDao.getAllItemInCart();
    }

    public void addItem(int productId) {
        if (itemDao.isItemInCart(productId)) {
            CartItem item = itemDao.getCartItem(productId);
            itemDao.addExistingCartItem(productId);
        } else {
            CartItem newItem = new CartItem(productId);
            itemDao.insertNewCartItem(newItem);
        }
    }

    public void removeItem(int productId) {
        CartItem item = itemDao.getCartItem(productId);
        if (item.quantity - 1 > 0) {
            itemDao.decreaseCartItem(productId);
        } else {
            itemDao.deleteEntireCartItem(productId);
        }
    }

    public int getTotalItemCount() {
        return itemDao.getTotalItemCount();
    }
}
