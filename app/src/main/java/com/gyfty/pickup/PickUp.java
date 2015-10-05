package com.gyfty.pickup;

import com.gyfty.order.Order;
import com.gyfty.logistics.PickUpLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.cart.Cart;
import com.gyfty.order.OrderStatus;
import com.gyfty.support.Addresses;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("PickUp")
public class PickUp extends ParseObject {


    public PickUpLogistics getPickUpLogistics() {
        return (PickUpLogistics)getParseObject(PickUpParams.pickUpLogistics.toString());
    }

    public void setPickUpLogistics(PickUpLogistics value) {
        put(PickUpParams.pickUpLogistics.toString(),value);
    }

    public Addresses getAddress() {
        return (Addresses) getParseObject(PickUpParams.address.toString());
    }

    public void setAddress(Addresses value) {
        put(PickUpParams.address.toString(),value);
    }

    public Schedule getSchedule() {
        return (Schedule)getParseObject(PickUpParams.schedule.toString());
    }

    public void setSchedule(Schedule value) {
        put(PickUpParams.schedule.toString(),value);
    }

    public OrderStatus getPickUpStatus() {
        return (OrderStatus)getParseObject(PickUpParams.pickUpStatus.toString());
    }

    public void setPickUpStatus(OrderStatus value) {
        put(PickUpParams.pickUpStatus.toString(),value);
    }




    public enum PickUpParams{

        pickUpLogistics,
        address, // Address
        schedule, //Schedule
        pickUpStatus
    }



    public PickUp createPickUp(PickUpLogistics pickUpLogistics, Addresses address, Schedule schedule, OrderStatus pickUpStatus) {

        PickUp pickUp = new PickUp();
        pickUp.setPickUpLogistics(pickUpLogistics);
        pickUp.setAddress(address);
        pickUp.setSchedule(schedule);
        pickUp.setPickUpStatus(pickUpStatus);
        pickUp.saveInBackground();

        return pickUp;

    }

    public void cancelPickUp(PickUp pickup, OrderStatus orderStatus) {

        pickup.setPickUpStatus(orderStatus);
        if (pickup.getPickUpLogistics() != null){
            pickup.getPickUpLogistics().deleteInBackground();
        }
        pickup.saveInBackground();
    }


}
