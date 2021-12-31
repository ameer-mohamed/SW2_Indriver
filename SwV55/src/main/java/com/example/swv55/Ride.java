package com.example.swv55;

import java.util.Date;

public class Ride {
    String source ;
    String destnation;
   // Event event = new Event();
    Date date;
    int numOfPassengers ;
    int price ;
    passengerController PassengerController = new passengerController();
    driverController DriverController = new driverController();
//Passenger passenger = new Passenger();
//Driver driver = new Driver();
/*
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return passenger;
    }
*/

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

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
