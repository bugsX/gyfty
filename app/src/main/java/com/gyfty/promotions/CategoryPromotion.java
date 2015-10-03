package com.gyfty.promotions;

import com.gyfty.category.Category;
import com.parse.ParseClassName;

/**
 * Created by Mac on 9/21/15.
 */


@ParseClassName("CategoryPromotion")
public class CategoryPromotion extends PercentPromotion {

    public Category getActor() {
        return (Category)getParseObject(CategoryPromotionParams.actor.toString());
    }

    public void setActor(Category value) {
        put(CategoryPromotionParams.actor.toString(), value);
    }



    public enum CategoryPromotionParams {

        actor

    }

}
