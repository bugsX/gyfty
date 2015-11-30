package com.gyfty.attributes;

import android.util.Log;

import com.google.common.collect.Maps;
import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Mac on 10/4/15.
 */


// GyftyAttributes table stores the environmental variables in Gyfty.
// Variables : Minimin Dellivery Amount, Delivery Charge, area Checking

@ParseClassName("GyftyAttributes")
public class GyftyAttributes extends ParseObject{

    // attributeMap stores the GyftyAttributes table in the hashMap Locally
    public static Map<String, Object> attributeMap = Maps.newHashMap();

    /**
     * Updates all Gyfty attributes. (Environment Variables)
     */
    public static void updateAttributeMap() {
        ParseQuery<GyftyAttributes> attributesQuery = new ParseQuery<>("GyftyAttributes");
        attributesQuery.findInBackground(new FindCallback<GyftyAttributes>() {
            @Override
            public void done(List<GyftyAttributes> list, ParseException e) {
                if (e == null) {
                    for (GyftyAttributes attribute : list) {
                        attributeMap.put(attribute.getAttributeName(), attribute.getAttributeValue());
                    }
                } else {
                    Log.e(GyftyAttributes.DEFAULT_PIN, e.toString());
                }
            }
        });
    }

    /**
     * Load all Gyfty attributes. This method should be used when first loading the attributes.
     * Find is used here so that multiple threads don't cause synchronization issues and cause the
     * map to be accessed before it is initialized.
     */
    public static void loadAttributeMap() {
        ParseQuery<GyftyAttributes> attributesQuery = new ParseQuery<>("GyftyAttributes");
        try {
            List<GyftyAttributes> list = attributesQuery.find();
            for (GyftyAttributes attribute : list) {
                attributeMap.put(attribute.getAttributeName(), attribute.getAttributeValue());
            }
        } catch (ParseException e) {
            Log.e(GyftyAttributes.DEFAULT_PIN, e.toString());
        }
    }

    public Object getAttributeValue() {
        return get(GyftyAttributesParams.attributeValue.toString());
    }

    public void setAttributeValue(Object value) {
        put(GyftyAttributesParams.attributeValue.toString(), value);
    }

    public String getAttributeName() {
        return getString(GyftyAttributesParams.attributeName.toString());
    }

    // functions to store the environment variables Locally

    public void setAttributeName(String value) {
        put(GyftyAttributesParams.attributeName.toString(), value);
    }

    enum GyftyAttributesParams {

        attributeValue, // Value of the environment variable
        attributeName   // name of the environment variable

    }
}
