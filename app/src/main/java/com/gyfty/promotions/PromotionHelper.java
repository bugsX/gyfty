package com.gyfty.promotions;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Promotion Helper class.
 * Used to retrieve a promotion based on promo code.
 *
 * Created by akhilch on 10/14/2015.
 */
public class PromotionHelper {

    /**
     * Query Objects of tables that can contain promotions.
     * If a new promotion is added a query object should be added for the corresponding promotion.
     */
    private static final ParseQuery<UserPromotion> userPromotionQuery = ParseQuery.getQuery("UserPromotion");
    private static final ParseQuery<CartPromotion> cartPromotionQuery = ParseQuery.getQuery("CartPromotion");
    private static final ParseQuery<CategoryPromotion> cartegoryPromotionQuery = ParseQuery.getQuery("CategoryPromotion");
    private static final ParseQuery<ProductPromotion> productPromotionQuery = ParseQuery.getQuery("ProductPromotion");
    private static final ParseQuery<VendorPromotion> vendorPromotionQuery = ParseQuery.getQuery("VendorPromotion");
    private static final ParseQuery<ValuePromotion> valuePromotionQuery = ParseQuery.getQuery("ValuePromotion");
    private static List<ParseQuery<?>> queryList = new ArrayList<>();

    static {
        queryList.add(userPromotionQuery);
        queryList.add(cartPromotionQuery);
        queryList.add(cartegoryPromotionQuery);
        queryList.add(productPromotionQuery);
        queryList.add(vendorPromotionQuery);
        queryList.add(valuePromotionQuery);
    }

    /**
     * Get a User promotion based on promotion code.
     *
     * @param promoCode promotion Code
     * @return UserPromotion.
     */
    public static UserPromotion getUserPromotion(String promoCode) {
        userPromotionQuery.whereEqualTo("promoCode", promoCode);
        try {
            return userPromotionQuery.getFirst();
        } catch (ParseException e) {
            Log.e("[Params] promocode: " + promoCode, "getUserPromotion ", e);
            return null;
        }
    }

    /**
     * Returns a promotion based on promoCode.
     * Queries all the promotion tables and tries to retrieve a promotion.
     *
     * @param promoCode promotion Code
     * @return Promotion
     */
    public static Promotion getPromotion(String promoCode) {
        ParseObject result;
        for (ParseQuery<?> query : queryList) {
            userPromotionQuery.whereEqualTo("promoCode", promoCode);
            try {
                result = query.getFirst();
                if (result != null) {
                    return (Promotion) result;
                }
            } catch (ParseException e) {
                Log.e("[Params] promocode:" + promoCode, "getPromotion", e);
            }
        }
        return null;
    }
}
