package com.example.checkcoutcalculator.viewmodel;

public class CartItemDisplayInfo {
    public int productId;
    public String productName;
    public double price;
    public boolean taxable;
    public int quantity;
    public double subtotal;

    public CartItemDisplayInfo(
            int productId, String productName, double price,
            boolean taxable, int quantity, double subtotal) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.taxable = taxable;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
}
