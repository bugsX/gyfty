package com.gyfty.promotions;

import com.gyfty.products.GyftyProduct;
import com.gyfty.cart.ProductPriceRow;
import com.gyfty.vendor.Vendor;
import com.parse.ParseClassName;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("VendorPromotion")
public class VendorPromotion extends PercentPromotion {


    public Vendor getActor() {
        return (Vendor)getParseObject(VendorPromotionParams.actor.toString());
    }

    public void setActor(Vendor value) {
        put(VendorPromotionParams.actor.toString(), value);
    }


    public boolean isApplicable(GyftyProduct product) {

        if (getIsActive() && getActor().getObjectId().equals(product.getObjectId())) {

            return true;
        }

        return false;

    }

    public void setVendorPayment(ProductPriceRow row) {

        row.setVendorPayment(row.getPriceAfterDiscount());

    }


    public enum VendorPromotionParams {

        actor

    }

}
