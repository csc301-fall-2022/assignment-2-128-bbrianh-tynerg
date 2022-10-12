package com.example.checkcoutcalculator.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * A menu item entity in the database
 */
@Entity
public class MenuItem {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "itemName")
    public String itemName;

    @ColumnInfo(name = "price")
    public double price;

    @ColumnInfo(name = "taxable")
    public boolean taxable;

    public MenuItem() {}

    @Ignore
    public MenuItem(String itemName, double price, boolean taxable) {
        this.itemName = itemName;
        this.price = price;
        this.taxable = taxable;
    }
}
