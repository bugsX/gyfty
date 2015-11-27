package com.gyfty.products;

import com.gyfty.vendor.Vendor;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 11/22/15.
 */
@ParseClassName("VendorCustomSpecs")
public class VendorCustomSpecs extends ParseObject {

    public Vendor getVendor() {
        return (Vendor) getParseObject(ProductCustomSpecsParams.vendor.toString());
    }

    public void setVendor(Vendor value) {
        put(ProductCustomSpecsParams.vendor.toString(),value);
    }

    public  Object getSpecValue() {
        return get(ProductCustomSpecsParams.specValue.toString());
    }

    public void setSpecValue(Object value) {
        put(ProductCustomSpecsParams.specValue.toString(), value);
    }

    public  String getSpecName() {
        return getString(ProductCustomSpecsParams.specName.toString());
    }

    public void setSpecName(String value) {
        put(ProductCustomSpecsParams.specName.toString(),value);
    }


    public enum ProductCustomSpecsParams {

        vendor,
        specValue, // Array of Decorators
        specName

    }


}
