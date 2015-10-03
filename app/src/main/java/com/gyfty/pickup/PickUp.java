package com.gyfty.pickup;

import com.gyfty.order.Order;
import com.gyfty.logistics.PickUpLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.services.cart.Cart;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("PickUp")
public class PickUp extends ParseObject {

    public Order getOrder() {
        return (Order)getParseObject(PickUpParams.order.toString());
    }

    public void setOrder(Order value) {
        put(PickUpParams.order.toString(),value);
    }

    public com.gyfty.services.cart.Cart.Cart getCart() {
        return (com.gyfty.services.cart.Cart.Cart)getParseObject(PickUpParams.cart.toString());
    }

    public void setCart(Cart.Cart value) {
        put(PickUpParams.cart.toString(),value);
    }

    public PickUpLogistics getPickUpLogistics() {
        return (PickUpLogistics)getParseObject(PickUpParams.pickUpLogistics.toString());
    }

    public void setPickUpLogistics(PickUpLogistics value) {
        put(PickUpParams.pickUpLogistics.toString(),value);
    }

    public Schedule getSchedule() {
        return (Schedule)getParseObject(PickUpParams.schedule.toString());
    }

    public void setSchedule(Schedule value) {
        put(PickUpParams.schedule.toString(),value);
    }




    public enum PickUpParams{
        order, //Order
        cart, //Cart
        pickUpLogistics, // Address
        schedule //Schedule
    }

}
