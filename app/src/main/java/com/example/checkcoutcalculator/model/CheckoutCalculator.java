package com.example.checkcoutcalculator.model;

public class CheckoutCalculator {
    private final CartManager cartManager;
    private double taxRate;
    private double discountRate;

    /**
     * Constructor:
     * Initialize a CheckoutCalculator with a cartManager
     * @param cartManager calculate price from this manager
     */
    public CheckoutCalculator(CartManager cartManager) {
        this.cartManager = cartManager;
        this.taxRate = 0.0;
        this.discountRate = 0.0;
    }

    /**
     * Setter method of discount rate
     * @param discountRate the new discount rate
     */
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * Setter method of tax rate
     * @param taxRate the new tax rate
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Get final price after applying tax and discounts
     * @return final price after applying tax and discounts
     */
    public double getFinalPrice() {
        return cartManager.getTotalPrice() * (1.0 + taxRate) * (1.0 - discountRate);
    }
}
