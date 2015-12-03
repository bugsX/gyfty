package com.example.akhilch.testapplication1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.gyfty.attributes.GyftyAttributes;
import com.gyfty.cart.Cart;
import com.gyfty.cart.CartHelper;
import com.gyfty.category.Category;
import com.gyfty.category.CategoryCustomSpecs;
import com.gyfty.decorator.ProductDecoratorHelper;
import com.gyfty.decorator.ProductDecoratorImpl;
import com.gyfty.events.GyftyEvent;
import com.gyfty.events.GyftyUserEvent;
import com.gyfty.logistics.DeliveryLogistics;
import com.gyfty.logistics.PickUpLogistics;
import com.gyfty.logistics.Schedule;
import com.gyfty.logistics.TimeSlot;
import com.gyfty.order.Order;
import com.gyfty.order.OrderStatus;
import com.gyfty.order.OrderStatusMessage;
import com.gyfty.pickup.PickUp;
import com.gyfty.products.BaseCartGyftyProduct;
import com.gyfty.products.CartGyftyProduct;
import com.gyfty.products.GyftyProduct;
import com.gyfty.products.GyftyProductsGroup;
import com.gyfty.products.ProductAdapter;
import com.gyfty.products.ProductCustomSpecs;
import com.gyfty.promotions.CartPromotion;
import com.gyfty.promotions.CategoryPromotion;
import com.gyfty.promotions.ProductPromotion;
import com.gyfty.promotions.PromotionErrorCodes;
import com.gyfty.promotions.VendorPromotion;
import com.gyfty.support.Addresses;
import com.gyfty.support.Locale;
import com.gyfty.users.DeliveryMan;
import com.gyfty.users.GyftyUser;
import com.gyfty.vendor.Vendor;
import com.gyfty.vendor.VendorNotes;
import com.gyfty.vendor.VendorPayments;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.Date;

public class MainActivity extends Activity {

    private ParseQueryAdapter<ParseObject> mainAdapter;
    private ProductAdapter productAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            Parse.initialize(this, "xtjCihTU7fCFgV0szuqdwStLZuvoveuzbaH9OHEU", "Kqw3pXo9I7Oc3qkl7n1FCWAcRBWWE352wUMnDWON");
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

        ParseObject.registerSubclass(CartPromotion.class);
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
        ParseObject.registerSubclass(VendorNotes.class);



// Initialize main ParseQueryAdapter
//        mainAdapter = new ParseQueryAdapter<ParseObject>(this, "Todo");
//        mainAdapter.setTextKey("title");
//        mainAdapter.setImageKey("image");

        // Initialize the subclass of ParseQueryAdapter
//        productAdapter = new ProductAdapter(this);

        // Initialize ListView and set initial view to mainAdapter
//        listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(productAdapter);
//        productAdapter.loadObjects();

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


        Date date = new Date();
        date.setYear(2015);
        date.setMonth(3);
        date.setDate(30);

        GyftyAttributes deliveryCharge = new GyftyAttributes();
        deliveryCharge.setAttributeName("deliveryCharge");
        deliveryCharge.setAttributeValue("50");
        deliveryCharge.saveInBackground();

        GyftyAttributes minDeliveryValue = new GyftyAttributes();
        minDeliveryValue.setAttributeName("minDeliveryValue");
        minDeliveryValue.setAttributeValue("200");
        minDeliveryValue.saveInBackground();
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
//
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] image = stream.toByteArray();
//        Image file = new Image("image.jpg",image);
//        file.saveInBackground();
//
//        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.cake);
//
//        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
//        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
//        byte[] image2 = stream2.toByteArray();
//        Image file2 = new Image("cake.jpg",image2);
//        file2.saveInBackground();
//
//        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.concu);
//
//        ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
//        bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
//        byte[] image3 = stream3.toByteArray();
//        Image file3 = new Image("cake.jpg",image3);
//        file3.saveInBackground();




//        Category cake = new Category();
//        cake.setCategory("Cake");
//        cake.setCategoryImage(file2);
//        cake.setParentCategory("Bakery");
//        cake.isActive(true);
//        cake.saveInBackground();
//
        ParseGeoPoint geoPoint = new ParseGeoPoint();
        geoPoint.setLatitude(23.232323);
        geoPoint.setLongitude(13.131313);
//
        Locale locality = new Locale();
        locality.setLocaleName("Hyderabad");
        locality.setLocaleCoordinates(geoPoint);
        locality.saveInBackground();
