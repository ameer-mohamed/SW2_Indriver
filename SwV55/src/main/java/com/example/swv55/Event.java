package com.example.swv55;

import java.time.LocalTime;

public class Event {
    String eventName ;
    LocalTime Time;
    String CaptinName;
    String passengerName;
    int price ;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setTime(LocalTime time) {
        Time = time;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }
    public void setCaptinName(String captinName) {
        this.CaptinName = captinName;
    }
    public String getCaptinName() {
        return CaptinName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerName() {
        return passengerName;
    }
}

