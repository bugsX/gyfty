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
 * Created by Mac on 10/9/15.
 */

// GyftyEvent table lists the common events listed by gyfty

@ParseClassName("GyftyEvent")
public class GyftyEvent extends ParseObject implements Event{


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


    public enum GyftyEventParams {

        name,
        date,
        eventImage,
        reminder,
        gyftyProducts, //GyftyProductsGroup
        notes,

    }

    // Get all GyftyUserEvents

    public static List<GyftyEvent> getAllGyftyEvents(){

        final List<GyftyEvent> gyftyEvents = Lists.newArrayList();

        ParseQuery<GyftyEvent> eventQuery = ParseQuery.getQuery("GyftyEvent");
        eventQuery.findInBackground(new FindCallback<GyftyEvent>() {
            @Override
            public void done(List<GyftyEvent> eventlist, ParseException e) {
                if(e == null ) {
                    gyftyEvents.addAll(eventlist);
                }
            }

        });
        return gyftyEvents;
    }

    // create and return GyftyUserEvents

    public static GyftyEvent createGyftyEvent(String name, Date date, Image eventImage, String reminder, String notes){

        GyftyEvent gyftyEvent = new GyftyEvent();
        gyftyEvent.setName(name);
        gyftyEvent.setDate(date);
        gyftyEvent.setEventImage(eventImage);
        gyftyEvent.setReminder(reminder);
        gyftyEvent.setNotes(notes);
        gyftyEvent.saveInBackground();

        return gyftyEvent;


    }

    // Delete GyftyUserEvent from Table

    public static void removeGyftyEvent(GyftyEvent gyftyEvent){

        gyftyEvent.deleteInBackground();


    }



}
