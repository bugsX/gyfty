package com.gyfty.category;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/23/15.
 */

@ParseClassName("CategoryCustomSpecs")
public class CategoryCustomSpecs extends ParseObject {

    public Category getProduct() {
        return (Category) getParseObject(CategoryCustomSpecsParams.category.toString());
    }

    public void setProduct(Category value) {
        put(CategoryCustomSpecsParams.category.toString(),value);
    }

    public  String getSpecList() {
        return (String) getString(CategoryCustomSpecsParams.specList.toString());
    }

    public void setSpecList(String value) {
        put(CategoryCustomSpecsParams.specList.toString(),value);
    }


    public enum CategoryCustomSpecsParams {

        category,
        specList

    }



}

