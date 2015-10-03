package com.gyfty.logistics;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Mac on 9/21/15.
 */

@ParseClassName("Schedule")
public class Schedule extends ParseObject{


    public Date getScheduleDate() {
        return getDate(ScheduleParams.scheduleDate.toString());
    }

    public void setScheduleDate(Date value) {
        put(ScheduleParams.scheduleDate.toString(),value);
    }

    public Date getTimeSlot() {
        return getDate(ScheduleParams.scheduleSlot.toString());
    }

    public void setTimeSlot(Date value) {
        put(ScheduleParams.scheduleSlot.toString(),value);
    }


    public enum ScheduleParams {
        scheduleDate, //Date
        scheduleSlot //TimeSlot
    }

}
