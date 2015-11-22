package com.gyfty.products;

/**
 * Created by akhilch on 9/28/2015.
 */

// CartGyftyProduct is gyftyProduct in cart to get the Price and sellerNotes

public abstract class CartGyftyProduct extends GyftyProduct {

    private GyftyProduct product;

    public CartGyftyProduct(GyftyProduct product) {
        this.product = product;
    }

    public Double getPrice() throws Exception {
        return product.getPrice();
    }

    public String getSellerNotes() {
        return product.getName();
    }

}
