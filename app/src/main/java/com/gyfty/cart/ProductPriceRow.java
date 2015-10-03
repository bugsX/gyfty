package com.gyfty.cart;

import com.gyfty.products.GyftyProduct;

/**
 * Created by Mac on 9/27/15.
 */
public class ProductPriceRow {

    GyftyProduct product;
    double promotionDiscount;
    double commisionAmount;
    double vendorPayment;
    double priceAfterDiscount;
    String error;


    public GyftyProduct getProduct() {

        return product;

    }

    public void setProduct(GyftyProduct product) {

        this.product = product;

    }



    public double getPromotionDiscount() {

        return promotionDiscount;

    }

    public void setPromotionDiscount(double promotionDiscount){

        this.promotionDiscount = promotionDiscount;

    }

    public double getVendorPayment() {

        return vendorPayment;

    }

    public void setVendorPayment(double vendorPayment){

        this.vendorPayment = vendorPayment;

    }

    public double getPriceAfterDiscount() {

        return priceAfterDiscount;

    }

    public void setPriceAfterDiscount(double priceAfterDiscount){

        this.priceAfterDiscount = priceAfterDiscount;

    }

    public String getError() {

        return error;

    }

    public void setError(String error){

        this.error = error;

    }


}
