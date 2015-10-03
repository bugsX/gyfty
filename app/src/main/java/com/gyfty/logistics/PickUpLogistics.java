package com.gyfty.logistics;

import com.gyfty.support.Addresses;
import com.gyfty.users.DeliveryMan;
import com.gyfty.users.GyftyUser;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/26/15.
 */

@ParseClassName("PickUpLogistics")
public class PickUpLogistics extends ParseObject implements Logistics {


    @Override
    public DeliveryMan getDeliveryMan() {
        return (DeliveryMan) getParseObject(PickUpLogisticsParams.deliveryMan.toString());
    }

    @Override
    public void setDeliveryMan(DeliveryMan value) {
        put(PickUpLogisticsParams.deliveryMan.toString(),value);
    }

    @Override
    public Addresses getAddress() {
        return (Addresses) getParseObject(PickUpLogisticsParams.address.toString());
    }

    @Override
    public void setAddress(Addresses value) {
        put(PickUpLogisticsParams.address.toString(),value);
    }

    @Override
    public GyftyUser getGyftyAdmin() {
        return (GyftyUser) getParseObject(PickUpLogisticsParams.gyftyAdmin.toString());
    }

    @Override
    public void setGyftyAdmin(GyftyUser value) {
        put(PickUpLogisticsParams.gyftyAdmin.toString(),value);
    }


    public ParseFile getImage() {
        return getParseFile(PickUpLogisticsParams.image.toString());
    }


    public void setImage(ParseFile value) {
        put(PickUpLogisticsParams.image.toString(),value);
    }

    public enum PickUpLogisticsParams {

        deliveryMan,
        address,
        gyftyAdmin,
        image,

    }

}