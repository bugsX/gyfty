package com.gyfty.users;

import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.support.Addresses;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Date;

/**
 * Created by Mac on 9/19/15.
 */

// GyftyUser Table stores the User info

@ParseClassName("GyftyUser")
public class GyftyUser extends ParseObject {

    public ParseFile getImage() {
        return getParseFile(GyftyUserParams.image.toString());
    }

    public void setImage(ParseFile value) {
        put(GyftyUserParams.image.toString(), value);
    }

    public String getDeviceId() {
        return getString(GyftyUserParams.deviceId.toString());
    }

    public void setDevideId(String value) {
        put(GyftyUserParams.deviceId.toString(), value);
    }

    public String getPhoneNumber() {
        return getString(GyftyUserParams.phoneNumber.toString());
    }

    public void setPhoneNumber(String value) {
        put(GyftyUserParams.phoneNumber.toString(), value);
    }

    public String getFacebookId() {
        return getString(GyftyUserParams.facebookId.toString());
    }

    public void setFacebookId(String value) {
        put(GyftyUserParams.facebookId.toString(), value);
    }

    public Addresses getAddress() {
        return (Addresses) getParseObject(GyftyUserParams.address.toString());
    }

    public void setAddress(Addresses value) {
        put(GyftyUserParams.address.toString(), value);
    }

    public String getNotificationType() {
        return getString(GyftyUserParams.notificationType.toString());
    }

    public void setNotificationType(String value) {
        put(GyftyUserParams.notificationType.toString(), value);
    }

    public String getCurrency() {
        return getString(GyftyUserParams.currency.toString());
    }

    public void setCurrency(String value) {
        put(GyftyUserParams.currency.toString(), value);
    }

    public String getPromoCode() {
        return getString(GyftyUserParams.promoCode.toString());
    }

    public void setPromoCode(String value) {
        put(GyftyUserParams.promoCode.toString(), value);
    }

    public GyftyProductsGroup getFavoriteProducts() {
        return (GyftyProductsGroup) getParseObject(GyftyUserParams.favoriteProducts.toString());
    }

    public void setFavoriteProducts(GyftyProductsGroup value) {
        put(GyftyUserParams.favoriteProducts.toString(), value);
    }

    public GyftyProductsGroup getRecentProducts() {
        return (GyftyProductsGroup) getParseObject(GyftyUserParams.recentProducts.toString());
    }

    public void setRecentProducts(GyftyProductsGroup value) {
        put(GyftyUserParams.recentProducts.toString(), value);
    }

    public String getOTP() {
        return getString(GyftyUserParams.otp.toString());
    }

    public void setOTP(String value) {
        put(GyftyUserParams.otp.toString(), value);
    }

    public String getEmailAddress() {
        return getString(GyftyUserParams.emailAddress.toString());
    }

    public void setEmailAddress(String value) {
        put(GyftyUserParams.emailAddress.toString(), value);
    }

    public String getName() {
        return getString(GyftyUserParams.name.toString());
    }

    public void setName(String value) {
        put(GyftyUserParams.name.toString(), value);
    }

    public Date getBirthday() {
        return getDate(GyftyUserParams.birthday.toString());
    }

    public void setBirthday(Date value) {
        put(GyftyUserParams.birthday.toString(), value);
    }

    public enum GyftyUserParams {

        deviceId,
        phoneNumber,
        image,
        facebookId,
        address, // Addresses
        notificationType,
        currency,
        promoCode,
        favoriteProducts, // GyftyProductsGroup
        recentProducts, // GyftyProductsGroup
        otp,
        emailAddress,
        name,
        birthday


    }

}
