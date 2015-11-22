package com.gyfty.users;

import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.parse.ParseException;
import com.parse.ParseQuery;


/**
 * Created by akhilch on 10/6/2015.
 */
public final class GyftyUserHelper{

    // Adding a Fav Product to a user

    public static void addFavoriteProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) {

        // creating a new group if none exists and pointing the user to that group

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

    // removing a favorite product from a group

    public static void removeFavoriteProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) {
        GyftyProductsGroup favoriteProducts = gyftyUser.getFavoriteProducts();
        favoriteProducts.removeGyftyProductsFromGrp(gyftyProduct);
        favoriteProducts.saveInBackground();
    }

    public static void addRecentProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) {

        // creating a new group if none exists and pointing the user to that group

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

    // creating a new group if none exists and pointing the user to that group

    public static void removeRecentProduct(GyftyUser gyftyUser, GyftyProduct gyftyProduct) {
        GyftyProductsGroup recentProducts = gyftyUser.getRecentProducts();
        recentProducts.removeGyftyProductsFromGrp(gyftyProduct);
        recentProducts.saveInBackground();

    }

    // returns User by UserID

    public static GyftyUser getUser(String userId) throws ParseException {
        ParseQuery<GyftyUser> query = ParseQuery.getQuery("GyftyUser");
        return query.get(userId);
    }

    // returns User by User object

    public static GyftyUser refreshUser(GyftyUser user) throws ParseException {
        return getUser(user.getObjectId());
    }
}
