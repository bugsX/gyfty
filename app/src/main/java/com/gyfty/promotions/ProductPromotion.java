package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.gyfty.products.GyftyProduct;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("ProductPromotion")
public class ProductPromotion extends PercentPromotion {
    @Override
    public void promotionUtilized() {
        //Used in User Promotions to decrement counter.
    }

    public GyftyProduct getActor() {
        return (GyftyProduct)getParseObject(ProductPromotionParams.actor.toString());
    }

    public void setActor(GyftyProduct value) {
        put(ProductPromotionParams.actor.toString(), value);
    }

    @Override
    public boolean isApplicable(ParseObject appliedOn) {
        return getIsActive() && getActor().getObjectId().equals(appliedOn.getObjectId());
    }

    @Override
    public void setVendorPayment(ProductPriceRow row) {

        //Default Vendor Payment

    }


    public enum ProductPromotionParams {

        actor

    }

}
