package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.gyfty.users.GyftyUser;
import com.parse.ParseObject;

/**
 * Created by akhilch on 10/14/2015.
 */
public class InvitationPromotion extends UserPromotion {
    @Override
    public boolean isApplicable(ParseObject appliedOn) {
        return !(((GyftyUser) appliedOn).isNewUserPromotionUsed());
    }


    @Override
    public void setVendorPayment(ProductPriceRow row) {
        //Default Value set
    }

    @Override
    public void promotionUtilized() {
        //TODO: Increment the UserPromotions
    }
}
