package com.gyfty.products;

/**
 * Created by akhilch on 9/28/2015.
 */

// CartGyftyProduct is gyftyProduct in cart to get the Price and sellerNotes

public abstract class CartGyftyProduct {

    private GyftyProduct product;
    private CartGyftyProduct cartGyftyProduct;

    public CartGyftyProduct(GyftyProduct product) {
        this.product = product;
    }

    public CartGyftyProduct(CartGyftyProduct cartGyftyProduct) {
        this.cartGyftyProduct = cartGyftyProduct;
        this.product = cartGyftyProduct.getGyftyProduct();
    }

    public Double getPrice() throws Exception {
        if (null == cartGyftyProduct) {
            return product.getPrice();
        } else {
            return cartGyftyProduct.getPrice();
        }
    }

    public String getSellerNotes() {
        if (null == cartGyftyProduct) {
            return product.getName();
        } else {
            return cartGyftyProduct.getSellerNotes();
        }
    }

    public GyftyProduct getGyftyProduct() {
        return product;
    }
}
