package com.gyfty.events;

import com.google.common.collect.Lists;
import com.gyfty.Images.Image;
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

// GyftyUserEvent Table lists the events created by the user on gyfty

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

    public Image getEventImage() {
        return (Image) getParseFile(GyftyEventParams.eventImage.toString());
    }

    public void setEventImage(Image value) {
        put(GyftyEventParams.eventImage.toString(),value);
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

    public void setProductGroup(GyftyProductsGroup grpProducts){
        put(GyftyEventParams.gyftyProducts.toString(), grpProducts);
    }

    public void addProduct(GyftyProduct product) {
        GyftyProductsGroup productGrp = getProducts();
        productGrp.addGyftyProductToGrp(product);
        //Remove after testing
        setProductGroup(productGrp);
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
        reminder, // sameday, 3days, week before, none
        gyftyProducts, // GyftyProductsGroup
        notes,
        user // GyftyUser

    }

    // Get GyftyUserEvents by User

    public static List<GyftyUserEvent> getAllGyftyUserEvents(GyftyUser user){

        final List<GyftyUserEvent> gyftyUserEvents = Lists.newArrayList();

        ParseQuery<GyftyUserEvent> eventQuery = ParseQuery.getQuery("GyftyUserEvent");
//        eventQuery.whereEqualTo("user", user );
        eventQuery.findInBackground(new FindCallback<GyftyUserEvent>() {
            @Override
            public void done(List<GyftyUserEvent> eventlist, ParseException e) {
                if(e == null ) {
                    gyftyUserEvents.addAll(eventlist);
                }
            }

        });
        return gyftyUserEvents;
    }

    // create and return GyftyUserEvents

    public static GyftyUserEvent createGyftyUserEvent(String name, Date date, Image eventImage, String reminder, String notes, GyftyUser user){

        GyftyUserEvent gyftyUserEvent = new GyftyUserEvent();
        gyftyUserEvent.setName(name);
        gyftyUserEvent.setDate(date);
        gyftyUserEvent.setEventImage(eventImage);
        gyftyUserEvent.setReminder(reminder);
        gyftyUserEvent.setNotes(notes);
        gyftyUserEvent.setUser(user);
        gyftyUserEvent.saveInBackground();

        return gyftyUserEvent;


    }

    // Delete GyftyUserEvent from Table

    public static void removeGyftyUserEvent(GyftyUserEvent gyftyUserEvent){

        gyftyUserEvent.deleteInBackground();

    }

}