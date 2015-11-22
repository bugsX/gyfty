package com.gyfty.logistics;

import com.gyfty.support.Addresses;
import com.gyfty.users.DeliveryMan;
import com.gyfty.users.GyftyUser;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/26/15.
 */

// DeliveryLogistics table has the deliveryMan object and the admin responsible for that locale

@ParseClassName("DeliveryLogistics")
public class DeliveryLogistics extends ParseObject implements Logistics {


    @Override
    public DeliveryMan getDeliveryMan() {
        return (DeliveryMan) getParseObject(DeliveryLogisticsParams.deliveryMan.toString());
    }

    @Override
    public void setDeliveryMan(DeliveryMan value) {
        put(DeliveryLogisticsParams.deliveryMan.toString(),value);
    }

    @Override
    public GyftyUser getGyftyAdmin() {
        return (GyftyUser) getParseObject(DeliveryLogisticsParams.gyftyAdmin.toString());
    }

    @Override
    public void setGyftyAdmin(GyftyUser value) {
        put(DeliveryLogisticsParams.gyftyAdmin.toString(),value);
    }


    public enum DeliveryLogisticsParams {

        deliveryMan, // DeliveryMan
        gyftyAdmin // GyftyUser

    }
}