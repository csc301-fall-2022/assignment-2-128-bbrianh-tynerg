package com.example.checkoutcalculator.viewmodel;

public class MenuItemDisplayInfo {
    public int productId;
    public String productName;
    public double price;

    public MenuItemDisplayInfo(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
}
