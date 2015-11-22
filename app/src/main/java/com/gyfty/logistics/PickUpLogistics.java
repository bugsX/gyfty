package com.gyfty.logistics;

import com.gyfty.Images.Image;
import com.gyfty.support.Addresses;
import com.gyfty.users.DeliveryMan;
import com.gyfty.users.GyftyUser;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/26/15.
 */

// PickUp Logistics table has the same set of information as the Delivery Logistics table except an Image to specify the size of the Pickup.

@ParseClassName("PickUpLogistics")
public class PickUpLogistics extends ParseObject implements Logistics {


    public DeliveryMan getDeliveryMan() {
        return (DeliveryMan) getParseObject(PickUpLogisticsParams.deliveryMan.toString());
    }

    public void setDeliveryMan(DeliveryMan value) {
        put(PickUpLogisticsParams.deliveryMan.toString(),value);
    }


    public GyftyUser getGyftyAdmin() {
        return (GyftyUser) getParseObject(PickUpLogisticsParams.gyftyAdmin.toString());
    }

    public void setGyftyAdmin(GyftyUser value) {
        put(PickUpLogisticsParams.gyftyAdmin.toString(),value);
    }


    public Image getImage() {
        return (Image) getParseFile(PickUpLogisticsParams.image.toString());
    }


    public void setImage(Image value) {
        put(PickUpLogisticsParams.image.toString(),value);
    }

    public enum PickUpLogisticsParams {

        deliveryMan, // DeliveryMan
        gyftyAdmin, // GyftyUser
        image, //Pickup Product Photo

    }

}