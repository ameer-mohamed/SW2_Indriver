package com.example.swv55;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin   {

    String user_name = "";
    String passaword = "";
    CRUDOperations CD = new CRUDOperations();
    Ride ride =new Ride();
  //  Driver driver;

  // public static ArrayList<Admin> admins = new ArrayList<Admin>();
   
   // public  static ArrayList<User> AllAccounts = new ArrayList<User>();
  // public static ArrayList<User> SuspendedAccounts = new ArrayList<User>();
 //public static ArrayList<User> inverifedaccounts = new ArrayList<User>();

    public void setUser_name(String user_name) {
        this.user_name=user_name;
    }


    public String getUser_name() {
        return user_name;
    }


    public void setPassaword(String password) {
        this.passaword=password;
    }


    public String getPassword() {
        return this.passaword;
    }

    public void setRide(Ride r){
        ride = r;
    }
    public Ride getRide(){
        return ride;
    }


}
