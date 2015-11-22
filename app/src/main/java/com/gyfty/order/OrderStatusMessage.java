package com.gyfty.order;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 10/5/15.
 */

// OrderStatusMessage table stores the different StatusCodes and messages

@ParseClassName("OrderStatusMessage")
public class OrderStatusMessage extends ParseObject {

    public String getStatusCode() {
        return getString(OrderStatusMessageParams.statusCode.toString());
    }

    public void setStatusCode(String value) {
        put(OrderStatusMessageParams.statusCode.toString(),value);
    }

    public String getStatusMessage() {
        return getString(OrderStatusMessageParams.statusMessage.toString());
    }

    public void setStatusMessage(String value) {
        put(OrderStatusMessageParams.statusMessage.toString(),value);
    }

    public enum OrderStatusMessageParams {

        statusCode,
        statusMessage

    }


}
