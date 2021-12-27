package com.example.swv55;

import java.util.Scanner;

public class admin_controller {
    Admin admin;
    CRUDOperations database;
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



        }}
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

        }
    public void addAdmin(String Username, String pass){
        Admin ad = new Admin();
        ad.setUser_name(Username);
        ad.setPassaword(pass);
        this.admins.add(ad);


    }
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
    void needverfiy(User u){
        inverifedaccounts.add(u);

    }
    void addpass(User a){
        this.AllAccounts.add(a);

    }



}


