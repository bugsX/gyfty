package com.gyfty.category;

import com.gyfty.Images.Image;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/18/15.
 */

// Category Table stores the different categories available with their parent category

@ParseClassName("Category")
public class Category extends ParseObject{

    public String getCategory() {
        return getString(CategoryParams.category.toString());
    }

    public void setCategory(String value) {
        put(CategoryParams.category.toString(),value);
    }

    public Image getCategoryImage() {
        return (Image)getParseFile(CategoryParams.categoryImage.toString());
    }

    public void setCategoryImage(Image value) {
        put(CategoryParams.categoryImage.toString(),value);
    }

    public String getParentCategory() {
        return getString(CategoryParams.parentCategory.toString());
    }

    public void setParentCategory(String value) {
        put(CategoryParams.parentCategory.toString(),value);
    }

    public Boolean isActive() {
        return getBoolean(CategoryParams.isActive.toString());
    }

    public void isActive(Boolean value) {
        put(CategoryParams.isActive.toString(),value);
    }

    public enum CategoryParams {

        category,
        categoryImage,
        parentCategory,
        isActive //  To Dynamically set a particular category on or off

    }


}

