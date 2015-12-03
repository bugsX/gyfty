package com.gyfty.cart;

import android.util.Log;

import com.gyfty.attributes.GyftyAttributes;
import com.gyfty.logistics.Schedule;
import com.gyfty.order.Order;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.BaseCartGyftyProduct;
import com.gyfty.products.CartGyftyProduct;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.promotions.InvitationPromotion;
import com.gyfty.promotions.Promotion;
import com.gyfty.support.Addresses;
import com.gyfty.users.GyftyUser;
import com.gyfty.vendor.VendorNotes;
import com.gyfty.vendor.VendorPayments;
import com.parse.ParseException;
import com.parse.ParseQuery;

/**
 * Created by akhilch on 10/6/2015.
 */

// CartHelper lists the methods that can be performed in and to the cart

public class CartHelper {

    // Adding GyftyProduct to Cart

    public static void addProductToCart(Cart cart, GyftyProduct product) {
        cart.addProduct(product);
        CartGyftyProduct cartProduct = new BaseCartGyftyProduct(product);
        addCartProductPriceRows(cart, cartProduct);
        try {
            cart.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add CartGyftyProduct To cart
     *
     * @param cart
     * @param cartGyftyProduct
     */
    public static void addProductToCart(Cart cart, CartGyftyProduct cartGyftyProduct) {
        cart.addProduct(cartGyftyProduct.getGyftyProduct());
        addCartProductPriceRows(cart, cartGyftyProduct);
        try {
            cart.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Whenever a new product is added to cart we need add price row.
     *
     * @param cart
     * @param cartGyftyProduct
     */
    public static void addCartProductPriceRows(Cart cart, CartGyftyProduct cartGyftyProduct) {
        double price = 0.0;
        try {
            price = cartGyftyProduct.getPrice();
        } catch (Exception e) {
            Log.e("Cart", "Get price Failed " + e.getMessage() + "For user " + cart.getUser().getObjectId());
        }
        double commisionAmount = price * cartGyftyProduct.getGyftyProduct().getVendor().getCommisionPercentage() / 100;
        double vendorPayment = price - commisionAmount;
        double priceAfterDiscount = price;
        ProductPriceRow pprow = new ProductPriceRow(cartGyftyProduct, 0.0, commisionAmount, vendorPayment, priceAfterDiscount, null);
        cart.productPrice.add(pprow);
        calculateTotal(cart);
    }

    // Calculating Cart Total

    private static void calculateTotal(Cart cart) {

        double total = 0.0;
        for (ProductPriceRow row : cart.productPrice) {

            total += row.getPriceAfterDiscount();
        }

        if (total <= Double.valueOf((String) GyftyAttributes.attributeMap.get("minimumCartTotal"))) {
            total = total + Double.valueOf((String) GyftyAttributes.attributeMap.get("deliveryFee"));
        }
        cart.total = total;
    }

    public static void removeProductInCart(Cart cart, GyftyProduct cartProduct) {
        removeProductInCart(cart, new BaseCartGyftyProduct(cartProduct));
    }

    /**
     * Remove in cart Method for CartGyftyProduct
     *
     * @param cart
     * @param cartProduct
     */
    public static void removeProductInCart(Cart cart, CartGyftyProduct cartProduct) {

        GyftyProductsGroup productGrp = cart.getProducts();
        if (productGrp.getGyftyProductGroup().size() > 0) {
            productGrp.removeGyftyProductsFromGrp(cartProduct.getGyftyProduct());
        }
        int indexToRemove = 0;
        for(ProductPriceRow pprow : cart.productPrice) {
            if (pprow.getProduct().getGyftyProduct().equals(cartProduct.getGyftyProduct())
                    && pprow.getProduct().getSellerNotes().equals(cartProduct.getSellerNotes())) {
                break;
            }
            indexToRemove++;
        }
        cart.productPrice.remove(indexToRemove);
        calculateTotal(cart);
    }
    // adding PickUp to cart

    public static void addPickUpToCart(Cart cart, PickUp pickUp) {

        cart.setPickup(pickUp);
        try {
            cart.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // removing PickUp from cart


    public static void removePickUpFromCart(Cart cart) {

        cart.setPickup(null);
        try {
            cart.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    // adding Address to cart

    public static void addAddressToCart(Cart cart, Addresses address) {

        cart.setAddress(address);
        try {
            cart.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // adding Schedule to cart

    public static void addScheduleToCart(Cart cart, Schedule schedule) {

        cart.setSchedule(schedule);
        try {
            cart.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // removing schedule from cart

    public static void removeScheduleFromCart(Cart cart) {

        cart.setSchedule(null);
        cart.saveEventually();

    }

    // adding promotion to cart

    public static void addPromotion(Cart cart, Promotion promotion) {

        for (ProductPriceRow row : cart.productPrice) {

            promotion.addPromotion(row);
        }
        cart.promotions.add(promotion);
        calculateTotal(cart);
        try {
            cart.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // removing promotion from cart

    public static void removePromotion(Cart cart, Promotion promotion) throws Exception {

        for (ProductPriceRow row : cart.productPrice) {
            row.setPriceAfterDiscount(row.getProduct().getPrice());
            row.setVendorPayment(row.getProduct().getPrice());
        }
        cart.promotions.remove(promotion);
        calculateTotal(cart);
        cart.save();

    }

    // adds Vendor Payments by product to the Vendor payment Table

    public static void addVendorPayment(GyftyProduct product, String ObjectId, ProductPriceRow productPriceRow) {

        VendorPayments vendorPayments = new VendorPayments();
        vendorPayments.setVendor(product.getVendor());
        vendorPayments.setObjectId(ObjectId);
        vendorPayments.setCommisionAmount(productPriceRow.getCommisionAmount());
        vendorPayments.setPaymentAmount(productPriceRow.getVendorPayment());
        vendorPayments.setTotalAmount(productPriceRow.getPriceAfterDiscount());
        try {
            vendorPayments.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // builds the cart and returns the order

    public static Order buildCart(Cart cart) {

        cart.getAddress().saveInBackground();

        Order order = new Order();
        order.setSchedule(cart.getSchedule());
        order.setAddress(cart.getAddress());
        order.setPickUp(cart.getPickup());
        order.setEvent(cart.getEvent());
        order.setProductGroup(cart.getProducts());
        order.saveEventually();
        for (Promotion promotion : cart.promotions) {
            promotion.promotionUtilized();
            if (promotion instanceof InvitationPromotion) {
                cart.getUser().setNewUserPromotionUsed();
            }
        }


        for (ProductPriceRow productPriceRow : cart.productPrice) {

            addVendorPayment(productPriceRow.getProduct().getGyftyProduct(), order.getObjectId(), productPriceRow);
            addVendorNotes(productPriceRow.getProduct(), order);

        }

        cart.deleteEventually();
        return order;

    }

    // adds Vendor Notes to each product ordered to the VendorNotes table

    private static void addVendorNotes(CartGyftyProduct product, Order order) {
        VendorNotes notes = new VendorNotes();
        notes.setNotesForProduct(product.getSellerNotes());
        notes.setVendor(product.getGyftyProduct().getVendor());
        notes.setGyftyProduct(product.getGyftyProduct());
        notes.setOrder(order);
        notes.setSchedule(order.getSchedule());
        try {
            notes.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // builds cart with existing order

    public static Order buildCartWithOrder(Cart cart, Order order) throws ParseException {

        cart.getAddress().save();

        order.setProductGroup(cart.getProducts());
        order.addTransactionIdToOrder(cart.getTransactionId(), order);
        order.save();
        for (ProductPriceRow productPriceRow : cart.productPrice) {

            addVendorPayment(productPriceRow.getProduct().getGyftyProduct(), order.getObjectId(), productPriceRow);
            addVendorNotes(productPriceRow.getProduct(), order);

        }

        cart.delete();
        return order;

    }

    // retrieves or creates Cart

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

