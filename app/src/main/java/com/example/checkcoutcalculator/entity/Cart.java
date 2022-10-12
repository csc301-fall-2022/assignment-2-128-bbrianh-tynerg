package com.example.checkcoutcalculator.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Menu menu;
    private final Map<String, CartItem> items;
    private double totalPrice;
    private int itemCount;

    /**
     * Constructor:
     * Initialize an empty cart
     */
    public Cart(Menu menu) {
        this.menu = menu;
        this.items = new HashMap<>();
        this.totalPrice = 0.0;
    }

    /**
     * Add an item to the cart
     * @param itemName the item being added to the cart.
     * @return true iff the given itemName is on the menu
     */
    public boolean addItem(String itemName) {
        CartItem item = this.items.get(itemName);

        if (item == null) { // item not in cart
            double price = this.menu.getPrice(itemName);
            if (price < 0) { // item not in menu
                return false;
            }
            else {
                CartItem addedItem = new CartItem(itemName, price);
                this.items.put(itemName, addedItem);
                this.itemCount++;
                this.totalPrice += addedItem.getPrice();
            }
        }
        else {
            item.addOne();
            this.itemCount++;
            this.totalPrice += item.getPrice();
        }
        return true;
    }

    /**
     * Remove an item from the cart
     * @param itemName the name of the item
     * @return true iff the item was in the cart
     */
    public boolean removeItem(String itemName) {
        CartItem item = this.items.get(itemName);
        if (item == null) { // item not in cart
            return false;
        }
        else {
            if (!item.removeOne()) {
                // remove item if quantity drops to 0
                this.items.remove(itemName);
            }
            this.itemCount--;
            this.totalPrice -= item.getPrice();
            return true;
        }
    }

    /**
     * Getter method of totalPrice
     * @return the totalPrice of the items
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Getter method of items
     * @return the items field of this instance of Cart
     */
    public Map<String, CartItem> getItems(){
        return this.items;
    }

    public int getItemCount() {
        return this.itemCount;
    }
}
