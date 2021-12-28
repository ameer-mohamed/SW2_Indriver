package com.example.swv55;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin implements UserLogin  {

    String user_name = "";
    String passaword = "";
    CRUDOperations CD;

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

    @Override
    public Boolean Login(String Username, String pass) {Boolean loginTest = false;
        for(int i=0;i<CD.admins.size();i++){
            if(Username.equals(CD.admins.get(i).getUser_name()) && pass.equals(CD.admins.get(i).getPassword()) ){
                //    System.out.println("You Are loged in");
                loginTest = true;
                break;
            }
            else
            {
                //  System.out.println("Username or Password is wrong");
                loginTest = false;
            }
        }if(loginTest ){
            System.out.println("You Are loged in");
        }
        else{System.out.println("Username or Password is wrong");}
        return loginTest;

    }


}
