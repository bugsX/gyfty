package com.gyfty.promotions;

import com.gyfty.products.GyftyProduct;
import com.gyfty.cart.ProductPriceRow;

import java.util.Date;

/**
 * Created by Mac on 9/21/15.
 */
public interface Promotion  {

    public String getPromoType();

    public void setPromoType(String value);

    public String getPromoCode();

    public void setPromoCode(String value);

    public Date getFromDate();

    public void setFromDate(Date value);

    public Date getToDate();

    public void setToDate(Date value);

    public Boolean getIsActive();

    public void setIsActive(Boolean value);

    public boolean isApplicable(GyftyProduct product);

    public void setVendorPayment(ProductPriceRow row);

    public void addPromotion(Object object);

}

