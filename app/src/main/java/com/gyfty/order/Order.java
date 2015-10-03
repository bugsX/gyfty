package com.gyfty.order;

import com.gyfty.logistics.DeliveryLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.pickup.PickUp;
import com.gyfty.support.Addresses;
import com.gyfty.events.GyftyEvent;
import com.gyfty.logistics.TimeSlot;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/19/15.
 */

@ParseClassName("Order")
public class Order extends ParseObject{

    public String getOrderId() {
        return getString(OrderParams.orderId.toString());
    }

    public void setOrderId(String value) {
        put(OrderParams.orderId.toString(),value);
    }

    public Schedule getSchedule() {
        return (Schedule) getParseObject(OrderParams.schedule.toString());
    }

    public void setSchedule(Schedule value) {
        put(OrderParams.schedule.toString(),value);
    }

    public DeliveryLogistics getDeliveryLogistics() {
        return (DeliveryLogistics) getParseObject(OrderParams.deliveryLogistics.toString());
    }

    public void setDeliveryLogistics(DeliveryLogistics value) {
        put(OrderParams.deliveryLogistics.toString(),value);
    }

    public GyftyEvent getEvent() {
        return (GyftyEvent) getParseObject(OrderParams.event.toString());
    }

    public void setEvent(GyftyEvent value) {
        put(OrderParams.event.toString(),value);
    }

    public PickUp getPickUp() {
        return (PickUp) getParseObject(OrderParams.pickUp.toString());
    }

    public void setPickUp(PickUp value) {
        put(OrderParams.pickUp.toString(),value);
    }


    public GyftyProductsGroup getProducts(){
        return (GyftyProductsGroup) getParseObject(OrderParams.orderedProducts.toString());
    }

    public void addProduct(GyftyProduct product) {
        GyftyProductsGroup productGrp = (GyftyProductsGroup) getParseObject(OrderParams.orderedProducts.toString());
        productGrp.addGyftyProductToGrp(product);
        //Remove after testing
        put(OrderParams.orderedProducts.toString(),productGrp);
    }

    public void setProductGroup(GyftyProductsGroup grpProducts){
        put(OrderParams.orderedProducts.toString(),grpProducts);
    }




    public enum OrderParams {

        orderId,
        schedule,
        deliveryLogistics,
        event,
        pickUp,
        orderedProducts,


    }


}
