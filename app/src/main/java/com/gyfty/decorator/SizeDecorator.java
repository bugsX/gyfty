package com.gyfty.decorator;

import com.gyfty.products.CartGyftyProduct;

/**
 * Created by Mac on 10/13/15.
 */
public class SizeDecorator implements ProductDecorator {

    double size;

    public SizeDecorator(double size){
        this.size = size;
    }
    @Override
    public CartGyftyProduct getDecoratedProduct(CartGyftyProduct product) {
        CartGyftyProduct decoratedProduct = new CartGyftyProduct(product) {
            @Override
            public Double getPrice() throws Exception {
                return super.getPrice() * size;
            }

            @Override
            public String getSellerNotes() {
                return super.getSellerNotes() + " - Size" + size;
            }

        };
        return decoratedProduct;
    }
}
