package com.gyfty.users;

import com.gyfty.Images.Image;
import com.gyfty.order.OrderStatus;
import com.gyfty.support.Locale;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;

/**
 * Created by Mac on 9/22/15.
 */

// DeliveryMan Table stores the delivery boy info

@ParseClassName("DeliveryMan")
public class DeliveryMan extends GyftyUser {

    public Image getImage() {
        return (Image) getParseFile(DeliveryManParams.image.toString());
    }

    public void setImage(Image value) {
        put(DeliveryManParams.image.toString(),value);
    }

    public ParseGeoPoint getLocation() {
        return getParseGeoPoint(DeliveryManParams.location.toString());
    }

    public void setLocation(ParseGeoPoint value) {
        put(DeliveryManParams.location.toString(),value);
    }

    public Locale getLocale() {
        return (Locale) getParseObject(DeliveryManParams.locale.toString());
    }

    public void setLocale(Locale value) {
        put(DeliveryManParams.locale.toString(),value);
    }

    public OrderStatus getStatus() {
        return (OrderStatus)getParseObject(DeliveryManParams.status.toString());
    }

    public void setStatus(OrderStatus value) {
        put(DeliveryManParams.status.toString(),value);
    }



    public enum DeliveryManParams {

        image,
        location, // ParseGeoPoint (coordinates)
        locale, // city they are operating in
        status // OrderStatus (their current status)


    }

}
