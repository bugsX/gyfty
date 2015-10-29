package com.gyfty.attributes;

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

@ParseClassName("GyftyAttributes")
public class GyftyAttributes extends ParseObject{

    public static Map<String, Object> attributeMap = Maps.newHashMap();

    public static void loadAttributeMap() {
        ParseQuery<GyftyAttributes> attributesQuery = new ParseQuery<>("GyftyAttributes");
        attributesQuery.findInBackground(new FindCallback<GyftyAttributes>() {
            @Override
            public void done(List<GyftyAttributes> list, ParseException e) {
                if (e == null) {
                    for (GyftyAttributes attribute : list) {
                        attributeMap.put(attribute.getAttributeName(), attribute.getAttributeValue());

                    }

                }

            }
        });


    }

    public Object getAttributeValue() {
        return get(GyftyAttributesParams.attributeValue.toString());
    }

    public void setAttributeValue(Object value) {
        put(GyftyAttributesParams.attributeValue.toString(),value);
    }

    public String getAttributeName() {
        return getString(GyftyAttributesParams.attributeName.toString());
    }

    public void setAttributeName(String value) {
        put(GyftyAttributesParams.attributeName.toString(), value);
    }

    enum GyftyAttributesParams {

        attributeValue,
        attributeName // Delivery Charge, Pin-code Checking

    }

}
