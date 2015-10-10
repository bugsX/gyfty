package com.gyfty.order;

import com.gyfty.events.Event;
import com.gyfty.logistics.DeliveryLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.support.Addresses;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.List;

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


    public Addresses getAddress() {
        return (Addresses) getParseObject(OrderParams.address.toString());
    }


    public void setAddress(Addresses value) {
        put(OrderParams.address.toString(),value);
    }

    public Event getEvent() {
        return (Event) getParseObject(OrderParams.event.toString());
    }

    public void setEvent(Event value) {
        put(OrderParams.event.toString(),value);
    }

    public PickUp getPickUp() {
        return (PickUp) getParseObject(OrderParams.pickUp.toString());
    }

    public void setPickUp(PickUp value) {
        put(OrderParams.pickUp.toString(),value);
    }

    public OrderStatus getOrderStatus() {
        return (OrderStatus) getParseObject(OrderParams.orderStatus.toString());
    }

    public void setOrderStatus(OrderStatus value) {
        put(OrderParams.orderStatus.toString(),value);
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

    public List<String> getTransactionIds() {
        List<String> transactionIds;
        transactionIds = getList(OrderParams.transactionIds.toString());
        return transactionIds;
    }

    public void addTransactionIdToOrder(String transactionId, Order order) {
        order.add(OrderParams.transactionIds.toString(), transactionId);

    }

    public ParseFile getSurpriseImage() {
        return getParseFile(OrderParams.SupriseImage.toString());
    }


    public void setSurpriseImage(ParseFile value) {
        put(OrderParams.SupriseImage.toString(), value);
    }

    public void addPickUpToOrder(Order order, PickUp pickUp) {

        order.setPickUp(pickUp);
        order.saveEventually();

    }

    public void removePickUpFromOrder(Order order) {

        order.setPickUp(null);
        order.saveEventually();

    }

    public void addDeliveryLogisticsToOrder(Order order, DeliveryLogistics deliveryLogistics) {

        order.setDeliveryLogistics(deliveryLogistics);
        order.saveEventually();

    }

    public void removeDeliveryLogisticsFromOrder(Order order) {

        order.setDeliveryLogistics(null);
        order.saveEventually();

    }

    public void addOrderStatusToOrder(Order order, OrderStatus orderStatus) {

        order.setOrderStatus(orderStatus);
        order.saveEventually();

    }

    public void removeOrderStatusFromOrder(Order order) {

        order.setOrderStatus(null);
        order.saveEventually();

    }

    public void cancelOrder(Order order, OrderStatus orderStatus) {

        order.setOrderStatus(orderStatus);
        order.setDeliveryLogistics(null);
        order.saveEventually();

    }

    public enum OrderParams {

        orderId,
        schedule,
        deliveryLogistics,
        address,
        event,
        pickUp,
        orderedProducts,
        orderStatus,
        transactionIds,
        SupriseImage


    }





}

