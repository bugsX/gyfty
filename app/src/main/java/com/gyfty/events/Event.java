package com.gyfty.events;

import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.users.GyftyUser;
import com.parse.ParseFile;

import java.util.Date;
import java.util.List;

/**
 * Created by Mac on 10/9/15.
 */
public interface Event {

    public String getName();

    public void setName(String value);

    public Date getDate();

    public void setDate(Date value);

    public ParseFile getEventImage();

    public void setEventImage(ParseFile value);

    public ParseFile getDeliveryImage();

    public void setDeliveryImage(ParseFile value);

    public String getReminder();

    public void setReminder(String value);

    public GyftyProductsGroup getProducts();

    public void addProduct(GyftyProduct product);

    public void setProductGroup(GyftyProductsGroup grpProducts);

    public String getNotes();

    public void setNotes(String value);


}
