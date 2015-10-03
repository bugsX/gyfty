package com.gyfty.query;

import android.content.Context;

import com.gyfty.products.GyftyProduct;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

/**
 * Created by akhilch on 9/22/2015.
 */
public class ProductQueryAdapter extends ParseQueryAdapter<GyftyProduct>{
    public ProductQueryAdapter(Context context, Class<? extends ParseObject> clazz) {
        super(context, clazz);
    }
}
