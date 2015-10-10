package com.example.akhilch.testapplication1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import com.google.common.collect.Lists;
import com.gyfty.attributes.GyftyAttributes;
import com.gyfty.cart.Cart;
import com.gyfty.category.CategoryCustomSpecs;
import com.gyfty.decorator.ProductDecoratorImpl;
import com.gyfty.events.GyftyEvent;
import com.gyfty.events.GyftyUserEvent;
import com.gyfty.logistics.DeliveryLogistics;
import com.gyfty.logistics.PickUpLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.order.OrderStatus;
import com.gyfty.order.OrderStatusMessage;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.ProductAdapter;
import com.gyfty.products.ProductCustomSpecs;
import com.gyfty.promotions.CategoryPromotion;
import com.gyfty.promotions.ProductPromotion;
import com.gyfty.promotions.PromotionErrorCodes;
import com.gyfty.promotions.VendorPromotion;
import com.gyfty.support.Addresses;
import com.gyfty.category.Category;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.order.Order;
import com.gyfty.logistics.TimeSlot;
import com.gyfty.support.Locale;
import com.gyfty.users.DeliveryMan;
import com.gyfty.users.GyftyUser;
import com.gyfty.vendor.Vendor;
import com.gyfty.vendor.VendorPayments;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ParseQueryAdapter<ParseObject> mainAdapter;
    private ProductAdapter productAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Parse.initialize(this, "M9x5Ptiz7QZW80z5mwJGBNBW4GupRNY8j5akwZDL", "yAhlN8zeqvi3fshJIHekZvzR1l4th3IL776PZLzV");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseObject.registerSubclass(GyftyAttributes.class);

        ParseObject.registerSubclass(Cart.class);

        ParseObject.registerSubclass(Category.class);
        ParseObject.registerSubclass(CategoryCustomSpecs.class);

        ParseObject.registerSubclass(ProductDecoratorImpl.class);

        ParseObject.registerSubclass(GyftyEvent.class);
        ParseObject.registerSubclass(GyftyUserEvent.class);

        ParseObject.registerSubclass(DeliveryLogistics.class);
        ParseObject.registerSubclass(PickUpLogistics.class);
        ParseObject.registerSubclass(Schedule.class);
        ParseObject.registerSubclass(TimeSlot.class);

        ParseObject.registerSubclass(Order.class);
        ParseObject.registerSubclass(OrderStatus.class);
        ParseObject.registerSubclass(OrderStatusMessage.class);

        ParseObject.registerSubclass(PickUp.class);

        ParseObject.registerSubclass(GyftyProduct.class);
        ParseObject.registerSubclass(GyftyProductsGroup.class);
        ParseObject.registerSubclass(ProductCustomSpecs.class);


        ParseObject.registerSubclass(CategoryPromotion.class);
        ParseObject.registerSubclass(ProductPromotion.class);
        ParseObject.registerSubclass(PromotionErrorCodes.class);
        ParseObject.registerSubclass(VendorPromotion.class);

        ParseObject.registerSubclass(Addresses.class);
        ParseObject.registerSubclass(Locale.class);

        ParseObject.registerSubclass(DeliveryMan.class);
        ParseObject.registerSubclass(GyftyUser.class);

        ParseObject.registerSubclass(Vendor.class);
        ParseObject.registerSubclass(VendorPayments.class);



// Initialize main ParseQueryAdapter
//        mainAdapter = new ParseQueryAdapter<ParseObject>(this, "Todo");
//        mainAdapter.setTextKey("title");
//        mainAdapter.setImageKey("image");

        // Initialize the subclass of ParseQueryAdapter
        productAdapter = new ProductAdapter(this);

        // Initialize ListView and set initial view to mainAdapter
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(productAdapter);
        productAdapter.loadObjects();

        // Initialize toggle button
//        Button toggleButton = (Button) findViewById(R.id.toggleButton);
//        toggleButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (listView.getAdapter() == mainAdapter) {
//                    listView.setAdapter(urgentTodosAdapter);
//                    urgentTodosAdapter.loadObjects();
//                } else {
//                    listView.setAdapter(mainAdapter);
//                    mainAdapter.loadObjects();
//                }
//            }
//
//        });

