package com.example.swv55;

import java.util.ArrayList;
import java.util.Scanner;


public class Passenger  {


    int mob_number=0;
    String Email;
    String role;
    String user_name ;
    String passaword ;


    public void setUser_name(String user_name) {
        this.user_name= user_name;
    }



    public String getUser_name() {
        return this.user_name;
    }


    public void setPassaword(String password) {
        this.passaword = password;
    }


    public String getPassword() {
        return this.passaword;
    }



    public void setMob_number(int mob_number) {
        this.mob_number=mob_number;
    }


    public int getMob_number() {
        return mob_number;
    }


    public void setEmail(String Email) {
        this.Email=Email;
    }


    public String getEmail() {
        return Email;
    }

    public void setRole(String role) {
        this.role=role;
    }

    public String getRole() {
        return role;
    }


/*
    public  void showRates(){
        for (int i =0 ; i< this.getDriver().HisRates.size() ; i++){

            System.out.println("Your Rate: "+ this.getDriver().HisRates.get(i));
        }
    }


    Driver getDriver(){
        return this.driver;
    };

    public void setAd(Admin ad) {
        this.ad = ad;
    }

    public Admin getAd() {
        return ad;
    }

    

    void setDriver(Driver d){
        this.driver = d;
    }

    @Override
    public void signup() {

        this.setRole("passenger");
        Scanner input = new Scanner(System.in);
        System.out.println("EnterUserNAme");
        String name = input.nextLine();
        this.setUser_name(name);
        System.out.println("Enter pass");
        String password =  input.nextLine();
        this.setPassaword(password);
        System.out.println("Enter Email");
        String email = input.nextLine();
        this.setEmail(email);
        System.out.println("Enter mob");
        int mobile =input.nextInt();
        this.setMob_number(mobile);

       
       

        this.setSignedaccounts(this);

    }*/
}
