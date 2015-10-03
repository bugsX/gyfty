package com.gyfty.promotions;

import com.gyfty.products.GyftyProduct;
import com.gyfty.cart.ProductPriceRow;
import com.parse.ParseClassName;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("ProductPromotion")
public class ProductPromotion extends PercentPromotion {

    public GyftyProduct getActor() {
        return (GyftyProduct)getParseObject(ProductPromotionParams.actor.toString());
    }

    public void setActor(GyftyProduct value) {
        put(ProductPromotionParams.actor.toString(), value);
    }

    @Override
    public boolean isApplicable(GyftyProduct product) {
       if(getIsActive() && getActor().getObjectId().equals(product.getObjectId())){

           return true;

       }
        return false;
    }

    @Override
    public void setVendorPayment(ProductPriceRow row) {

        //Default Vendor Payment

    }


    public enum ProductPromotionParams {

        actor

    }

}
