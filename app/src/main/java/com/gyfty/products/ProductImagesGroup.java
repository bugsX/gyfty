package com.gyfty.products;

import com.google.common.collect.Lists;
import com.gyfty.Images.Image;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Mac on 10/11/15.
 */

@ParseClassName("ProductImagesGroup")
public class ProductImagesGroup extends ParseObject {

    public List<Image> getProductImagesGroup() {
        List<Image> images;
        images = getList(ProductImagesParams.imagesArray.toString());
        return images;
    }

    public void setProductImagesGroup(List<Image> images) {
        put(ProductImagesParams.imagesArray.toString(), images);
    }

    public void addProductImagesToGrp(Image p) {
        add(ProductImagesParams.imagesArray.toString(), p);
    }

    public void removeProductImagesFromGrp(Image image){
        List<Image> list = Lists.newArrayList(image);
        removeAll(ProductImagesParams.imagesArray.toString(), list);
    }

    public enum ProductImagesParams {
        imagesArray
    }

}
