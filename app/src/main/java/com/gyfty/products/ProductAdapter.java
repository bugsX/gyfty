package com.gyfty.products;

/**
 * Created by akhilch on 9/23/2015.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akhilch.testapplication1.R;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class ProductAdapter extends ParseQueryAdapter<GyftyProduct> {

    public ProductAdapter(Context context) {
        super(context, new ParseQueryAdapter.QueryFactory<GyftyProduct>() {
            public ParseQuery<GyftyProduct> create() {
                // Here we can configure a ParseQuery to display
                // only top-rated meals.
                ParseQuery query = new ParseQuery("GyftyProduct");
                return query;
            }
        });
    }
    @Override
    public View getItemView(GyftyProduct product, View v, ViewGroup parent) {

        if (v == null) {
            v = View.inflate(getContext(), R.layout.item_list_favorites, null);
        }

        super.getItemView(product, v, parent);

        ParseImageView mealImage = (ParseImageView) v.findViewById(R.id.icon);
        ParseFile photoFile = product.getImage();
        if (photoFile != null) {
            mealImage.setParseFile(photoFile);
            mealImage.loadInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] data, ParseException e) {
                    // nothing to do
                }
            });
        }

        TextView titleTextView = (TextView) v.findViewById(R.id.text1);
        titleTextView.setText(product.getName());
        TextView ratingTextView = (TextView) v
                .findViewById(R.id.favorite_meal_rating);
        ratingTextView.setText(String.valueOf(product.getRating()));
        return v;
    }
}
