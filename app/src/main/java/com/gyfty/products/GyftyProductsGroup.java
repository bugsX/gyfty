package com.gyfty.products;

import com.google.common.collect.Lists;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONException;

import java.util.List;

/**
 * Created by akhilch on 9/19/15.
 */

@ParseClassName("GyftyProductsGroup")
public class GyftyProductsGroup extends ParseObject{

    public List<GyftyProduct> getGyftyProductGroup() throws JSONException {
        List<GyftyProduct> products;
        products = getList(GyftyProductParams.productArray.toString());
        return products;
    }

    public void setGyftyProductGroup(List<GyftyProduct> products) {
        put(GyftyProductParams.productArray.toString(), products);
    }

    public void addGyftyProductToGrp(GyftyProduct p) {
        add(GyftyProductParams.productArray.toString(), p);
    }

    public void removeGyftyProductsFromGrp(GyftyProduct product){
        List<GyftyProduct> list = Lists.newArrayList(product);
        removeAll(GyftyProductParams.productArray.toString(), list);
    }

    public enum GyftyProductParams {
        productArray
    }

}
