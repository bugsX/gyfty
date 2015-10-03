package com.gyfty.products;

import com.gyfty.category.Category;
import com.gyfty.vendor.Vendor;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/18/15.
 */
@ParseClassName("GyftyProduct")
public class GyftyProduct extends ParseObject{


    public String getGyftyProductId() {
        return getString(GyftyProductParams.gyftyProductId.toString());
    }

    public void setGyftyProductId(String value) {
        put(GyftyProductParams.gyftyProductId.toString(),value);
    }

    public String getName() {
        return getString(GyftyProductParams.name.toString());
    }

    public void setName(String value) {
        put(GyftyProductParams.name.toString(),value);
    }

    public String getDescription() {
        return getString(GyftyProductParams.description.toString());
    }

    public void setDescription(String value) {
        put(GyftyProductParams.description.toString(),value);
    }

    public double getPrice() {
        return getDouble(GyftyProductParams.price.toString());
    }

    public void setPrice(double value) {
        put(GyftyProductParams.price.toString(),value);
    }

    public ParseFile getImage() {
        return getParseFile(GyftyProductParams.image.toString());
    }

    public void setImage(ParseFile value) {
        put(GyftyProductParams.image.toString(),value);
    }

    public Double getRating() {
        return getDouble(GyftyProductParams.rating.toString());
    }

    public void setRating(Double value) {
        put(GyftyProductParams.rating.toString(),value);
    }

    public Double getLeadTime() {
        return getDouble(GyftyProductParams.leadTime.toString());
    }

    public void setLeadTime(Double value) {
        put(GyftyProductParams.leadTime.toString(),value);
    }


    public Category getCategory() {
        return (Category)getParseObject(GyftyProductParams.category.toString());
    }

    public void setCategory(Category value) {
        put(GyftyProductParams.category.toString(),value);
    }

    public Vendor getVendor() {
        return (Vendor)getParseObject(GyftyProductParams.vendor.toString());
    }

    public void setVendor(Vendor value) {
        put("vendor",value);
    }

    public String getLocale() {
        return getString(GyftyProductParams.locale.toString());
    }

    public void setLocale(String value) {
        put(GyftyProductParams.locale.toString(),value);
    }

    public int getQuantity() {
        return getInt(GyftyProductParams.quantity.toString());
    }

    public void setQuantity(int value) {
        put(GyftyProductParams.quantity.toString(),value);
    }

    public boolean getOutOfStock() {
        return getBoolean(GyftyProductParams.outOfStock.toString());
    }

    public void setOutOfStock(boolean value) {
        put(GyftyProductParams.outOfStock.toString(),value);
    }

    public String getUrl() {
        return getString(GyftyProductParams.url.toString());
    }

    public void setUrl(String value) {
        put(GyftyProductParams.url.toString(),value);
    }


    public enum GyftyProductParams {

        gyftyProductId,
        name,
        description,
        price,
        image,
        rating,
        category,
        vendor,
        leadTime,
        locale,
        quantity,
        outOfStock,
        url,
        type

    }


}