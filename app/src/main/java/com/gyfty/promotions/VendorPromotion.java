package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.gyfty.vendor.Vendor;
import com.parse.ParseClassName;
import com.parse.ParseObject;

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


    public boolean isApplicable(ParseObject appliedOn) {

        return getIsActive() && getActor().getObjectId().equals(appliedOn.getObjectId());

    }

    public void setVendorPayment(ProductPriceRow row) {

        row.setVendorPayment(row.getPriceAfterDiscount());

    }

    @Override
    public void promotionUtilized() {
        //Used in User Promotions to decrement counter.
    }


    public enum VendorPromotionParams {

        actor

    }

}
