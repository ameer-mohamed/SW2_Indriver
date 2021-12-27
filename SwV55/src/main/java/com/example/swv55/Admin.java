package com.example.swv55;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin implements UserLogin{

    String user_name = "";
    String passaword = "";
    User user;
  //  Driver driver;

   public static ArrayList<Admin> admins = new ArrayList<Admin>();
   
    public  static ArrayList<User> AllAccounts = new ArrayList<User>();
   public static ArrayList<User> SuspendedAccounts = new ArrayList<User>();
 public static ArrayList<User> inverifedaccounts = new ArrayList<User>();

void needverfiy(User u){
    inverifedaccounts.add(u);

}
    void  verfiy(){
    for(int i=0 ; i<inverifedaccounts.size() ; i++){

             System.out.println("Enter " +(i+1) + "  to verfiy driver:  " +inverifedaccounts.get(i).getUser_name());

    }
       // System.out.println("Enter " +(inverifedaccounts.size()+1)+ "  to back to main menu    ");

        for(int i=0;i<inverifedaccounts.size();i++){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Choice");
            int choose = input.nextInt();

                AllAccounts.add(inverifedaccounts.get(choose-1));
                inverifedaccounts.remove(choose-1);



        }


}

       
       

   
    void addpass(User a){
    this.AllAccounts.add(a);
    
    }


    void suspend(){
        if(AllAccounts.size()==0){
            System.out.println("No Accounts to suspend");
        }
        else {
        for (int i = 0; i < AllAccounts.size(); i++) {

            System.out.println("Enter " + (i + 1) + "  to suspend :  " + AllAccounts.get(i).getUser_name());

        }

        for (int i = 0; i < AllAccounts.size(); i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Choice");
            int choose = input.nextInt();

                SuspendedAccounts.add(AllAccounts.get(choose-1));
                AllAccounts.remove(AllAccounts.get(choose-1));



        }

    }

    };
    public void addAdmin(String Username, String pass){
        Admin ad = new Admin();
        ad.setUser_name(Username);
        ad.setPassaword(pass);
    this.admins.add(ad);
    
    
    }

    @Override
    public Boolean Login(String Username, String pass) {
        Boolean loginTest = false;
        for(int i=0;i<this.admins.size();i++){
            if(Username.equals(this.admins.get(i).getUser_name()) && pass.equals(this.admins.get(i).getPassword()) ){
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

    @Override
    public void setUser_name(String user_name) {
        this.user_name=user_name;
    }

    @Override
    public String getUser_name() {
        return user_name;
    }

    @Override
    public void setPassaword(String password) {
        this.passaword=password;
    }

    @Override
    public String getPassword() {
        return this.passaword;
    }


}
