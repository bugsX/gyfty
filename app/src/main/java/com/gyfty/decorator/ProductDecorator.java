package com.gyfty.decorator;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 10/3/15.
 */

@ParseClassName("ProductDecorator")
public class ProductDecorator  extends ParseObject{

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

    enum ProductDecoratorParams {
        costType,
        name,
        costFactor,
        description,
        notes

    }

}
