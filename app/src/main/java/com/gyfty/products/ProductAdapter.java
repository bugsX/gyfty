package com.gyfty.products;

/**
 * Created by akhilch on 9/23/2015.
 */

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akhilch.testapplication1.R;
import com.google.common.collect.Lists;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;

public class ProductAdapter extends ParseQueryAdapter<ParseObject> {

    public ProductAdapter(Context context) {
        // Use the QueryFactory to construct a PQA that will only show
        // Todos marked as high-pri
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("GyftyProductsGroup");
                return query;
            }
        });
    }

    // Customize the layout by overriding getItemView
    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (v == null) {
            v = View.inflate(getContext(), R.layout.urgent_item, null);
        }

        super.getItemView(object, v, parent);

        // Add and download the image
        ParseImageView todoImage = (ParseImageView) v.findViewById(R.id.icon);
        ParseFile imageFile = object.getParseFile("image");
        if (imageFile != null) {
            todoImage.setParseFile(imageFile);
            todoImage.loadInBackground();
        }

//        GyftyProductsGroup products = (GyftyProductsGroup) object;
//        List<GyftyProduct> gyftyProducts = products.getGyftyProductGroup();





        // Add the title view

//        TextView t1TextView = (TextView) v.findViewById(R.id.t1);
//        t1TextView.setText();

//        TextView t2TextView = (TextView) v.findViewById(R.id.t2);
//        t2TextView.setText(dataArray.get(1));

//        TextView t3TextView = (TextView) v.findViewById(R.id.t3);
//        t3TextView.setText(dataArray.get(2));
//
//        TextView t4TextView = (TextView) v.findViewById(R.id.t4);
//        t4TextView.setText(dataArray.get(3));
//
//        TextView t5TextView = (TextView) v.findViewById(R.id.t5);
//        t5TextView.setText(dataArray.get(4));
//
//        TextView t6TextView = (TextView) v.findViewById(R.id.t6);
//        t6TextView.setText(dataArray.get(5));
//
//        TextView t7TextView = (TextView) v.findViewById(R.id.t7);
//        t7TextView.setText(dataArray.get(6));
//
//        TextView t8TextView = (TextView) v.findViewById(R.id.t8);
//        t8TextView.setText(dataArray.get(7));
//
//        TextView t9TextView = (TextView) v.findViewById(R.id.t9);
//        t9TextView.setText(dataArray.get(8));
//
//        TextView t10TextView = (TextView) v.findViewById(R.id.t10);
//        t10TextView.setText(dataArray.get(9));

        return v;
    }


}
