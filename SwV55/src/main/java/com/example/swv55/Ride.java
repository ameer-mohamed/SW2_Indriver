package com.example.swv55;

import java.util.Date;
import java.util.ArrayList;
public class Ride {
    String source ;
    String destnation;
    // Event event = new Event();
    Date date;
    int numOfPassengers ;
    double price ;

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    boolean firstRide = true;
    ArrayList<Event>events = new ArrayList<Event>();
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
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
@Override
public String toString() {
    return "Ride{" +
            "source='" + source + '\'' +
            ", destnation='" + destnation + '\'' +
            ", date=" + date +
            ", numOfPassengers=" + numOfPassengers +
            ", price=" + price +'}';
}

}
