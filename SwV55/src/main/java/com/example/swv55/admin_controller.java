package com.example.swv55;

import java.util.Scanner;

public class admin_controller {
    CRUDOperations database;
    Admin ad=new Admin();
    void  verfiy(){
        for(int i=0 ; i<database.inverifedaccounts.size() ; i++){

            System.out.println("Enter " +(i+1) + "  to verfiy driver:  " +database.inverifedaccounts.get(i).getUser_name());

        }
        // System.out.println("Enter " +(inverifedaccounts.size()+1)+ "  to back to main menu    ");

        for(int i=0;i<database.inverifedaccounts.size();i++){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Choice");
            int choose = input.nextInt();

           database.Drivers.add(database.inverifedaccounts.get(choose-1));
            database.inverifedaccounts.remove(choose-1);



        }}
        void suspend(){
            Scanner input = new Scanner(System.in);
            System.out.println("what account u want to suspend");
            System.out.println("1-Passenger");
            System.out.println("2-Driver");
            int choice = input.nextInt();
            switch(choice)
            {
                case 1:
                {
                    if(database.Passengers.size()==0){
                        System.out.println("No Accounts to suspend");
                    }
                    else {
                        for (int i = 0; i < database.Passengers.size(); i++) {

                            System.out.println("Enter " + (i + 1) + "  to suspend :  " + database.Passengers.get(i).getUser_name());

                        }

                        for (int i = 0; i < database.Passengers.size(); i++) {
                            System.out.println("Enter Choice");
                            int choose = input.nextInt();

                            database.SuspendedAccounts_p.add(database.Passengers.get(choose-1));
                            database.Passengers.remove(database.Passengers.get(choose-1));

                        }
                    }

                }
                case 2 :
                {
            if( database.Drivers.size()==0){
                System.out.println("No Accounts to suspend");
            }
            else {
                for (int i = 0; i < database.Drivers.size(); i++) {
                    System.out.println("Enter " + (i + 1) + "  to suspend :  " + database.Drivers.get(i).getUser_name());
                }

                for (int i = 0; i < database.Drivers.size(); i++) {
                    System.out.println("Enter Choice");
                    int choose = input.nextInt();

                    database.SuspendedAccounts_D.add(database.Drivers.get(choose-1));
                    database.Drivers.remove(database.Drivers.get(choose-1));
                }
            }

        }
                default:
                {
                    System.out.println("Please enter a valid input");
                    break;
                }
            }
    }
    public void addAdmin(String Username, String pass){
        Admin ad = new Admin();
        ad.setUser_name(Username);
        ad.setPassaword(pass);
        database.admins.add(ad);


    }
    public Boolean Login(String Username, String pass) {
        Boolean loginTest = false;
        for(int i=0;i<database.admins.size();i++){
            if(Username.equals(database.admins.get(i).getUser_name()) && pass.equals(database.admins.get(i).getPassword()) ){
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
    void needverfiy(Driver u){
        database.inverifedaccounts.add(u);

    }
    void addpass(Passenger a){
        database.Passengers.add(a);

    }



}


