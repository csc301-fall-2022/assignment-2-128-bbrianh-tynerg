package com.example.checkoutcalculator.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * A CartItem entity in the database
 */
@Entity
public class CartItem {

    @PrimaryKey(autoGenerate = true)
    public long uid;

    @ColumnInfo(name = "productId")
    public int productId;

    @ColumnInfo(name = "quantity", defaultValue = "1")
    public int quantity;

    public CartItem() {}

    @Ignore
    public CartItem(int productId) {
        this.productId = productId;
        this.quantity = 1;
    }
}
