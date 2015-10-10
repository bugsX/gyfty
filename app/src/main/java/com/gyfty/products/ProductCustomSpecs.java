package com.gyfty.products;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by akhilch on 9/23/15.
 *
 * Store eggless sugarfree flavours weights other-decorators
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
        return getParseObject(ProductCustomSpecsParams.specValueArray.toString());
    }

    public void setSpecValue(Object value) {
        put(ProductCustomSpecsParams.specValueArray.toString(),value);
    }

    public  String getSpecName() {
        return getString(ProductCustomSpecsParams.specName.toString());
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
