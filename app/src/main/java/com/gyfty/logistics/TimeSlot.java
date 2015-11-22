package com.gyfty.logistics;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Mac on 9/19/15.
 */

//Timeslot table has the different timeslots available for a pickUp or a delivery

@ParseClassName("TimeSlot")
public class TimeSlot extends ParseObject{

    public String getTimeSlotId() {
        return getString(TimeSlotParams.timeSlotId.toString());
    }

    public void setTimeSlotId(String value) {
        put(TimeSlotParams.timeSlotId.toString(),value);
    }

    public Date getStartTime() {
        return getDate(TimeSlotParams.startTime.toString());
    }

    public void setStartTime(Date value) {
        put(TimeSlotParams.startTime.toString(),value);
    }

    public Date getEndTime() {
        return getDate(TimeSlotParams.endTime.toString());
    }

    public void setEndTime(Date value) {
        put(TimeSlotParams.endTime.toString(),value);
    }



    public enum TimeSlotParams {

        timeSlotId,
        startTime,
        endTime

    }

}
