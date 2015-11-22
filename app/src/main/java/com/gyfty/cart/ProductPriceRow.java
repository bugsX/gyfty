package com.gyfty.cart;

import com.gyfty.products.CartGyftyProduct;
import com.gyfty.promotions.Promotion;
import com.gyfty.promotions.PromotionErrorCodes;

import lombok.Data;

/**
 * Created by akhilch on 9/27/15.
 */

// ProductPriceRow calculates the various amounts for a specific product in the cart

@Data
public class ProductPriceRow {

    private CartGyftyProduct product;
    private Double promotionDiscount;
    private Double commisionAmount;
    private Double vendorPayment;
    private Double priceAfterDiscount;
    private PromotionErrorCodes error;

    public ProductPriceRow(CartGyftyProduct product, Double promotionDiscount, Double commisionAmount, Double vendorPayment, Double priceAfterDiscount, PromotionErrorCodes error) {
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



    public Double getPromotionDiscount() {

        return promotionDiscount;

    }

    public void setPromotionDiscount(Double promotionDiscount){

        this.promotionDiscount = promotionDiscount;

    }

    public Double getCommisionAmount() {

        return commisionAmount;

    }

    public void setCommisionAmount(Double commisionAmount){

        this.commisionAmount = commisionAmount;

    }

    public Double getVendorPayment() {

        return vendorPayment;

    }

    public void setVendorPayment(Double vendorPayment){

        this.vendorPayment = vendorPayment;

    }

    public Double getPriceAfterDiscount() {

        return priceAfterDiscount;

    }

    public void setPriceAfterDiscount(Double priceAfterDiscount){

        this.priceAfterDiscount = priceAfterDiscount;

    }

    public PromotionErrorCodes getError() {

        return error;

    }

    public void setError(PromotionErrorCodes error){

        this.error = error;

    }


}
