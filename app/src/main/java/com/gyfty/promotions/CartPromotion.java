package com.gyfty.promotions;

import com.gyfty.cart.Cart;
import com.gyfty.cart.ProductPriceRow;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/21/15.
 */
@ParseClassName("CartPromotion")
public class CartPromotion extends PercentPromotion {

    public Cart getActor() {
        return (Cart)getParseObject(CartPromotionParams.actor.toString());
    }

    public void setActor(Cart value) {
        put(CartPromotionParams.actor.toString(), value);
    }

    public boolean isApplicable(ParseObject appliedOn) {
        return getIsActive();

    }

    @Override
    public void promotionUtilized() {
        //Used in User Promotions to decrement counter.
    }

    @Override
    public void setVendorPayment(ProductPriceRow row) {

    }


    public enum CartPromotionParams {

        actor

    }


}
