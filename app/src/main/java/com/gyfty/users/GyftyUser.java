package com.gyfty.users;

import com.gyfty.support.Addresses;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseUser;

/**
 * Created by Mac on 9/19/15.
 */
@ParseClassName("User")
public class GyftyUser extends ParseUser {

    public ParseFile getImage() {
        return getParseFile(GyftyUserParams.image.toString());
    }

    public void setImage(ParseFile value) {
        put(GyftyUserParams.image.toString(),value);
    }

    public String getDeviceId() {
        return getString(GyftyUserParams.deviceId.toString());
    }

    public void setDevideId(String value) {
        put(GyftyUserParams.deviceId.toString(),value);
    }

    public String getPhoneNumber() {
        return getString(GyftyUserParams.phoneNumber.toString());
    }

    public void setPhoneNumber(String value) {
        put(GyftyUserParams.phoneNumber.toString(),value);
    }

    public String getFacebookId() {
        return getString(GyftyUserParams.facebookId.toString());
    }

    public void setFacebookId(String value) {
        put(GyftyUserParams.facebookId.toString(),value);
    }

    public Addresses getAddress() {
        return (Addresses)getParseObject(GyftyUserParams.address.toString());
    }

    public void setAddress(Addresses value) {
        put(GyftyUserParams.address.toString(),value);
    }

    public String getNotificationType() {
        return getString(GyftyUserParams.notificationType.toString());
    }

    public void setNotificationType(String value) {
        put(GyftyUserParams.notificationType.toString(),value);
    }

    public String getCurrency() {
        return getString(GyftyUserParams.currency.toString());
    }

    public void setCurrency(String value) {
        put(GyftyUserParams.currency.toString(),value);
    }

    public String getPromoCode() {
        return getString(GyftyUserParams.promoCode.toString());
    }

    public void setPromoCode(String value) {
        put(GyftyUserParams.promoCode.toString(),value);
    }



    public enum GyftyUserParams {

        deviceId,
        phoneNumber,
        image,
        facebookId,
        address,
        notificationType,
        currency,
        promoCode


    }

}
