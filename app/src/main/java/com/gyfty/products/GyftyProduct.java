package com.gyfty.products;

import com.gyfty.Images.Image;
import com.gyfty.category.Category;
import com.gyfty.support.Locale;
import com.gyfty.vendor.Vendor;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by akhilch on 9/18/15.
 */

// GyftyProduct Table is the products table for gyfty

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

    public Double getPrice() throws Exception {
        return getDouble(GyftyProductParams.price.toString());
    }

    public void setPrice(Double value) {
        put(GyftyProductParams.price.toString(),value);
    }

    public Image getImage() {
        return (Image) getParseFile(GyftyProductParams.image.toString());
    }

    public void setImage(Image value) {
        put(GyftyProductParams.image.toString(),value);
    }

    public ProductImagesGroup getSecondaryImages() {
        return (ProductImagesGroup)getParseObject(GyftyProductParams.secondaryImages.toString());
    }

    public void setSecondaryImages(Image value) {
        put(GyftyProductParams.secondaryImages.toString(),value);
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

    public Locale getLocale() {
        return (Locale) getParseObject(GyftyProductParams.locale.toString());
    }

    public void setLocale(Locale value) {
        put(GyftyProductParams.locale.toString(),value);
    }

    public Double getQuantity() {
        return getDouble(GyftyProductParams.quantity.toString());
    }

    public void setQuantity(Double value) {
        put(GyftyProductParams.quantity.toString(),value);
    }

    public Boolean isOutOfStock() {
        return getBoolean(GyftyProductParams.isOutOfStock.toString());
    }

    public void isOutOfStock(Boolean value) {
        put(GyftyProductParams.isOutOfStock.toString(),value);
    }

    public String getUrl() {
        return getString(GyftyProductParams.url.toString());
    }

    public void setUrl(String value) {
        put(GyftyProductParams.url.toString(),value);
    }

    public Boolean isActive() {
        return getBoolean(GyftyProductParams.isActive.toString());
    }

    public void isActive(Boolean value) {
        put(GyftyProductParams.isActive.toString(),value);
    }

    public enum GyftyProductParams {

        gyftyProductId,
        name,
        description,
        price,
        image,
        secondaryImages, // ProductImagesGroup
        rating,
        category,
        vendor, // Vendor
        leadTime,
        locale, // Locale(city)
        quantity, // Inventory
        isOutOfStock,
        url,
        isActive, // currently active or not
        type // think about this

    }


}