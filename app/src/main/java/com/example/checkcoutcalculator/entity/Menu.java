package com.example.checkcoutcalculator.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Menu {
    private final Map<String, Double> items;

    /**
     * Constructor:
     * Initialize the menu with an empty hashmap
     */
    public Menu(){
        this.items = new HashMap<>();
    }

    /**
     * Add an item to menu
     * @param itemName the name of the item
     * @param price the price of the item
     */
    public void addItem(String itemName, double price) {
        this.items.put(itemName, price);
    }

    /**
     * Remove an item from menu
     * @param itemName the name of the item
     */
    public void removeItem(String itemName) {
        this.items.remove(itemName);
    }

    /**
     * Return the price of a given item.
     * Return -1.0 if the item is not in the menu.
     * @param itemName the name of the item
     * @return the price of the item, or -1.0 if the item is not in the menu.
     */
    public double getPrice(String itemName) {
        Double price = this.items.get(itemName);
        if (price != null) {
            return price;
        } else {
            return -1.0;
        }
    }

    /**
     * Getter method of items
     * @return a map containing items and its corresponding price
     */
    public Map<String, Double> getItems() {
        return this.items;
    }



}
