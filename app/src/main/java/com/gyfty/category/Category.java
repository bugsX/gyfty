package com.gyfty.category;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/18/15.
 */

@ParseClassName("Category")
public class Category extends ParseObject{

    public String getCategory() {
        return getString(CategoryParams.category.toString());
    }

    public void setCategory(String value) {
        put(CategoryParams.category.toString(),value);
    }

    public String getParentCategory() {
        return getString(CategoryParams.parentCategory.toString());
    }

    public void setParentCategory(String value) {
        put(CategoryParams.parentCategory.toString(),value);
    }

    public enum CategoryParams {

        category,
        parentCategory

    }


}
