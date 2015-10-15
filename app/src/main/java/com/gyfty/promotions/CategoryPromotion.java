package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.gyfty.category.Category;
import com.gyfty.products.GyftyProduct;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by akhich on 9/21/15.
 */

@ParseClassName("CategoryPromotion")
public class CategoryPromotion extends PercentPromotion {

    public Category getActor() {
        return (Category)getParseObject(CategoryPromotionParams.actor.toString());
    }

    public void setActor(Category value) {
        put(CategoryPromotionParams.actor.toString(), value);
    }

    @Override
    public boolean isApplicable(ParseObject appliedOn) {

        return ((GyftyProduct) appliedOn).getCategory().equals(getActor());
    }

    @Override
    public void setVendorPayment(ProductPriceRow row) {

    }

    @Override
    public void promotionUtilized() {
        //Used in User Promotions to decrement counter.
    }

    public enum CategoryPromotionParams {

        actor

    }

}
