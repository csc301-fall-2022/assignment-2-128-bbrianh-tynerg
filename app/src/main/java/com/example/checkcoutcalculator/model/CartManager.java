package com.example.checkcoutcalculator.model;

import com.example.checkcoutcalculator.entity.Cart;
import com.example.checkcoutcalculator.entity.CartItem;

import java.util.HashMap;
import java.util.Map;

public class CartManager {
    private final Cart cart;

    /**
     * Constructor:
     * Initialize a cart with a menu
     * @param menuManager Get the menu from this manager
     */
    public CartManager(MenuManager menuManager) {
        this.cart = new Cart(menuManager.getMenu());
    }

    /**
     * Add item to cart
     * @param itemName name of the added item
     * @return true iff item is in the menu
     */
    public boolean addItemToCart(String itemName) {
        return cart.addItem(itemName);
    }

    /**
     * Remove item from cart
     * @param itemName name of the removed item
     * @return true iff item was in cart before the function was called
     */
    public boolean removeItemFromCart(String itemName) {
        return cart.removeItem(itemName);
    }

    /**
     * Return the items and the corresponding quantities in the cart
     * @return a map containing the items and the corresponding quantities in the cart
     */
    public Map<String, Integer> getCartState() {
        Map<String, CartItem> items = this.cart.getItems();

        Map<String, Integer> ret = new HashMap<>();
        for (String key: items.keySet()) {
            CartItem item = items.get(key);
            if (item != null) {
                ret.put(key, item.getQuantity());
            }
        }

        return ret;
    }

    /**
     * Return the total price of the items in the cart
     * @return the total price of the items in the cart
     */
    public double getTotalPrice() {
        return this.cart.getTotalPrice();
    }
}
