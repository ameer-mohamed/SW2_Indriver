package com.example.swv55;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CRUDOperations database = new CRUDOperations();
        admin_controller Ac = new admin_controller();
        driverController DC = new driverController();
        passengerController Pc = new passengerController();
        Admin ad = new Admin();
        Driver d1 = new Driver();
        Driver d2 = new Driver();
        driverController DC2 = new driverController();
        passengerController Pc2 = new passengerController();
        // UserData u1 = new UserData();
        Passenger p1 = new Passenger();
        Passenger p2 = new Passenger();
        Ride ride = new Ride();


        Scanner input = new Scanner(System.in);


        p1.setRole("Passenger");
        p1.setUser_name("MMO");
        p1.setPassaword("1230");
        p1.setMob_number(011450);
        p1.setEmail("M@gmail.com");
        Pc.setPassenger(p1);

        p2.setRole("Passenger");
        p2.setUser_name("MO");
        p2.setPassaword("12310");
        p2.setMob_number(0151450);
        p2.setEmail("Mo@gmail.com");
        Pc2.setPassenger(p2);


        d1.setRole("Driver");
        d1.setUser_name("oo");
        d1.setPassaword("1459");
        d1.setnationalld(012144);
        d1.setEmail("O@gmail.com");
        d1.setDrivingLicennse("411ss");
        d1.setMob_number(01111);
        DC.setDriver(d1);

        d2.setRole("Driver");
        d2.setUser_name("ee");
        d2.setPassaword("159");
        d2.setnationalld(012144);
        d2.setEmail("E@gmail.com");
        d2.setDrivingLicennse("411ee");
        d2.setMob_number(01111);
        DC2.setDriver(d2);

        Pc.setDC(DC);
        Pc2.setDC(DC2);

        DC.setPassengerController(Pc);
        DC2.setPassengerController(Pc);

        database.getDrivers().add(d1);
        database.getDrivers().add(d2);
        database.getPassengers().add(p1);

        Ac.addAdmin("ameer","311");
        Ac.addAdmin("menna", "101");
        Ac.addAdmin("medhat", "1811");
        Ac.addAdmin("suad", "102");

        DC.getDriver().getFavouritAreas().add("haram");
        DC2.getDriver().getFavouritAreas().add("haram");

        Date d =new Date();

        Ride r =new Ride();
        r.setSource("haram");
        r.setDestnation("dhdhh");
        r.setPassengerController(Pc);
        r.setDate(d);
        r.setNumOfPassengers(3);


        Pc.request(r);

        System.out.println(DC2.getDriver().Requestedrides.size());

        for(int i = 0 ; i < database.Drivers.size(); i++ ) {
            for (int j=0; j< database.Drivers.get(i).Requestedrides.size(); j++)
            {
                System.out.println("Enter "+(i+1) +" To accept Request Ride From "+ database.Drivers.get(i).Requestedrides.get(j).getSource() +" To "+database.Drivers.get(i).Requestedrides.get(j).getDestnation()+
                        " With "+ database.Drivers.get(i).Requestedrides.get(j).getNumOfPassengers() + " Passengers !");
            }

        }

        for(int i = 0 ; i < database.Drivers.size(); i++ ) {
            for (int y = 0; y < database.Drivers.get(i).Requestedrides.size(); y++) {
                System.out.println("Enter Choice");
                int choose = input.nextInt();

                DC.acceptRequestRide(database.Drivers.get(i).Requestedrides.get(y));

            }
        }




        for (int i = 0; i <DC.getDriver().AllRidesInFavAreas.size(); i++){
            System.out.println(DC.getDriver().AllRidesInFavAreas.get(i).getPrice());
            System.out.println(DC.getDriver().AllRidesInFavAreas.get(i).getSource());
            System.out.println(DC.getDriver().AllRidesInFavAreas.get(i).getDestnation());
            System.out.println(DC.getDriver().AllRidesInFavAreas.get(i).getNumOfPassengers());
            System.out.println(DC.getDriver().AllRidesInFavAreas.get(i).getDate());
            System.out.println(DC.getDriver().AllRidesInFavAreas.get(i).getdrivcont().getDriver().getUser_name());
            System.out.println(DC.getDriver().AllRidesInFavAreas.get(i).getpassCont().getPassenger().getUser_name());
        }



/*
        for (int i = 0; i < Pc.Offers.size(); i++) {
            System.out.println("Enter Choice");
            int choose = input.nextInt();

        }
**/





    }

}
