package com.example.checkcoutcalculator.model;

public class FixedValueDiscount implements Discount{
    private final double discountValue;

    public FixedValueDiscount(double discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public String getDiscountType() {
        return "fixed";
    }

    @Override
    public double priceAfterDiscount(double originalPrice) {
        return originalPrice - discountValue;
    }

    @Override
    public double discountedValue(double originalPrice) {
        return discountValue;
    }
}
