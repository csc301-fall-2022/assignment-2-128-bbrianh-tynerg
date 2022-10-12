package com.example.checkcoutcalculator;

import com.example.checkcoutcalculator.entity.Cart;
import com.example.checkcoutcalculator.entity.CartItem;
import com.example.checkcoutcalculator.entity.Menu;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;
import java.util.Objects;

public class EntityTest {
    private Cart cart;

    @Before
    public void setUp() {
        // set menu
        Menu menu = new Menu();
        menu.addItem("a", 1.0);
        menu.addItem("b", 1.5);
        menu.addItem("c", 2.0);

        // set cart
        this.cart = new Cart(menu);
    }

    @Test
    public void testAddItem() {
        this.cart.addItem("a");
        this.cart.addItem("a");
        this.cart.addItem("b");

        assertEquals(this.cart.getItemCount(), 3);

        Map<String, CartItem> items = this.cart.getItems();
        assertEquals(Objects.requireNonNull(items.get("a")).getQuantity(), 2);
        assertEquals(Objects.requireNonNull(items.get("b")).getQuantity(), 1);
    }

    @Test
    public void testRemoveItem() {
        this.cart.addItem("a");
        this.cart.addItem("a");
        this.cart.addItem("b");
        this.cart.addItem("c");

        this.cart.removeItem("a");
        this.cart.removeItem("c");

        Map<String, CartItem> items = this.cart.getItems();
        assertFalse(items.containsKey("c"));
        assertEquals(Objects.requireNonNull(items.get("a")).getQuantity(), 1);
    }

    @Test
    public void testGetTotalPrice() {
        this.cart.addItem("a");
        this.cart.addItem("a");
        this.cart.addItem("b");
        this.cart.addItem("c");

        assertEquals(this.cart.getTotalPrice(), 5.5, 0.001);
    }
}
