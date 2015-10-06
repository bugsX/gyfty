package com.gyfty.attributes;

import android.support.annotation.NonNull;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.security.auth.callback.Callback;

/**
 * Created by Mac on 10/4/15.
 */

@ParseClassName("GyftyAttributes")
public class GyftyAttributes extends ParseObject{

    public String getAttributeValue() {
        return getString(GyftyAttributesParams.attributeValue.toString());
    }

    public void setAttributeValue(String value) {
        put(GyftyAttributesParams.attributeValue.toString(),value);
    }

    public String getAttributeName() {
        return getString(GyftyAttributesParams.attributeName.toString());
    }

    public void setAttributeName(String value) {
        put(GyftyAttributesParams.attributeName.toString(),value);
    }


    enum GyftyAttributesParams {

        attributeValue,
        attributeName // Delivery Charge, Pin-code Checking

    }

    public static Map<String, String> attributeMap = new HashMap<String,String>();

    public static void loadAttributeMap() {
        ParseQuery<GyftyAttributes> attributesQuery = new ParseQuery("GyftyAttributes");
        attributesQuery.findInBackground(new FindCallback<GyftyAttributes>() {
            @Override
            public void done(List<GyftyAttributes> list, ParseException e) {

                if (e == null) {

                    for(GyftyAttributes attribute:list){

                        attributeMap.put(attribute.getAttributeName(),attribute.getAttributeValue());

                    }

                }

            }
        });



    }

}
