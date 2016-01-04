package com.gyfty.decorator;

import android.util.Log;

import com.google.common.collect.Lists;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.ProductCustomSpecs;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by akhilch on 12/1/2015.
 */
public class ProductDecoratorHelper {
    private static ParseQuery<ProductDecoratorImpl> productDecoratorParseQuery = new ParseQuery<>("ProductDecorator");

    public static ProductDecoratorImpl getProductDecorator(String decoratorId) {
        ProductDecoratorImpl result;
        ParseQuery<ProductDecoratorImpl> productDecoratorParseQuery = new ParseQuery<>("ProductDecorator");
        try {
            result = productDecoratorParseQuery.get(decoratorId);
        } catch (ParseException e) {
            Log.e("ProductDecoratorHelper", "getProductDecorator", e);
            result = null;
        }
        return result;
    }

    /**
     * Use this method to get product decorators from productCustomsSpec using product and specName.
     *
     * @param product
     * @param specName
     * @return
     */
    public static List<ProductDecoratorImpl> getAllPDsFromProductCustomSpecName(GyftyProduct product, String specName) {
        List<ProductDecoratorImpl> result = Lists.newArrayList();
        ParseQuery<ProductCustomSpecs> query = ParseQuery.getQuery(ProductCustomSpecs.class);
        query.whereEqualTo(ProductCustomSpecs.ProductCustomSpecsParams.product.toString(), product);
        query.whereEqualTo(ProductCustomSpecs.ProductCustomSpecsParams.specName.toString(), specName);

        try {
            ProductCustomSpecs specs = query.getFirst();
            List<Map<String, String>> listOfSpecMaps = (List<Map<String, String>>) specs.get(ProductCustomSpecs.ProductCustomSpecsParams.specValue.toString());
            for (Map<String, String> specMap : listOfSpecMaps) {
                ProductDecoratorImpl pd = ProductDecoratorHelper.getProductDecorator(specMap.get("objectId"));
                result.add(pd);
            }
        } catch (ParseException e) {
            Log.e("ProductDecoratorHelper", "getProductDecorator(" + product.getObjectId() + ", " + specName + ") ", e);
        }

        return result;
    }
}
