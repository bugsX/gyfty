package com.gyfty.products;

import com.google.common.collect.Lists;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by akhilch on 9/19/15.
 */

// GyftyProductsGroup table contains the different groups of products for each user and order

@ParseClassName("GyftyProductsGroup")
public class GyftyProductsGroup extends ParseObject{

    public List<GyftyProduct> getGyftyProductGroup() {
        List<GyftyProduct> products;
        products = getList(GyftyProductParams.productArray.toString());
        return products;
    }

    // setting a list of gyftyProducts to another group
    public void setGyftyProductGroup(List<GyftyProduct> products) {
        put(GyftyProductParams.productArray.toString(), products);
    }

    // adding an individual product to a group
    public void addGyftyProductToGrp(GyftyProduct p) {
        add(GyftyProductParams.productArray.toString(), p);
    }

    //removing a specific product from a gyftyproduct group
    public void removeGyftyProductsFromGrp(GyftyProduct product){
        List<GyftyProduct> list = Lists.newArrayList(product);
        removeAll(GyftyProductParams.productArray.toString(), list);
    }

    public enum GyftyProductParams {
        productArray
    }

}
