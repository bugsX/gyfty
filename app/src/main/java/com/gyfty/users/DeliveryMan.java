package com.gyfty.users;

import com.gyfty.support.Locale;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;

/**
 * Created by Mac on 9/22/15.
 */

@ParseClassName("DeliveryMan")
public class DeliveryMan extends GyftyUser {

    public ParseFile getImage() {
        return getParseFile(DeliveryManParams.image.toString());
    }

    public void setImage(ParseFile value) {
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

    public String getStatus() {
        return getString(DeliveryManParams.status.toString());
    }

    public void setStatus(String value) {
        put(DeliveryManParams.status.toString(),value);
    }



    public enum DeliveryManParams {

        image,
        location,
        locale,
        status


    }

}
