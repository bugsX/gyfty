package com.gyfty.decorator;

import com.gyfty.products.CartGyftyProduct;

/**
 * Created by akhilch on 10/3/2015.
 */
public interface ProductDecorator {
    CartGyftyProduct getDecoratedProduct(CartGyftyProduct product);
}