//        GyftyAttributes deliveryCharge = new GyftyAttributes();
//        deliveryCharge.setAttributeName("deliveryCharge");
//        deliveryCharge.setAttributeValue("50");
//        deliveryCharge.saveInBackground();
//
//        GyftyAttributes minDeliveryValue = new GyftyAttributes();
//        minDeliveryValue.setAttributeName("minDeliveryValue");
//        minDeliveryValue.setAttributeValue("200");
//        minDeliveryValue.saveInBackground();
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
//
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] image = stream.toByteArray();
//        ParseFile file = new ParseFile("image.jpg",image);
//        file.saveInBackground();
//
//        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.cake);
//
//        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
//        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
//        byte[] image2 = stream2.toByteArray();
//        ParseFile file2 = new ParseFile("cake.jpg",image2);
//        file2.saveInBackground();
//
//        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.concu);
//
//        ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
//        bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
//        byte[] image3 = stream3.toByteArray();
//        ParseFile file3 = new ParseFile("cake.jpg",image3);
//        file3.saveInBackground();
//
//
//
//
//        Category cake = new Category();
//        cake.setCategory("Cake");
//        cake.setCategoryImage(file2);
//        cake.setParentCategory("Bakery");
//        cake.isActive(true);
//        cake.saveInBackground();
//
//        ParseGeoPoint geoPoint = new ParseGeoPoint();
//        geoPoint.setLatitude(23.232323);
//        geoPoint.setLongitude(13.131313);
//
//        Locale locality = new Locale();
//        locality.setLocaleName("Hyderabad");
//        locality.setLocaleCoordinates(geoPoint);
//        locality.saveInBackground();
//
//        Addresses address = new Addresses();
//        address.setName("1, Jubilee Hills, Hyderabad");
//        address.setPhoneNumber("998988899");
//        address.setStreet("banjara hills");
//        address.setLocale(locality);
//        address.setPincode("500034");
//        address.saveInBackground();
//
//        Vendor vendor = new Vendor();
//        vendor.setVendorId("00000001");
//        vendor.setName("Concu Bakery");
//        vendor.setImage(file3);
//        vendor.setRating(4.5);
//        vendor.setBranch("Jubilee Hills");
//        vendor.setEmailAddress("care@concu.com");
//        vendor.setPhoneNumber("9989888376");
//        vendor.setBankName("ICICI Bank");
//        vendor.setBankAccountNumber("778377373");
//        vendor.setBankIFSCCode("ICIC232132");
//        vendor.setBranchAddress(address);
//        vendor.setBillingAddress(address);
//        vendor.setCommisionPercentage(13.5);
//        vendor.setLocale(locality);
//        vendor.saveInBackground();
//
//
//
//
//        GyftyProduct gyftyProduct = new GyftyProduct();
//        gyftyProduct.setGyftyProductId("00000001");
//        gyftyProduct.setName("Chocolate Cake");
//        gyftyProduct.setDescription("Crunchy base with crazy loads of chocolate");
//        gyftyProduct.setPrice(1200.0);
//        gyftyProduct.setImage(file);
//        gyftyProduct.setRating(3.6);
//        gyftyProduct.setCategory(cake);
//        gyftyProduct.setVendor(vendor);
//        gyftyProduct.setLeadTime(6.0);
//        gyftyProduct.setLocale(locality);
//        gyftyProduct.setQuantity(20.0);
//        gyftyProduct.isOutOfStock(false);
//        gyftyProduct.setUrl("http://www.gyfty.co/concu/chocolatecake12");
//        gyftyProduct.isActive(true);
//        gyftyProduct.saveInBackground();
//
//        GyftyProduct gyftyProduct2 = new GyftyProduct();
//        gyftyProduct2.setGyftyProductId("00000002");
//        gyftyProduct2.setName("Vanilla Cake");
//        gyftyProduct2.setDescription("Crunchy base with crazy loads of chocolate");
//        gyftyProduct2.setPrice(1200.0);
//        gyftyProduct2.setImage(file);
//        gyftyProduct2.setRating(3.6);
//        gyftyProduct2.setCategory(cake);
//        gyftyProduct2.setVendor(vendor);
//        gyftyProduct2.setLeadTime(6.0);
//        gyftyProduct2.setLocale(locality);
//        gyftyProduct2.setQuantity(20.0);
//        gyftyProduct2.isOutOfStock(false);
//        gyftyProduct2.setUrl("http://www.gyfty.co/concu/chocolatecake12");
//        gyftyProduct2.isActive(true);
//        gyftyProduct2.saveInBackground();
//
//        GyftyProduct gyftyProduct3 = new GyftyProduct();
//        gyftyProduct3.setGyftyProductId("00000002");
//        gyftyProduct3.setName("Strawberry Cake");
//        gyftyProduct3.setDescription("Crunchy base with crazy loads of chocolate");
//        gyftyProduct3.setPrice(1200.0);
//        gyftyProduct3.setImage(file);
//        gyftyProduct3.setRating(3.6);
//        gyftyProduct3.setCategory(cake);
//        gyftyProduct3.setVendor(vendor);
//        gyftyProduct3.setLeadTime(6.0);
//        gyftyProduct3.setLocale(locality);
//        gyftyProduct3.setQuantity(20.0);
//        gyftyProduct3.isOutOfStock(false);
//        gyftyProduct3.setUrl("http://www.gyfty.co/concu/chocolatecake12");
//        gyftyProduct3.isActive(true);
//        gyftyProduct3.saveInBackground();
//
//        GyftyProductsGroup gyftyProductsGroup  = new GyftyProductsGroup();
//        gyftyProductsGroup.addGyftyProductToGrp(gyftyProduct);
//        gyftyProductsGroup.addGyftyProductToGrp(gyftyProduct2);
//        gyftyProductsGroup.saveInBackground();
//
//
//
//        try {
//            List<GyftyProduct> newgyftyProductsList = gyftyProductsGroup.getGyftyProductGroup();
//            gyftyProductsGroup.setGyftyProductGroup(newgyftyProductsList);
//            gyftyProductsGroup.saveInBackground();
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


    }
}
