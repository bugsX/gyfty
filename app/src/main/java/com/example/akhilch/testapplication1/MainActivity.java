package com.example.akhilch.testapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.gyfty.support.Addresses;
import com.gyfty.category.Category;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.order.Order;
import com.gyfty.logistics.TimeSlot;
import com.gyfty.vendor.Vendor;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

public class MainActivity extends AppCompatActivity  {
    private ParseQueryAdapter<GyftyProduct> mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listview = (ListView) findViewById(R.id.listview);
        ParseObject.registerSubclass(GyftyProduct.class);
        ParseObject.registerSubclass(Vendor.class);
        ParseObject.registerSubclass(Category.class);
        ParseObject.registerSubclass(Addresses.class);
        ParseObject.registerSubclass(TimeSlot.class);
        ParseObject.registerSubclass(Order.class);
        ParseObject.registerSubclass(GyftyProductsGroup.class);
        //Parse.enableLocalDatastore(this);
        Parse.initialize(this, "wysydRU0ijAYxlBAij48Sf0IFluwC4WHEbkfZFus", "mWV0Y4Yr8PABiWJYfSfpxFSpkMhCJfV7X2maJeWw");
        ParseAnalytics.trackAppOpened(getIntent());
        mainAdapter = new ParseQueryAdapter<GyftyProduct>(this, GyftyProduct.class);
        mainAdapter.setTextKey("title");
        mainAdapter.setImageKey("photo");
        listview.setAdapter(mainAdapter);
/*
        try {
           // GyftyProduct.getAllProducts();
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/


    }
}
