package com.gyfty.cart;

import android.util.Log;

import com.google.common.collect.Lists;
import com.gyfty.attributes.GyftyAttributes;
import com.gyfty.events.GyftyEvent;
import com.gyfty.logistics.DeliveryLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.order.Order;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.CartGyftyProduct;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.promotions.Promotion;
import com.gyfty.support.Addresses;
import com.gyfty.users.GyftyUser;
import com.gyfty.vendor.VendorPayments;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("Cart")
public class Cart extends ParseObject {

    public List<ProductPriceRow> productPrice = Lists.newArrayList();
    private double total;

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

    public GyftyEvent getEvent() {
        return (GyftyEvent) getParseObject(CartParams.event.toString());
    }

    public void setEvent(GyftyEvent value) {
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
        products, //List<Prodcuts>
        pickup, //pickup
        schedule, //schedule
        address,
        event,
        transactionId


    }


    public static class CartBuilder {

        Cart cart;
        public Cart getCart(GyftyUser user) throws ParseException {

            ParseQuery<Cart> query = ParseQuery.getQuery("Cart");
            query.whereEqualTo(CartParams.user.toString(), user);

            try {
                cart = query.getFirst();
                if(cart==null){
                    Cart cart = new Cart();
                    cart.setUser(user);
                    cart.save();
                }

            } catch (ParseException e) {

                Log.e(Cart.DEFAULT_PIN,"Cannot find cart"+ e);
            }

            return cart;

        }

        public void addProductToCart(Cart cart, CartGyftyProduct product) {
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

        private void calculateTotal(Cart cart) {

            double total = 0;
            for(ProductPriceRow row: cart.productPrice){

                total += row.getPriceAfterDiscount();
            }

            if (total <= Double.valueOf(GyftyAttributes.attributeMap.get("minimumCartTotal"))){

                cart.total = total + Double.valueOf(GyftyAttributes.attributeMap.get("deliveryFee"));

            }

                cart.total = total;

        }

        public void removeProductInCart(Cart cart,GyftyProduct product){

            GyftyProductsGroup productGrp = cart.getProducts();
            try {
                if(productGrp.getGyftyProductGroup().size()>0){

                    productGrp.removeGyftyProductsFromGrp(product);
                }

            } catch (JSONException e) {
                Log.e(Cart.DEFAULT_PIN,"Cannot add product to Cart"+ e);
            }

        }

        public void addPickUpToCart(Cart cart, PickUp pickUp){

            cart.setPickup(pickUp);
            cart.saveEventually();

        }

        public void removePickUpFromCart(Cart cart){

            cart.setPickup(null);
            cart.saveEventually();


        }



        public void addAddressToCart(Cart cart, Addresses address){

            cart.setAddress(address);
            cart.saveEventually();

        }

        public void addScheduleToCart(Cart cart, Schedule schedule) {

            cart.setSchedule(schedule);
            cart.saveEventually();

        }

        public void removeScheduleFromCart(Cart cart) {

            cart.setSchedule(null);
            cart.saveEventually();

        }


        public void addPromotion(Cart cart, Promotion promotion) {

            for(ProductPriceRow row : cart.productPrice) {

                promotion.addPromotion(row);
            }
            calculateTotal(cart);
            cart.saveEventually();

        }

        public void removePromotion(Cart cart, Promotion promotion) throws Exception {

            for(ProductPriceRow row : cart.productPrice) {
                row.setPriceAfterDiscount(row.getProduct().getPrice());
                row.setVendorPayment(row.getProduct().getPrice());
            }

            calculateTotal(cart);
            cart.saveEventually();

        }

        public void addVendorPayment(GyftyProduct product,String ObjectId ,ProductPriceRow productPriceRow){

            VendorPayments vendorPayments = new VendorPayments();
            vendorPayments.setVendor(product.getVendor());
            vendorPayments.setObjectId(ObjectId);
            vendorPayments.setCommisionAmount(productPriceRow.getCommisionAmount());
            vendorPayments.setPaymentAmount(productPriceRow.getVendorPayment());
            vendorPayments.setTotalAmount(productPriceRow.getPriceAfterDiscount());
            vendorPayments.saveEventually();

        }


        public Order buildCart(Cart cart){

            Order order = new Order();
            order.setSchedule(cart.getSchedule());
            order.setAddress(cart.getAddress());
            order.setPickUp(cart.getPickup());
            order.setEvent(cart.getEvent());
            order.setProductGroup(cart.getProducts());
            order.saveEventually();


            for(ProductPriceRow productPriceRow:cart.productPrice){

                addVendorPayment(productPriceRow.getProduct(),order.getObjectId(),productPriceRow);
            }


            cart.deleteEventually();
            return order;

        }


        public Order buildCartWithOrder(Cart cart, Order order){

            order.setProductGroup(cart.getProducts());
            order.addTransactionIdToOrder(cart.getTransactionId(),order);
            order.saveEventually();


            for(ProductPriceRow productPriceRow:cart.productPrice){

                addVendorPayment(productPriceRow.getProduct(),order.getObjectId(),productPriceRow);
            }


            cart.deleteEventually();
            return order;

        }






    }


}
