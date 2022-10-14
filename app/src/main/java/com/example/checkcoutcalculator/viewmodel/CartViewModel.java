package com.example.checkcoutcalculator.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.checkcoutcalculator.db.CartItem;
import com.example.checkcoutcalculator.db.CartRepository;
import com.example.checkcoutcalculator.db.MenuItem;
import com.example.checkcoutcalculator.db.MenuRepository;
import com.example.checkcoutcalculator.model.CheckoutCalculator;
import com.example.checkcoutcalculator.model.PercentageDiscount;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private final MenuRepository menuRepository;
    private final CartRepository cartRepository;
    private final MutableLiveData<List<CartItemDisplayInfo>> mCartItems;

    private final CheckoutCalculator checkoutCalculator;

    public CartViewModel(Application application) {
        super(application);
        menuRepository = new MenuRepository(application);
        cartRepository = new CartRepository(application);

        checkoutCalculator = new CheckoutCalculator(cartRepository, menuRepository);

        mCartItems = new MutableLiveData<>();
        fetchCartData();
    }

    public LiveData<List<CartItemDisplayInfo>> getCartItems() {
        return mCartItems;
    }

    public void fetchCartData() {
        // get cart data
        List<CartItem> items = cartRepository.getAllItems();
        List<CartItemDisplayInfo> displayInfos = new ArrayList<>();

        if (items != null) {
            for (CartItem cartItem : items) {
                MenuItem product = menuRepository.searchItem(cartItem.productId);
                displayInfos.add(new CartItemDisplayInfo(
                        product.uid,
                        product.itemName,
                        product.price,
                        product.taxable,
                        cartItem.quantity,
                        product.price * cartItem.quantity));
            }
        }

        mCartItems.setValue(displayInfos);
    }

    public void increaseItemQuantity(int productId) {
        cartRepository.addItem(productId);
        fetchCartData();
    }

    public void decreaseItemQuantity(int productId) {
        cartRepository.decrementItemQuantity(productId);
        fetchCartData();
    }

    public void removeItemFromCart(int productId) {
        cartRepository.removeEntireItem(productId);
        fetchCartData();
    }

    public double getBeforeTaxTotal() {
        return checkoutCalculator.getSubTotal();
    }

    public void setDiscount(double percentOff) {
        checkoutCalculator.setDiscountRate(new PercentageDiscount(percentOff/100.0));
    }

    public double getTaxPortion() {
        return checkoutCalculator.getTaxPortion();
    }

    public double getFinalPrice() {
        return checkoutCalculator.getFinalPrice();
    }
}