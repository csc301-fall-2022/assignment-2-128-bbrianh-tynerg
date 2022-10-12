package com.example.checkcoutcalculator.model;

import com.example.checkcoutcalculator.entities.Menu;

import java.util.Map;

public class MenuManager {
    private final Menu menu;

    /**
     * Constructor:
     * initialize a menu manager with an empty menu
     */
    public MenuManager() {
        this.menu = new Menu();
    }

    /**
     * add item to menu
     * @param itemName the name of the added item
     * @param price the price of the added item
     */
    public void addItemToMenu(String itemName, double price) {
        this.menu.addItem(itemName, price);
    }

    /**
     * remove item from menu
     * @param itemName the name of the removed item
     */
    public void removeItemFromMenu(String itemName) {
        this.menu.removeItem(itemName);
    }

    /**
     * Getter method of menu
     * @return the menu field in this manager
     */
    public Menu getMenu() {
        return this.menu;
    }

    /**
     * Return a map containing all the items and its corresponding prices
     * @return a map containing all the items and its corresponding prices
     */
    public Map<String, Double> getItemAndPrice() {
        return this.menu.getItems();
    }
}
