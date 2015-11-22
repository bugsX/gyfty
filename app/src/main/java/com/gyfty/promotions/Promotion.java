package com.gyfty.promotions;

import com.gyfty.cart.ProductPriceRow;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Mac on 9/21/15.
 */
public interface Promotion  {

    String getPromoType();

    void setPromoType(String value);

    String getPromoCode();

    void setPromoCode(String value);

    Date getFromDate();

    void setFromDate(Date value);

    Date getToDate();

    void setToDate(Date value);

    Boolean getIsActive();

    void setIsActive(Boolean value);

    boolean isApplicable(ParseObject appliedOn);

    void setVendorPayment(ProductPriceRow row);

    void addPromotion(Object object);

    void promotionUtilized();

}