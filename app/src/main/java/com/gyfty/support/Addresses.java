package com.gyfty.support;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/19/15.
 */

@ParseClassName("Address")
public class Addresses extends ParseObject {

    public String getName() {
        return getString(AddressesParams.name.toString());
    }

    public void setName(String value) {
        put(AddressesParams.name.toString(),value);
    }



    public String getPhoneNumber() {
        return getString(AddressesParams.phoneNumber.toString());
    }

    public void setPhoneNumber(String value) {
        put(AddressesParams.phoneNumber.toString(),value);
    }



    public String getStreet() {
        return getString(AddressesParams.street.toString());
    }

    public void setStreet(String value) {
        put(AddressesParams.street.toString(),value);
    }



    public Locale getLocale() {
        return (Locale) getParseObject(AddressesParams.locale.toString());
    }

    public void setLocale(Locale value) {
        put(AddressesParams.locale.toString(),value);
    }



    public String getPincode() {
        return getString(AddressesParams.pincode.toString());
    }

    public void setPincode(String value) {
        put(AddressesParams.pincode.toString(),value);
    }




    public enum AddressesParams{

        name,
        phoneNumber,
        street,
        locale,
        pincode

    }


}