//
        Addresses address = new Addresses();
        address.setName("1, Jubilee Hills, Hyderabad");
        address.setPhoneNumber("998988899");
        address.setStreet("banjara hills");
        address.setLocale(locality);
        address.setPincode("500034");
        address.saveInBackground();
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
//        gyftyProductsGroup.addGyftyProductToGrp(gyftyProduct3);
//        gyftyProductsGroup.saveInBackground();
//
//
//        List<GyftyProduct> newgyftyProductsList = gyftyProductsGroup.getGyftyProductGroup();
//        gyftyProductsGroup.setGyftyProductGroup(newgyftyProductsList);
//        gyftyProductsGroup.saveInBackground();
//        gyftyProductsGroup.removeGyftyProductsFromGrp(gyftyProduct2);
//        gyftyProductsGroup.saveInBackground();
//
//        GyftyUser gyftyUser = new GyftyUser();
//        gyftyUser.setDevideId("11002233");
//        gyftyUser.setPhoneNumber("89782083333");
//        gyftyUser.setImage(file3);
//        gyftyUser.setFacebookId("tom.hanks");
//        gyftyUser.setAddress(address);
//        gyftyUser.setNotificationType("default");
//        gyftyUser.setCurrency("Dollar");
//        gyftyUser.setPromoCode("TOM123");
//        gyftyUser.setOTP("4564");
//        gyftyUser.setEmailAddress("tom.hanks@gmail.com");
////        gyftyUser.setName("Tom Hanks");
////        gyftyUser.setBirthday(date);
////        GyftyUserHelper.addFavoriteProduct(gyftyUser, gyftyProduct3);
////        GyftyUserHelper.addRecentProduct(gyftyUser, gyftyProduct3);
////        GyftyUserHelper.addFavoriteProduct(gyftyUser, gyftyProduct2);
////        GyftyUserHelper.addRecentProduct(gyftyUser, gyftyProduct2);
////        GyftyUserHelper.removeFavoriteProduct(gyftyUser, gyftyProduct3);
////        GyftyUserHelper.removeRecentProduct(gyftyUser, gyftyProduct2);
//        gyftyUser.saveInBackground();
//
        OrderStatusMessage statusMessage=new OrderStatusMessage();
        statusMessage.setStatusCode("123");
        statusMessage.setStatusMessage("OnProcess");
        statusMessage.saveInBackground();
//
//
        OrderStatus status=new OrderStatus();
        status.setDate(date);
        status.setMessage(statusMessage);
        status.saveInBackground();
////
////
//
//        DeliveryMan man=new DeliveryMan();
//        man.setLocation(geoPoint);
//        man.setLocale(locality);
//        man.setStatus(status);
//        man.saveInBackground();
//
//
//        PickUpLogistics logistics = new PickUpLogistics();
//        logistics.setGyftyAdmin(gyftyUser);
//        logistics.setDeliveryMan(man);
//        logistics.saveInBackground();
//
        TimeSlot time=new TimeSlot();
        time.setTimeSlotId("123");
        time.setStartTime(date);
        time.setEndTime(date);
        time.saveInBackground();
//
//
        Schedule schedule=new Schedule();
        schedule.setScheduleDate(date);
        schedule.saveInBackground();
//
//
        PickUp pickUp=new PickUp();
        pickUp.setAddress(address);
        pickUp.setPickUpStatus(status);
        pickUp.setSchedule(schedule);
        pickUp.saveInBackground();
