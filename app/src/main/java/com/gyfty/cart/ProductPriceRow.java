package com.gyfty.cart;

import com.gyfty.products.CartGyftyProduct;

import lombok.Data;

/**
 * Created by akhilch on 9/27/15.
 */

@Data
public class ProductPriceRow {

    private CartGyftyProduct product;
    private double promotionDiscount;
    private double commisionAmount;
    private double vendorPayment;
    private double priceAfterDiscount;
    private String error;

    public ProductPriceRow(CartGyftyProduct product, double promotionDiscount, double commisionAmount, double vendorPayment, double priceAfterDiscount, String error) {
        this.product = product;
        this.promotionDiscount = promotionDiscount;
        this.commisionAmount = commisionAmount;
        this.vendorPayment = vendorPayment;
        this.priceAfterDiscount = priceAfterDiscount;
        this.error = error;
    }


    public CartGyftyProduct getProduct() {

        return product;

    }

    public void setProduct(CartGyftyProduct product) {

        this.product = product;

    }



    public double getPromotionDiscount() {

        return promotionDiscount;

    }

    public void setPromotionDiscount(double promotionDiscount){

        this.promotionDiscount = promotionDiscount;

    }

    public double getCommisionAmount() {

        return commisionAmount;

    }

    public void setCommisionAmount(double commisionAmount){

        this.commisionAmount = commisionAmount;

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
