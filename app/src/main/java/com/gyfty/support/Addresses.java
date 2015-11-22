package com.gyfty.support;

import com.gyfty.attributes.GyftyAttributes;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/19/15.
 */

// Address table is the common Address class which stores the various addresses of the users and vendors

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

    public GyftyAttributes getArea() {
        return (GyftyAttributes)getParseObject(AddressesParams.area.toString());
    }

    public void setArea(GyftyAttributes value) {
        put(AddressesParams.area.toString(),value);
    }

    public String getPincode() {
        return getString(AddressesParams.pincode.toString());
    }

    public void setPincode(String value) {
        put(AddressesParams.pincode.toString(),value);
    }


    // Creates the address and returns it

    public Addresses createAddress(String name, String phoneNumber, String street, Locale locale, GyftyAttributes area, String pincode ){

        Addresses address = new Addresses();
        address.setName(name);
        address.setPhoneNumber(phoneNumber);
        address.setStreet(street);
        address.setLocale(locale);
        address.setArea(area);
        address.setPincode(pincode);
        address.saveInBackground();

        return address;
    }

    // Deletes the address from the table

    public void removeAddress(Addresses address){

        address.deleteEventually();

    }


    public enum AddressesParams{

        name,
        phoneNumber,
        street,
        area, // GyftyAttributes has an object for all the areas serviced
        locale, // Locale (city)
        pincode

    }


}
