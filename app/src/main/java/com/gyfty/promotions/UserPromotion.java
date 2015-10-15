package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.gyfty.users.GyftyUser;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by akhilch on 10/14/2015.
 * <p/>
 * User Promotions will contain invitaional promocodes
 * Table Structure
 * Actor - User
 * count - number of promotions applicable.
 * (For examplle if 123 sends invitaion to two people, and both use the promocode in the app then the count for 123 is 2.
 * That is number of promotions he is elligible for.)
 */
@ParseClassName("UserPromotions")
public class UserPromotion extends PercentPromotion {
    @Override
    public boolean isApplicable(ParseObject appliedOn) {
        return checkPromoCountAvalability() && getPromoCode().equals(((GyftyUser) appliedOn).getPhoneNumber());
    }

    @Override
    public void setVendorPayment(ProductPriceRow row) {
        //Default Payment
    }

    public boolean checkPromoCountAvalability() {
        return getPromoCount() > 0;
    }

    @Override
    public void promotionUtilized() {
        decrementPromoCode();
    }

    public GyftyUser getActor() {
        return (GyftyUser) getParseObject(UserPromotionParams.actor.toString());
    }

    public void setActor(GyftyUser user) {
        put(UserPromotionParams.actor.toString(), user);
    }

    public int getPromoCount() {
        return (int) getNumber(UserPromotionParams.promoCount.toString());
    }

    public void setPromoCount(int count) {
        put(UserPromotionParams.promoCount.toString(), count);
    }

    public void incrementPromoCount() {
        this.increment(UserPromotionParams.promoCount.toString());
        this.saveInBackground();
    }

    public void decrementPromoCode() {
        //TODO:Checck if decrement present.
        this.increment(UserPromotionParams.promoCount.toString(), -1);
        this.saveInBackground();

    }

    public enum UserPromotionParams {
        actor,
        promoCount
    }
}
