package com.gyfty.products;

/**
 * Created by akhilch on 9/28/2015.
 */

public abstract class CartGyftyProduct extends GyftyProduct {
    CartGyftyProduct product;

    public CartGyftyProduct(GyftyProduct product) {
        this.product = (CartGyftyProduct) product;
    }

    public double getPrice() throws Exception {
        return product.getPrice();
    }

    public String getSellerNotes() {
        return product.getName();
    }

}
