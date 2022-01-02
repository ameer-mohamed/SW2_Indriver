package com.example.swv55;
import java.util.ArrayList;
public class CRUDOperations {
     static ArrayList<Driver> inverifedaccounts = new ArrayList<Driver>();
     ArrayList<Driver> SuspendedAccounts_D = new ArrayList<Driver>();
    ArrayList<Passenger> SuspendedAccounts_p = new ArrayList<Passenger>();
    ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<String> discountAreas = new ArrayList<String>();
   static ArrayList<Driver> Drivers = new ArrayList<Driver>();
   static ArrayList<Passenger> Passengers = new ArrayList<Passenger>();
    public static ArrayList<Integer>Offers=new ArrayList<Integer>();

    public ArrayList<Driver> getInverifedaccounts() {
        return inverifedaccounts;
    }

    public void setInverifedaccounts(ArrayList<Driver> inverifedaccounts) {
        this.inverifedaccounts = inverifedaccounts;
    }

    public ArrayList<Driver> getSuspendedAccounts_D() {
        return SuspendedAccounts_D;
    }

    public void setSuspendedAccounts_D(ArrayList<Driver> suspendedAccounts_D) {
        SuspendedAccounts_D = suspendedAccounts_D;
    }

    public ArrayList<Passenger> getSuspendedAccounts_p() {
        return SuspendedAccounts_p;
    }

    public void setSuspendedAccounts_p(ArrayList<Passenger> suspendedAccounts_p) {
        SuspendedAccounts_p = suspendedAccounts_p;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Driver> getDrivers() {
        return Drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        Drivers = drivers;
    }

    public ArrayList<Passenger> getPassengers() {
        return Passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        Passengers = passengers;
    }

    public ArrayList<Integer> getOffers() {
        return Offers;
    }

    public void setOffers(ArrayList<Integer> offers) {
        Offers = offers;
    }



}
