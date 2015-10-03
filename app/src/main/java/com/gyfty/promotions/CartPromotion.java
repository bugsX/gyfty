package com.gyfty.promotions;

import com.gyfty.products.GyftyProduct;
import com.gyfty.cart.ProductPriceRow;
import com.gyfty.services.cart.Cart;

/**
 * Created by Mac on 9/21/15.
 */
public class CartPromotion extends PercentPromotion {

    public com.gyfty.services.cart.Cart.Cart getActor() {
        return (com.gyfty.services.cart.Cart.Cart)getParseObject(CartPromotionParams.actor.toString());
    }

    public void setActor(Cart.Cart value) {
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
