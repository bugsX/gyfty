package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.gyfty.category.Category;
import com.gyfty.products.GyftyProduct;
import com.parse.ParseClassName;

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
    public boolean isApplicable(GyftyProduct product) {
        return false;
    }

    @Override
    public void setVendorPayment(ProductPriceRow row) {

    }


    public enum CategoryPromotionParams {

        actor

    }

}
