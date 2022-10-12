package com.example.checkcoutcalculator.model;

import com.example.checkcoutcalculator.db.CartItem;
import com.example.checkcoutcalculator.db.CartRepository;
import com.example.checkcoutcalculator.db.MenuItem;
import com.example.checkcoutcalculator.db.MenuRepository;

import java.util.List;

public class CheckoutCalculator {
    private CartRepository cart;
    private MenuRepository menu;
    private double taxRate;
    private Discount discount;

    /**
     * Constructor:
     * Initialize a CheckoutCalculator with a cartManager
     */
    public CheckoutCalculator(CartRepository cart, MenuRepository menu) {
        this.cart = cart;
        this.menu = menu;
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
        List<CartItem> allItems = cart.getAllItems();
        double taxableTotal = 0.0;
        double nonTaxableTotal = 0.0;
        for (CartItem item : allItems) {
            MenuItem product = this.menu.searchItem(item.productId);
            if (product.taxable) {
                taxableTotal += product.price;
            } else {
                nonTaxableTotal += product.price;
            }
        }

        double afterTax = taxableTotal * (1.0 + this.taxRate) + nonTaxableTotal;

        return this.discount.priceAfterDiscount(afterTax);
    }
}
