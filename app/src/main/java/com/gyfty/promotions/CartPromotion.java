package com.gyfty.promotions;

import com.gyfty.cart.Cart;
import com.gyfty.products.GyftyProduct;
import com.gyfty.cart.ProductPriceRow;

/**
 * Created by Mac on 9/21/15.
 */
public class CartPromotion extends PercentPromotion {

    public Cart getActor() {
        return (Cart)getParseObject(CartPromotionParams.actor.toString());
    }

    public void setActor(Cart value) {
        put(CartPromotionParams.actor.toString(), value);
    }

    public boolean isApplicable(GyftyProduct product) {
        return getIsActive();

    }

    @Override
    public void setVendorPayment(ProductPriceRow row) {

    }


    public enum CartPromotionParams {

        actor

    }


}
