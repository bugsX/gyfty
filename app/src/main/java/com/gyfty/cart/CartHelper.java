package com.gyfty.cart;

import android.util.Log;

import com.gyfty.attributes.GyftyAttributes;
import com.gyfty.logistics.Schedule;
import com.gyfty.order.Order;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.CartGyftyProduct;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.promotions.Promotion;
import com.gyfty.support.Addresses;
import com.gyfty.users.GyftyUser;
import com.gyfty.vendor.VendorNotes;
import com.gyfty.vendor.VendorPayments;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.json.JSONException;

/**
 * Created by akhilch on 10/6/2015.
 */
public class CartHelper {
    public static void addProductToCart(Cart cart, CartGyftyProduct product) {
        cart.addProduct(product);
        double price = Double.MAX_VALUE;
        try {
            price = product.getPrice();
        } catch (Exception e) {
            Log.e("Cart", "Get price Failed " + e.getMessage() + "For user " + cart.getUser().getObjectId());
        }
        double commisionAmount = price * product.getVendor().getCommisionPercentage() / 100;
        double vendorPayment = price - commisionAmount;
        double priceAfterDiscount = price;
        ProductPriceRow pprow = new ProductPriceRow(product, 0.0, commisionAmount, vendorPayment, priceAfterDiscount, null);
        cart.productPrice.add(pprow);
        cart.saveEventually();
    }

    private static void calculateTotal(Cart cart) {

        double total = 0;
        for (ProductPriceRow row : cart.productPrice) {

            total += row.getPriceAfterDiscount();
        }

        if (total <= Double.valueOf(GyftyAttributes.attributeMap.get("minimumCartTotal"))) {

            cart.total = total + Double.valueOf(GyftyAttributes.attributeMap.get("deliveryFee"));

        }

        cart.total = total;

    }

    public static void removeProductInCart(Cart cart, GyftyProduct product) {

        GyftyProductsGroup productGrp = cart.getProducts();
        try {
            if (productGrp.getGyftyProductGroup().size() > 0) {

                productGrp.removeGyftyProductsFromGrp(product);
            }

        } catch (JSONException e) {
            Log.e(Cart.DEFAULT_PIN, "Cannot add product to Cart" + e);
        }

    }

    public static void addPickUpToCart(Cart cart, PickUp pickUp) {

        cart.setPickup(pickUp);
        cart.saveEventually();

    }

    public static void removePickUpFromCart(Cart cart) {

        cart.setPickup(null);
        cart.saveEventually();


    }

    public static void addAddressToCart(Cart cart, Addresses address) {

        cart.setAddress(address);
        cart.saveEventually();

    }

    public static void addScheduleToCart(Cart cart, Schedule schedule) {

        cart.setSchedule(schedule);
        cart.saveEventually();

    }

    public static void removeScheduleFromCart(Cart cart) {

        cart.setSchedule(null);
        cart.saveEventually();

    }

    public static void addPromotion(Cart cart, Promotion promotion) {

        for (ProductPriceRow row : cart.productPrice) {

            promotion.addPromotion(row);
        }
        calculateTotal(cart);
        cart.saveEventually();

    }

    public static void removePromotion(Cart cart, Promotion promotion) throws Exception {

        for (ProductPriceRow row : cart.productPrice) {
            row.setPriceAfterDiscount(row.getProduct().getPrice());
            row.setVendorPayment(row.getProduct().getPrice());
        }

        calculateTotal(cart);
        cart.saveEventually();

    }

    public static void addVendorPayment(GyftyProduct product, String ObjectId, ProductPriceRow productPriceRow) {

        VendorPayments vendorPayments = new VendorPayments();
        vendorPayments.setVendor(product.getVendor());
        vendorPayments.setObjectId(ObjectId);
        vendorPayments.setCommisionAmount(productPriceRow.getCommisionAmount());
        vendorPayments.setPaymentAmount(productPriceRow.getVendorPayment());
        vendorPayments.setTotalAmount(productPriceRow.getPriceAfterDiscount());
        vendorPayments.saveEventually();

    }

    public static Order buildCart(Cart cart) {

        Order order = new Order();
        order.setSchedule(cart.getSchedule());
        order.setAddress(cart.getAddress());
        order.setPickUp(cart.getPickup());
        order.setEvent(cart.getEvent());
        order.setProductGroup(cart.getProducts());
        order.saveEventually();


        for (ProductPriceRow productPriceRow : cart.productPrice) {

            addVendorPayment(productPriceRow.getProduct(), order.getObjectId(), productPriceRow);
            addVendorNotes(productPriceRow.getProduct(), order);

        }


        cart.deleteEventually();
        return order;

    }

    private static void addVendorNotes(CartGyftyProduct product, Order order) {
        VendorNotes notes = new VendorNotes();
        notes.setNotesForProduct(product.getSellerNotes());
        notes.setVendor(product.getVendor());
        notes.setGyftyProduct(product);
        notes.setOrder(order);
        notes.setSchedule(order.getSchedule());
        notes.saveInBackground();
    }

    public static Order buildCartWithOrder(Cart cart, Order order) {

        order.setProductGroup(cart.getProducts());
        order.addTransactionIdToOrder(cart.getTransactionId(), order);
        order.saveEventually();
        for (ProductPriceRow productPriceRow : cart.productPrice) {

            addVendorPayment(productPriceRow.getProduct(), order.getObjectId(), productPriceRow);
            addVendorNotes(productPriceRow.getProduct(), order);

        }
        cart.deleteEventually();
        return order;

    }

    public Cart getCart(GyftyUser user) throws ParseException {
        Cart cart = null;
        ParseQuery<Cart> query = ParseQuery.getQuery("Cart");
        query.whereEqualTo(Cart.CartParams.user.toString(), user);

        try {
            cart = query.getFirst();
            if (cart == null) {
                cart = new Cart();
                cart.setUser(user);
                cart.save();
            }

        } catch (ParseException e) {

            Log.e(Cart.DEFAULT_PIN, "Cannot find cart" + e);
        }

        return cart;

    }
}

