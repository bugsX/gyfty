package com.gyfty.decorator;

import com.gyfty.products.CartGyftyProduct;

/**
 * Created by Mac on 10/13/15.
 */
public class QuantityDecorator implements ProductDecorator {

    int quantity;

    public QuantityDecorator(int quantity){
        this.quantity = quantity;
    }
    @Override
    public CartGyftyProduct getDecoratedProduct(CartGyftyProduct product) {
        CartGyftyProduct decoratedProduct = new CartGyftyProduct(product) {

            @Override
            public Double getPrice() throws Exception {
                return super.getPrice() * quantity;
            }

            @Override
            public String getSellerNotes() {
                return super.getSellerNotes() + " - Quantity" + quantity;
            }

        };
        return decoratedProduct;
    }
}