package com.gyfty.products;

import com.parse.ParseClassName;
import com.parse.ParseObject;

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

    public  String getSpecValue() {
        return (String) getString(ProductCustomSpecsParams.specValue.toString());
    }

    public void setSpecValue(String value) {
        put(ProductCustomSpecsParams.specValue.toString(),value);
    }

    public  String getSpecName() {
        return (String) getString(ProductCustomSpecsParams.specName.toString());
    }

    public void setSpecName(String value) {
        put(ProductCustomSpecsParams.specName.toString(),value);
    }


    public enum ProductCustomSpecsParams {

        product,
        specValue,
        specName

    }


}
