package com.gyfty.vendor;

import com.gyfty.logistics.Schedule;
import com.gyfty.order.Order;
import com.gyfty.products.GyftyProduct;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by akhilch on 10/9/2015.
 */

//Vendor Notes table stores notes to be sent to the vendor for a particular order for each product individually

@ParseClassName("VendorNotes")
public class VendorNotes extends ParseObject {

    public Vendor getVendor() {
        return (Vendor) get(VendorNotesParams.vendor.toString());
    }

    public void setVendor(Vendor v) {
        put(VendorNotesParams.vendor.toString(), v);
    }

    public GyftyProduct getProduct() {
        return (GyftyProduct) get(VendorNotesParams.product.toString());
    }

    public void setGyftyProduct(GyftyProduct product) {
        put(VendorNotesParams.product.toString(), product);
    }

    public String getNotesForProduct() {
        return (String) get(VendorNotesParams.notes.toString());
    }

    public void setNotesForProduct(String notesForProduct) {
        put(VendorNotesParams.notes.toString(), notesForProduct);
    }

    public Order getOrder() {
        return (Order) get(VendorNotesParams.orderId.toString());
    }

    public void setOrder(Order order) {
        put(VendorNotesParams.orderId.toString(), order);
    }

    public Schedule getSchedue() {
        return (Schedule) get(VendorNotesParams.schedule.toString());
    }

    public void setSchedule(Schedule schedule) {
        put(VendorNotesParams.schedule.toString(), schedule);
    }

    enum VendorNotesParams {
        vendor, // Vendor
        product, // GyftyProduct
        notes,
        orderId, // Order
        schedule // Schedule
    }

}
