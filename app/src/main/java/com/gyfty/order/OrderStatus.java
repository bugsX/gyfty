package com.gyfty.order;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Mac on 9/26/15.
 */

@ParseClassName("OrderStatus")
public class OrderStatus extends ParseObject {




    public Date getDate() {
        return getDate(OrderStatusParams.date.toString());
    }

    public void setDate(Date value) {
        put(OrderStatusParams.date.toString(),value);
    }

    public OrderStatusMessage getMessage() {
        return (OrderStatusMessage)getParseObject(OrderStatusParams.message.toString());
    }

    public void setMessage(OrderStatusMessage value) {
        put(OrderStatusParams.message.toString(),value);
    }


    public enum OrderStatusParams {

        date,
        message

    }


}