//
//        GyftyUserEvent gyftyUserevent=new GyftyUserEvent();
//        gyftyUserevent.setName("Kadiri");
//        gyftyUserevent.setDate(date);
//        gyftyUserevent.setReminder("hi");
//        gyftyUserevent.setProductGroup(gyftyProductsGroup);
//        gyftyUserevent.setNotes("aaaabbbbaaabbabab");
//        gyftyUserevent.setUser(gyftyUser);
//        gyftyUserevent.saveInBackground();
//
//        GyftyEvent gyftyEvent=new GyftyEvent();
//        gyftyEvent.setName("Phalu");
//        gyftyEvent.setDate(date);
//        gyftyEvent.setReminder("hello");
//        gyftyEvent.setProductGroup(gyftyProductsGroup);
//        gyftyEvent.setNotes("zzzzzzzzzzzzzzzz");
//        gyftyEvent.saveInBackground();
//
//
//        GyftyEvent sampleGyftyEvent = GyftyEvent.createGyftyEvent("Sample Birthday", date, file, "Same Day", "Sample notes");
//        GyftyEvent.createGyftyEvent("Phalu's Birthday", date, file3, "Same Day", "Sample notes");
//        GyftyEvent.removeGyftyEvent(sampleGyftyEvent);
//
//        GyftyUserEvent sampleGyftyUserEvent = GyftyUserEvent.createGyftyUserEvent("another another Birthday", date, file, "Same Day", "Sample notes",gyftyUser);
//        GyftyUserEvent.createGyftyUserEvent("Narri's Birthday", date, file3, "Same Day", "Sample notes",gyftyUser);
//        GyftyUserEvent.removeGyftyUserEvent(sampleGyftyUserEvent);
//
//        PromotionErrorCodes promotionErrorCodes=new PromotionErrorCodes();
//        promotionErrorCodes.setErrorCode("888");
//        promotionErrorCodes.setErrorMessage("Minimum order 200");
//        promotionErrorCodes.saveInBackground();
//
//
//        Cart cart=new Cart();
//        cart.setUser(gyftyUser);
////        cart.setProducts(gyftyProductsGroup);
//        cart.setPickup(pickUp);
//        cart.setSchedule(schedule);
//        cart.setAddress(address);
//        cart.setEvent(gyftyEvent);
//        cart.setTransactionId("11111");
//        cart.saveInBackground();
//
//
//        DeliveryLogistics deliveryLogistics=new DeliveryLogistics();
//        deliveryLogistics.setDeliveryMan(man);
//        deliveryLogistics.setGyftyAdmin(gyftyUser);
//        deliveryLogistics.saveInBackground();
//
//        Order order = new Order();
//        order.setOrderId("2222");
//        order.setSchedule(schedule);
//        order.setDeliveryLogistics(deliveryLogistics);
//        order.setAddress(address);
//        order.setEvent(gyftyEvent);
//        order.setPickUp(pickUp);
//        order.setOrderStatus(status);
//        order.saveInBackground();

//        CartGyftyProduct sampleProduct = (CartGyftyProduct) gyftyProduct;
//        CartHelper.addProductToCart(cart,gyftyProduct);
//        System.out.println(cart.productPrice.get(0).getCommisionAmount());


            GyftyAttributes.loadAttributeMap();
            System.out.println(GyftyAttributes.attributeMap.size());
            for (String key : GyftyAttributes.attributeMap.keySet()) {
                    System.out.println("Main Method" + GyftyAttributes.attributeMap.get(key));
            }
            Cart cart = new Cart();

            try {
                    GyftyProduct product = new ParseQuery<GyftyProduct>("GyftyProduct").include(GyftyProduct.GyftyProductParams.vendor.toString()).get("1CRdHeucEr");
                    CartHelper.addProductToCart(cart, product);
                    CartGyftyProduct cartGyftyProduct = new BaseCartGyftyProduct(product);
                    ProductDecoratorImpl decorator = ProductDecoratorHelper.getProductDecorator("ZNy5DC1VB5");
                    CartGyftyProduct cartGyftyProduct1 = decorator.getDecoratedProduct(cartGyftyProduct);
                    CartHelper.addProductToCart(cart, cartGyftyProduct1);
                    CartHelper.addPickUpToCart(cart, pickUp);
                    CartHelper.addAddressToCart(cart, address);
                    CartHelper.addScheduleToCart(cart, schedule);

                    try {
                            System.out.println("\n\n\n\n\nDecorated Price " + cartGyftyProduct1.getPrice() + "Initial Price" + product.getPrice() + "\n\n\n\n\n");
                    } catch (Exception e) {
                            System.out.println("Here");
                            e.printStackTrace();
                    }
            } catch (ParseException e) {
                    System.out.println("NoHere");
                    e.printStackTrace();
            } catch (Exception e) {
                    e.printStackTrace();
            }

            System.out.println(cart.productPrice);
            System.out.println(cart.total);



//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("ClassName");
//        query.whereEqualTo("category","cakes");
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> list, ParseException e) {
//                if (e==null) {
//
//                    for (ParseObject object:list) {
//
//                        //Sample action
//
//                    }
//
//                }
//
//                else {
//
//                    //print error
//                }
//            }
//        });

    }
}
