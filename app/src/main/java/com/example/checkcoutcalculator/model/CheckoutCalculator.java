package com.example.checkcoutcalculator.model;

public class CheckoutCalculator {
    private final CartManager cartManager;
    private double taxRate;
    private Discount discount;

    /**
     * Constructor:
     * Initialize a CheckoutCalculator with a cartManager
     * @param cartManager calculate price from this manager
     */
    public CheckoutCalculator(CartManager cartManager) {
        this.cartManager = cartManager;
        this.taxRate = 0.0;
        this.discount = null;
    }

    /**
     * Setter method of discount rate
     * @param discount the new discount
     */
    public void setDiscountRate(Discount discount) {
        this.discount= discount;
    }

    /**
     * Setter method of tax rate
     * @param taxRate the new tax rate
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Getter method of discount
     * @return the discount of the discount object
     */
    public Discount getDiscount() {
        return this.discount;
    }

    /**
     * Get final price after applying tax and discounts
     * @return final price after applying tax and discounts
     */
    public double getFinalPrice() {
        return this.discount.priceAfterDiscount(cartManager.getTotalPrice() * (1.0 + taxRate));
    }
}
