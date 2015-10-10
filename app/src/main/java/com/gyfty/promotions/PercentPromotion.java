package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Mac on 9/21/15.
 */
public  abstract class PercentPromotion extends ParseObject implements Promotion {


    public String getPromoType() {
        return getString(PercentPromotionParams.promoType.toString());
    }

    public void setPromoType(String value) {
        put(PercentPromotionParams.promoType.toString(), value);
    }

    public String getPromoCode() {
        return getString(PercentPromotionParams.promoCode.toString());
    }

    public void setPromoCode(String value) {
        put(PercentPromotionParams.promoCode.toString(), value);
    }

    public Date getFromDate() {
        return getDate(PercentPromotionParams.fromDate.toString());
    }

    public void setFromDate(Date value) {
        put(PercentPromotionParams.fromDate.toString(), value);
    }

    public Date getToDate() {
        return getDate(PercentPromotionParams.toDate.toString());
    }

    public void setToDate(Date value) {
        put(PercentPromotionParams.toDate.toString(), value);
    }

    public Boolean getIsActive() {
        return getBoolean(PercentPromotionParams.isActive.toString());
    }

    public void setIsActive(Boolean value) {
        put(PercentPromotionParams.isActive.toString(), value);
    }

    public Double getPercentPromotion() {
        return getDouble(PercentPromotionParams.percentPromotion.toString());
    }

    public void setPercentPromotion(Double value) {
        put(PercentPromotionParams.percentPromotion.toString(), value);
    }

    public Double getMaxPromoValue() {
        return getDouble(PercentPromotionParams.maxPromoValue.toString());
    }

    public void setMaxPromoValue(Double value) {
        put(PercentPromotionParams.maxPromoValue.toString(), value);
    }

    public void addPromotion(Object object) {

        addPromotionToProductPrice((ProductPriceRow) object);

    }

    public void addPromotionToProductPrice(ProductPriceRow row)

    {

        if(isApplicable(row.getProduct())){

            double price = 0;
            try {
                price = row.getProduct().getPrice();
                double discount = getPercentPromotion()*price/100;
                if(discount > getMaxPromoValue())
                    discount = getMaxPromoValue();
                row.setPriceAfterDiscount(price-discount);
                setVendorPayment(row);

            } catch (Exception e) {
                e.printStackTrace(); // change to appropriate error
            }


        }


    }



    public enum PercentPromotionParams {

        promoType,
        promoCode,
        fromDate,
        toDate,
        isActive,
        percentPromotion,
        maxPromoValue


    }

}