package com.gyfty.logistics;

import com.gyfty.support.Addresses;
import com.gyfty.users.DeliveryMan;
import com.gyfty.users.GyftyUser;

/**
 * Created by Mac on 9/26/15.
 */
public interface Logistics {

    public DeliveryMan getDeliveryMan();

    public void setDeliveryMan(DeliveryMan value);

    public Addresses getAddress();

    public void setAddress(Addresses value);

    public GyftyUser getGyftyAdmin();

    public void setGyftyAdmin(GyftyUser value);



}
