package com.gyfty.decorator;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseQuery;

/**
 * Created by akhilch on 12/1/2015.
 */
public class ProductDecoratorHelper {
    private static ParseQuery<ProductDecoratorImpl> productDecoratorParseQuery = new ParseQuery<>("ProductDecorator");

    public static ProductDecorator getProductDecorator(String decoratorId) {
        ProductDecorator result;
        try {
            result = productDecoratorParseQuery.get(decoratorId);
        } catch (ParseException e) {
            Log.e("ProductDecoratorHelper", "getProductDecorator", e);
            result = null;
        }
        return result;
    }
}
