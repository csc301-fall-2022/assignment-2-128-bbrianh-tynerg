package com.example.checkoutcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.checkoutcalculator.model.FixedValueDiscount;

/**
 * Test Fixed Value Discount
 */
public class FixedValueDiscountTest {

    private FixedValueDiscount discount;
    private double originalPrice;

    @Before
    public void setUp() {
        discount = new FixedValueDiscount(5.0);
        originalPrice = 10.0;
    }

    @Test
    public void testGetDiscountType() {
        assertEquals("fixed", discount.getDiscountType());
    }

    @Test
    public void testPriceAfterDiscount() {
        assertEquals(5.0, discount.priceAfterDiscount(originalPrice), 0.01);
    }

    @Test
    public void testDiscountedValue() {
        assertEquals(5.0, discount.discountedValue(originalPrice), 0.01);
    }
}