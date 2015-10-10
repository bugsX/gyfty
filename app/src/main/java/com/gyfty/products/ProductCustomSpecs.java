package com.gyfty.products;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Mac on 9/23/15.
 */

@ParseClassName("ProductCustomSpecs")
public class ProductCustomSpecs extends ParseObject{


    public GyftyProduct getProduct() {
        return (GyftyProduct) getParseObject(ProductCustomSpecsParams.product.toString());
    }

    public void setProduct(GyftyProduct value) {
        put(ProductCustomSpecsParams.product.toString(),value);
    }

    public  Object getSpecValue() {
        return (Object) getParseObject(ProductCustomSpecsParams.specValueArray.toString());
    }

    public void setSpecValue(Object value) {
        put(ProductCustomSpecsParams.specValueArray.toString(),value);
    }

    public  String getSpecName() {
        return (String) getString(ProductCustomSpecsParams.specName.toString());
    }

    public void setSpecName(String value) {
        put(ProductCustomSpecsParams.specName.toString(),value);
    }


    public enum ProductCustomSpecsParams {

        product,
        specValueArray, // Array of Links
        specName

    }


}
