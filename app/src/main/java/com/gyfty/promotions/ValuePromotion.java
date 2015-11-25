package com.gyfty.promotions;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Mac on 9/21/15.
 */
@ParseClassName("ValuePromotion")
public abstract class ValuePromotion extends ParseObject implements Promotion {


    public String getPromoType() {
        return getString(ValuePromotionParams.promoType.toString());
    }

    public void setPromoType(String value){
        put(ValuePromotionParams.promoType.toString(),value);
    }

    public String getPromoCode(){
        return getString(ValuePromotionParams.promoCode.toString());
    }

    public void setPromoCode(String value){
        put(ValuePromotionParams.promoCode.toString(),value);
    }

    public Date getFromDate(){
        return getDate(ValuePromotionParams.fromDate.toString());
    }

    public void setFromDate(Date value){
        put(ValuePromotionParams.fromDate.toString(),value);
    }

    public Date getToDate(){
        return getDate(ValuePromotionParams.toDate.toString());
    }

    public void setToDate(Date value){
        put(ValuePromotionParams.toDate.toString(),value);
    }

    public Boolean getIsActive(){
        return getBoolean(ValuePromotionParams.isActive.toString());
    }

    public void setIsActive(Boolean value){
        put(ValuePromotionParams.isActive.toString(), value);
    }

    public Double getPromotionValue() {
        return getDouble(ValuePromotionParams.promotionValue.toString());
    }

    public void setPromotionValue(Double value) {
        put(ValuePromotionParams.promotionValue.toString(), value);
    }

    public Double getMinBillValue() {
        return getDouble(ValuePromotionParams.minBillValue.toString());
    }

    public void setMinBillValue(Double value) {
        put(ValuePromotionParams.minBillValue.toString(), value);
    }


    public enum ValuePromotionParams {

        promoType,
        promoCode,
        fromDate,
        toDate,
        isActive,
        promotionValue,
        minBillValue


    }


}
