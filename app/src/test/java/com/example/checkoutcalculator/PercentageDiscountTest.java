package com.example.checkoutcalculator;

import static org.junit.Assert.*;

import com.example.checkoutcalculator.model.PercentageDiscount;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Percentage Discount
 */
public class PercentageDiscountTest {

    private PercentageDiscount discount;
    private double originalPrice;

    @Before
    public void setUp() {
        discount = new PercentageDiscount(0.1);
        originalPrice = 10.0;
    }

    @Test
    public void testGetDiscountType() {
        assertEquals("percentage", discount.getDiscountType());
    }

    @Test
    public void testPriceAfterDiscount() {
        assertEquals(9.0, discount.priceAfterDiscount(originalPrice), 0.01);
    }

    @Test
    public void testDiscountedValue() {
        assertEquals(1.0, discount.discountedValue(originalPrice), 0.01);
    }
}