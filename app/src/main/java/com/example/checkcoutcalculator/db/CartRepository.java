package com.example.checkcoutcalculator.db;

import android.content.Context;

import java.util.List;

public class CartRepository {

    private final ItemDao itemDao;

    public CartRepository (Context context) {
        ItemDatabase db = ItemDatabase.getDbInstance(context);
        itemDao = db.itemDao();
    }

    /**
     * Return a list of CartItems in the cart
     * @return a list of cartItems in the cart
     */
    public List<CartItem> getAllItems() {
        return itemDao.getAllItemInCart();
    }

    /**
     * Add item using product Id to cart
     * @param productId the product Id of the added item
     */
    public void addItem(int productId) {
        if (itemDao.isItemInCart(productId)) {
            itemDao.addExistingCartItem(productId);
        } else {
            CartItem newItem = new CartItem(productId);
            itemDao.insertNewCartItem(newItem);
        }
    }

    /**
     * Decrease item quantity by 1 using product Id from cart
     * @param productId the product Id of the removed item
     */
    public void decrementItemQuantity(int productId) {
        CartItem item = itemDao.getCartItem(productId);
        if (item.quantity - 1 > 0) {
            itemDao.decreaseCartItem(productId);
        } else {
            itemDao.deleteEntireCartItem(productId);
        }
    }

    /**
     * Remove item entirely from database
     */
    public void removeEntireItem(int productId) {
        itemDao.deleteEntireCartItem(productId);
    }

    /**
     * Return the total item count in the cart
     * @return the total item count in the cart
     */
    public int getTotalItemCount() {
        return itemDao.getTotalItemCount();
    }
}
