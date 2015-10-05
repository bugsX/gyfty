package com.gyfty.products;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac on 9/19/15.
 */

@ParseClassName("GyftyProductsGroup")
public class GyftyProductsGroup extends ParseObject{

    public List<GyftyProduct> getGyftyProductGroup() throws JSONException {
        List<GyftyProduct> products = new ArrayList();
        JSONArray productArray = getJSONArray(GyftyProductParams.productArray.toString());
        for (int i=0; i<productArray.length(); i++) {
            products.add((GyftyProduct) productArray.get(i));
        }
        return products;
    }

    public void addGyftyProductToGrp(GyftyProduct p) {
        add(GyftyProductParams.productArray.toString(),p);
    }

    public void setGyftyProductGroup(List<GyftyProduct> products){
        addAll(GyftyProductParams.productArray.toString(), products);
    }

    public void removeGyftyProductsFromGrp(GyftyProduct product) throws JSONException {

        List<GyftyProduct> list = this.getGyftyProductGroup();
        list.remove(product);

    }

    public enum GyftyProductParams {
        productArray
    }

}
