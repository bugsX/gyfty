package com.gyfty.cart;

import android.util.Log;

import com.google.common.collect.Lists;
import com.gyfty.events.Event;
import com.gyfty.logistics.Schedule;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.promotions.Promotion;
import com.gyfty.support.Addresses;
import com.gyfty.users.GyftyUser;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Mac on 9/21/15.
 */

// Cart Table contains all the carts by User

@ParseClassName("Cart")
public class Cart extends ParseObject {

    public List<ProductPriceRow> productPrice = Lists.newArrayList();
    public List<Promotion> promotions = Lists.newArrayList();
    public double total;

    public GyftyUser getUser() {
        return (GyftyUser)getParseObject(CartParams.user.toString());
    }

    public void setUser(GyftyUser value) {
        put(CartParams.user.toString(),value);
    }

    public GyftyProductsGroup getProducts() {
        return (GyftyProductsGroup)getParseObject(CartParams.products.toString());
    }

    public void setProducts(GyftyProductsGroup value) {
        put(CartParams.products.toString(),value);
    }

    public void addProduct(GyftyProduct product){
        GyftyProductsGroup productGrp = getProducts();
        if(productGrp==null){
            productGrp = new GyftyProductsGroup();
        }
        productGrp.addGyftyProductToGrp(product);
        try {
            productGrp.save();
        } catch (ParseException e) {
            Log.e(Cart.DEFAULT_PIN, "Unable to save product " + product.getObjectId() + " in product group table.", e);
        }
        setProducts(productGrp);
    }

    public PickUp getPickup() {
        return (PickUp)getParseObject(CartParams.pickup.toString());
    }

    public void setPickup(PickUp value) {
        put(CartParams.pickup.toString(), value);
    }

    public Schedule getSchedule() {
        return (Schedule)getParseObject(CartParams.schedule.toString());
    }

    public void setSchedule(Schedule value) {
        put(CartParams.schedule.toString(),value);
    }


    public Addresses getAddress() {
        return (Addresses) getParseObject(CartParams.address.toString());
    }


    public void setAddress(Addresses value) {
        put(CartParams.address.toString(),value);
    }

    public Event getEvent() {
        return (Event) getParseObject(CartParams.event.toString());
    }

    public void setEvent(Event value) {
        put(CartParams.event.toString(),value);
    }

    public String getTransactionId() {
        return getString(CartParams.transactionId.toString());
    }

    public void setTransactionId(String value) {
        put(CartParams.transactionId.toString(),value);
    }

    public enum CartParams{
        user, //User
        products, // GyftyProductsGroup
        pickup, // Pickup
        schedule, // Schedule
        address, // Addresses
        event, // GyftyEvent
        transactionId


    }
}
