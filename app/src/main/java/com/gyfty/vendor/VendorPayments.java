package com.gyfty.vendor;

import com.gyfty.vendor.Vendor;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/26/15.
 */

// VendorPayments table provides the payments for each product

@ParseClassName("VendorPayments")
public class VendorPayments extends ParseObject {

    public Vendor getVendor() {
        return (Vendor) getParseObject(VendorPaymentsParams.vendor.toString());
    }

    public void setVendor(Vendor value) {
        put(VendorPaymentsParams.vendor.toString(),value);
    }

    public Double getCommisionAmount() {
        return getDouble(VendorPaymentsParams.commisionAmount.toString());
    }

    public void setCommisionAmount(Double value) {
        put(VendorPaymentsParams.commisionAmount.toString(),value);
    }

    public Double getPaymentAmount() {
        return getDouble(VendorPaymentsParams.paymentAmount.toString());
    }

    public void setPaymentAmount(Double value) {
        put(VendorPaymentsParams.paymentAmount.toString(),value);
    }

    public Double getTotalAmount() {
        return getDouble(VendorPaymentsParams.totalAmount.toString());
    }

    public void setTotalAmount(Double value) {
        put(VendorPaymentsParams.totalAmount.toString(),value);
    }

    public String getOrderId() {
        return getString(VendorPaymentsParams.orderId.toString());
    }

    public void setOrderId(String value) {
        put(VendorPaymentsParams.orderId.toString(),value);
    }


    public enum VendorPaymentsParams {

        vendor, // Vendor
        commisionAmount,
        paymentAmount,
        totalAmount,
        orderId


    }

}
