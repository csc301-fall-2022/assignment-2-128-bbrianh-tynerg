package com.example.checkoutcalculator.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    /** MenuItem table */

    @Query("Select * FROM MenuItem")
    List<MenuItem> getAllItemOnMenu();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMenuItem(MenuItem... menuItems);

    @Update
    void updateMenuItem(MenuItem menuItem);

    @Delete
    void deleteMenuItem(MenuItem menuItem);

    @Query("Select * FROM MenuItem WHERE uid = :menuUid")
    MenuItem getMenuItem(int menuUid);

    @Query("DELETE FROM MenuItem")
    void clearMenu();

    /** CartItem table */

    @Query("Select * FROM CartItem")
    List<CartItem> getAllItemInCart();

    @Query("SELECT * FROM CARTITEM WHERE productId = :productId")
    CartItem getCartItem(int productId);

    @Query("SELECT COUNT(1) FROM CartItem WHERE productId = :productId")
    boolean isItemInCart(int productId);

    @Insert
    void insertNewCartItem(CartItem cartItem);

    @Query("UPDATE CartItem SET quantity = quantity + 1 WHERE productId = :productId")
    void addExistingCartItem(int productId);

    @Query("UPDATE CartItem SET quantity = quantity - 1 WHERE productId = :productId")
    void decreaseCartItem(int productId);

    @Query("DELETE FROM CartItem WHERE productId = :productId")
    void deleteEntireCartItem(int productId);

    @Query("SELECT SUM(quantity) FROM CartItem")
    int getTotalItemCount();
}
