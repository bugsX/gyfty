package com.gyfty.events;

import com.google.common.collect.Lists;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.users.GyftyUser;
import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;
import java.util.List;

/**
 * Created by Mac on 9/19/15.
 */

@ParseClassName("GyftyUserEvent")
public class GyftyUserEvent extends ParseObject implements Event {

    public String getName() {
        return getString(GyftyEventParams.name.toString());
    }

    public void setName(String value) {
        put(GyftyEventParams.name.toString(),value);
    }

    public Date getDate() {
        return getDate(GyftyEventParams.date.toString());
    }

    public void setDate(Date value) {
        put(GyftyEventParams.date.toString(),value);
    }

    public ParseFile getEventImage() {
        return getParseFile(GyftyEventParams.eventImage.toString());
    }

    public void setEventImage(ParseFile value) {
        put(GyftyEventParams.eventImage.toString(),value);
    }

    public ParseFile getDeliveryImage() {
        return getParseFile(GyftyEventParams.deliveryImage.toString());
    }

    public void setDeliveryImage(ParseFile value) {
        put(GyftyEventParams.deliveryImage.toString(),value);
    }

    public String getReminder() {
        return getString(GyftyEventParams.reminder.toString());
    }

    public void setReminder(String value) {
        put(GyftyEventParams.reminder.toString(),value);
    }


    public GyftyProductsGroup getProducts(){
        return (GyftyProductsGroup) getParseObject(GyftyEventParams.gyftyProducts.toString());
    }

    public void addProduct(GyftyProduct product) {
        GyftyProductsGroup productGrp = (GyftyProductsGroup) getParseObject(GyftyEventParams.gyftyProducts.toString());
        productGrp.addGyftyProductToGrp(product);
        //Remove after testing
        put(GyftyEventParams.gyftyProducts.toString(),productGrp);
    }

    public void setProductGroup(GyftyProductsGroup grpProducts){
        put(GyftyEventParams.gyftyProducts.toString(), grpProducts);
    }

    public String getNotes() {
        return getString(GyftyEventParams.notes.toString());
    }

    public void setNotes(String value) {
        put(GyftyEventParams.notes.toString(),value);
    }

    public GyftyUser getUser() {
        return (GyftyUser) getParseObject(GyftyEventParams.user.toString());
    }

    public void setUser(GyftyUser value) {
        put(GyftyEventParams.user.toString(),value);
    }


    public enum GyftyEventParams {

        name,
        date,
        eventImage,
        deliveryImage,
        reminder,
        gyftyProducts,
        notes,
        user

    }

    public List<GyftyUserEvent> getAllGyftyEvents(GyftyUser user){

        final List<GyftyUserEvent> gyftyEvents = Lists.newArrayList();

        ParseQuery<GyftyUserEvent> eventQuery = ParseQuery.getQuery("GyftyUserEvent");
        eventQuery.whereEqualTo("objectId", user.getObjectId());
        eventQuery.findInBackground(new FindCallback<GyftyUserEvent>() {
            @Override
            public void done(List<GyftyUserEvent> eventlist, ParseException e) {
                if(e == null ) {
                    gyftyEvents.addAll(eventlist);
                }
            }

        });
        return gyftyEvents;
    }


    public GyftyUserEvent createGyftyEvent(String name, Date date, ParseFile eventImage, String reminder, String notes, GyftyUser user){

        GyftyUserEvent gyftyEvent = new GyftyUserEvent();
        gyftyEvent.setName(name);
        gyftyEvent.setDate(date);
        gyftyEvent.setEventImage(eventImage);
        gyftyEvent.setReminder(reminder);
        gyftyEvent.setNotes(notes);
        gyftyEvent.setUser(user);
        gyftyEvent.saveInBackground();

        return gyftyEvent;


    }

    public void removeGyftyEvent(GyftyUserEvent gyftyEvent){

        gyftyEvent.deleteInBackground();


    }


}