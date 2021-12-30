package com.example.swv55;

import java.util.Date;

public class Ride {
    String source ;
    String destnation;
   // Event event = new Event();
    Date date;
    int numOfPassengers ;
    passengerController PassengerController = new passengerController();
    driverController DriverController = new driverController();


    public void setPassengerController(passengerController PassengerController) {
        this.PassengerController = PassengerController;
    }
    public passengerController getpassCont(){
        return PassengerController;
    }

    public void setDriverController(driverController DriverController) {
        this.DriverController = DriverController;
    }
    public driverController getdrivcont(){
        return DriverController;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public String getDestnation() {
        return destnation;
    }

    public void setDestnation(String destnation) {
        this.destnation = destnation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

/*    public void setEvent(Event event) {
        this.event = event;
    }
*/
    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public int getNumOfPassengers(){
        return this.numOfPassengers;
    }

    public Date getDate() {
        return date;
    }
/*
    public Event getEvent() {
        return event;
    }*/


}
