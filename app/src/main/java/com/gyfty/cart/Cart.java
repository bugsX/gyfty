package com.gyfty.cart;

import android.util.Log;

import com.gyfty.logistics.DeliveryLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.promotions.Promotion;
import com.gyfty.users.GyftyUser;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("Cart")
public class Cart extends ParseObject {

    private double total;
    public List<ProductPriceRow> productPrice = new ArrayList<ProductPriceRow>();

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
        put(CartParams.pickup.toString(),value);
    }

    public Schedule getSchedule() {
        return (Schedule)getParseObject(CartParams.schedule.toString());
    }

    public void setSchedule(Schedule value) {
        put(CartParams.schedule.toString(),value);
    }

    public DeliveryLogistics getDeliveryLogistics() {
        return (DeliveryLogistics)getParseObject(CartParams.deliveryLogistics.toString());
    }

    public void setDeliveryLogistics(DeliveryLogistics value) {
        put(CartParams.deliveryLogistics.toString(),value);
    }

    public enum CartParams{
        user, //User
        products, //List<Prodcuts>
        pickup, //pickup
        schedule, //schedule
        deliveryLogistics


    }


    public static class CartBuilder {

        Cart cart;
        public Cart getCart(GyftyUser user) throws ParseException {

            ParseQuery<Cart> query = ParseQuery.getQuery("Cart");
            query.whereEqualTo(CartParams.user.toString(),user);

            try {
                cart = query.getFirst();
                if(cart==null){

                    cart.setUser(user);
                    cart.save();
                }

            } catch (ParseException e) {

                Log.e(Cart.DEFAULT_PIN,"Cannot find cart"+ e);
            }

            return cart;

        }

        public void addProductToCart(Cart cart, GyftyProduct product) {

            cart.addProduct(product);
            cart.saveEventually();

        }

        private void calculateTotal(Cart cart) {

            double total = 0;
            for(ProductPriceRow row: cart.productPrice){

                total += row.getPriceAfterDiscount();
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


        public void addDeliveryLogisticsToCart(Cart cart, DeliveryLogistics deliveryLogistics){

            cart.setDeliveryLogistics(deliveryLogistics);
            cart.saveEventually();

        }

        public void removeDeliveryLogisticsFromCart(Cart cart){

            cart.setDeliveryLogistics(null);
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

        public void removePromotion(Cart cart, Promotion promotion) {

            for(ProductPriceRow row : cart.productPrice) {

                row.setPriceAfterDiscount(row.getProduct().getPrice());
                row.setVendorPayment(row.getProduct().getPrice());
            }

            calculateTotal(cart);
            cart.saveEventually();

        }

        public void addVendorPayment(){



        }


        public void buildCart(){




        }



    }


}
