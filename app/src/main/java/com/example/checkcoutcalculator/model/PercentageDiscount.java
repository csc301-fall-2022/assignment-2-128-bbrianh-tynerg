package com.example.checkcoutcalculator.model;

public class PercentageDiscount implements Discount{
    private final double discountRate;

    public PercentageDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double priceAfterDiscount(double originalPrice) {
        return originalPrice * (1.0 - discountRate);
    }

    @Override
    public String getDiscountType() {
        return "percentage";
    }

    @Override
    public double discountedValue(double originalPrice) {
        return originalPrice * discountRate;
    }
}
