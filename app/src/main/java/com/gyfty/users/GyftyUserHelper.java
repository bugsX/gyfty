package com.gyfty.users;

import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.json.JSONException;

/**
 * Created by akhilch on 10/6/2015.
 */
public final class GyftyUserHelper {

    public static void addFavoriteProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) {
        if (gyftyUser.getFavoriteProducts() == null) {
            GyftyProductsGroup favoriteProducts = new GyftyProductsGroup();
            favoriteProducts.addGyftyProductToGrp(gyftyProduct);
            favoriteProducts.saveInBackground();
            gyftyUser.setFavoriteProducts(favoriteProducts);
            gyftyUser.saveInBackground();
        } else {
            GyftyProductsGroup favoriteProducts = gyftyUser.getFavoriteProducts();
            favoriteProducts.addGyftyProductToGrp(gyftyProduct);
            favoriteProducts.saveInBackground();
        }
    }

    public static void removeFavoriteProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) throws JSONException {
        GyftyProductsGroup favoriteProducts = gyftyUser.getFavoriteProducts();
        favoriteProducts.removeGyftyProductsFromGrp(gyftyProduct);
        favoriteProducts.saveInBackground();
    }

    public static void addRecentProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) {
        if (gyftyUser.getRecentProducts() == null) {
            GyftyProductsGroup recentProducts = new GyftyProductsGroup();
            recentProducts.addGyftyProductToGrp(gyftyProduct);
            recentProducts.saveInBackground();
            gyftyUser.setRecentProducts(recentProducts);
            gyftyUser.saveInBackground();
        } else {
            GyftyProductsGroup recentProducts = gyftyUser.getRecentProducts();
            recentProducts.addGyftyProductToGrp(gyftyProduct);
            recentProducts.saveInBackground();
        }
    }

    public static void removeRecentProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) throws JSONException {
        GyftyProductsGroup recentProducts = gyftyUser.getRecentProducts();
        recentProducts.removeGyftyProductsFromGrp(gyftyProduct);
        recentProducts.saveInBackground();

    }

    public static GyftyUser getUser(String userId) throws ParseException {
        ParseQuery<GyftyUser> query = ParseQuery.getQuery("GyftyUser");
        return query.get(userId);
    }

    public static GyftyUser refreshUser(GyftyUser user) throws ParseException {
        return getUser(user.getObjectId());
    }
}
