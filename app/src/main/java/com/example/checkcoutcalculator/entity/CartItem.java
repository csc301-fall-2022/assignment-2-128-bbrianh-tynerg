package com.example.checkcoutcalculator.entity;

public class CartItem {
    private final String name;
    private final Double price;
    private int quantity;

    /**
     * Constructor:
     * Initialize an Item with name and price. Quantity is set to default value of 1
     * @param name the name of the item
     * @param price the price of the item
     */
    public CartItem(String name, Double price){
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    /**
     * Constructor:
     * Initialize an Item with name, price and quantity
     * @param name the name of the item
     * @param price the price of the item
     * @param quantity the quantity of the item
     */
    public CartItem(String name, Double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Getter method of name
     * @return the name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method of price
     * @return the price of the item
     */
    public Double getPrice() {
        return this.price;
    }

    /**
     * Getter method of quantity
     * @return the quantity of the item
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Add 1 to the quantity
     */
    public void addOne() {
        this.quantity++;
    }

    /**
     * Remove 1 from the quantity
     * @return true iff the final quantity is greater than 0
     */
    public boolean removeOne() {
        if (this.quantity - 1 > 0) {
            this.quantity--;
            return true;
        } else {
            return false;
        }
    }
}
