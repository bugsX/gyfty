package com.gyfty.category;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Mac on 9/23/15.
 */

@ParseClassName("CategoryCustomSpecs")
public class CategoryCustomSpecs extends ParseObject {

    public Category getCategory() {
        return (Category) getParseObject(CategoryCustomSpecsParams.category.toString());
    }

    public void setCategory(Category value) {
        put(CategoryCustomSpecsParams.category.toString(),value);
    }

    public List<String> getSpecList() {
        return getList(CategoryCustomSpecsParams.specList.toString());
    }

    public void setSpecList(List<String> value) {
        put(CategoryCustomSpecsParams.specList.toString(),value);
    }


    public enum CategoryCustomSpecsParams {

        category,
        specList // Array of strings

    }



}