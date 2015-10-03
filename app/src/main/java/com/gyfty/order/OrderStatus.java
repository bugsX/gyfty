package com.gyfty.order;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/26/15.
 */

@ParseClassName("OrderStatus")
public class OrderStatus extends ParseObject {


    public String getStatusCode() {
        return getString(OrderStatusParams.statusCode.toString());
    }

    public void setStatusCode(String value) {
        put(OrderStatusParams.statusCode.toString(),value);
    }

    public String getStatusMessage() {
        return getString(OrderStatusParams.statusMessage.toString());
    }

    public void setStatusMessage(String value) {
        put(OrderStatusParams.statusMessage.toString(),value);
    }


    public enum OrderStatusParams {

        statusCode,
        statusMessage

    }


}
