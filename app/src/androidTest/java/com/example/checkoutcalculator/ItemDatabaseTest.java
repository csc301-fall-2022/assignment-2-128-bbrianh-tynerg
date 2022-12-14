package com.example.checkoutcalculator;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.checkoutcalculator.db.CartItem;
import com.example.checkoutcalculator.db.ItemDao;
import com.example.checkoutcalculator.db.ItemDatabase;
import com.example.checkoutcalculator.db.MenuItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


@RunWith(AndroidJUnit4.class)
public class ItemDatabaseTest {

    private ItemDatabase db;
    private ItemDao itemDao;

    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, ItemDatabase.class).build();
        itemDao = db.itemDao();
        itemDao.insertMenuItem(
                new MenuItem(1, "a", 1.0, true),
                new MenuItem(2, "b", 2.5, false),
                new MenuItem(3, "c", 5.5, true));
    }

    @After
    public void tearDown() throws Exception {
        if(db != null && db.isOpen()) {
            db.close();
        }
    }

    @Test
    public void TestReadMenu() {
        List<MenuItem> menu = this.itemDao.getAllItemOnMenu();
        assertEquals(menu.size(), 3);
        assertEquals(menu.get(0).itemName, "a");
        assertEquals(menu.get(0).price, 1.0, 0.001);
        assertTrue(menu.get(0).taxable);
    }

    @Test
    public void TestReadWriteCart() {
        List<MenuItem> menu = this.itemDao.getAllItemOnMenu();
        int productId = menu.get(0).uid;

        CartItem cartItem = new CartItem(productId);
        this.itemDao.insertNewCartItem(cartItem);
        assertEquals(1, this.itemDao.getCartItem(productId).quantity);

        this.itemDao.addExistingCartItem(productId);
        assertEquals(2, this.itemDao.getCartItem(productId).quantity);

        this.itemDao.decreaseCartItem(productId);
        assertEquals(1, this.itemDao.getCartItem(productId).quantity);

        this.itemDao.deleteEntireCartItem(productId);
        assertFalse(this.itemDao.isItemInCart(productId));
    }



}