package com.example.swv55;

public class Event {
    String eventName ;
    int Time;
    String CaptinName;
    String passengerName;
    int price ;


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setTime(int time) {
        Time = time;
    }

    public int getTime() {
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

