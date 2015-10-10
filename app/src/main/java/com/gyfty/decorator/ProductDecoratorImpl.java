package com.gyfty.decorator;

import com.gyfty.products.CartGyftyProduct;
import com.gyfty.vendor.Vendor;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;

/**
 * Created by Mac on 10/3/15.
 */

@ParseClassName("ProductDecorator")
public class ProductDecoratorImpl extends ParseObject implements ProductDecorator {

    public String getCostType() {
        return getString(ProductDecoratorParams.costType.toString());
    }

    public void setCostType(String value) {
        put(ProductDecoratorParams.costType.toString(),value);
    }

    public String getName() {
        return getString(ProductDecoratorParams.name.toString());
    }

    public void setName(String value) {
        put(ProductDecoratorParams.name.toString(),value);
    }

    public Double getCostFactor() {
        return getDouble(ProductDecoratorParams.costFactor.toString());
    }

    public void setCostFactor(Double value) {
        put(ProductDecoratorParams.costFactor.toString(),value);
    }

    public String getDescription() {
        return getString(ProductDecoratorParams.description.toString());
    }

    public void setDescription(String value) {
        put(ProductDecoratorParams.description.toString(),value);
    }

    public String getNotes() {
        return getString(ProductDecoratorParams.notes.toString());
    }

    public void setNotes(String value) {
        put(ProductDecoratorParams.notes.toString(),value);
    }

    public Vendor getVendor() {
        return (Vendor) getParseObject(ProductDecoratorParams.vendor.toString());
    }

    public void setVendor(String value) {
        put(ProductDecoratorParams.vendor.toString(),value);
    }

    @Override
    public CartGyftyProduct getDecoratedProduct(CartGyftyProduct product) {
        CartGyftyProduct decoratedProduct = new CartGyftyProduct(product) {

            @Override
            public Double getPrice() throws Exception {
                if (getCostType().equals("Add")) {
                    return super.getPrice() + getCostFactor();
                } else if (getCostType().equals("Mul")) {
                    return super.getPrice() * getCostFactor();
                }
                throw new Exception("UnSupported Product Declaration");
            }

            @Override
            public String getSellerNotes() {
                return super.getSellerNotes() + " - " + getNotes();
            }

        };
        return decoratedProduct;
    }

    public void createAndSaveProductDecorator(String name, String costType, double costFactor, String description, String notes) throws ParseException {
        ProductDecoratorImpl productDecorator = new ProductDecoratorImpl();
        productDecorator.setName(name);
        productDecorator.setCostFactor(costFactor);
        productDecorator.setCostType(costType);
        productDecorator.setDescription(description);
        productDecorator.setNotes(notes);
        productDecorator.save();
    }
    enum ProductDecoratorParams {
        costType,
        name,
        costFactor,
        description,
        notes,
        vendor

    }

}
