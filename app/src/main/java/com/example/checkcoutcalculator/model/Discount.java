package com.example.checkcoutcalculator.model;

public interface Discount {
    String getDiscountType();
    double priceAfterDiscount(double originalPrice);
    double discountedValue(double originalPrice);
}
