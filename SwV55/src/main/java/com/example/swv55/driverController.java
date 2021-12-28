package com.example.swv55;

import java.util.ArrayList;
import java.util.Scanner;

public class driverController implements subject,observer,UserLogin,UserSignUp {
    Driver driver = new Driver();
    passengerController PC =new passengerController();
    CRUDOperations CD=new CRUDOperations();

    void setDriver(Driver d){
        this.driver=d;
    }
    Driver getDriver(){
        return driver;
    }


    public Boolean Match(String source)
    {
        ArrayList<Integer> OO = new ArrayList<>();
        Boolean test = false;

        for(int i = 0 ; i < CD.Drivers.size(); i++ )
        {
            for(int j = 0 ; j <CD.Drivers.get(i).getFavouritAreas().size() ; j++)
            {
                //Driver d= new Driver();
                if(source.equals(CD.Drivers.get(i).getFavouritAreas().get(j)))
                {
                    System.out.println("We found a passenger");

                    OO = notify(i);
                    test = true;
                    break;

                }
                else
                {
                    System.out.println("This driver not in your source location");
                    test = false;
                    break;
                }
            }
        }

        return test;

    }
   public ArrayList<Integer> notify(int index)
    {

        System.out.println(CD.Drivers.get(index).getUser_name() +"    Please enter an offer");
        Scanner input = new Scanner(System.in);
        int offer = input.nextInt();
       CD.Drivers.get(index).setOfferPrice(offer);

        System.out.println("Avarage Rate : " + getaverageRating()+" For "+ CD.Drivers.get(index).getUser_name()+ " with offer price:  "+ CD.Drivers.get(index).getOfferPrice());


        return Offers;

    }


    @Override
    public void update(String message) {
        System.out.println("you have a new request from  :");

    }

    @Override
    public void add(observer observer ) {

    }

    @Override
    public void remove(observer observer) {

    }

    @Override
    public void notifyall() {

    }


    @Override
    public Boolean Login(String Username, String pass) {
        Boolean loginTest = false;
        for(int i=0;i<CD.Drivers.size();i++){


            if(Username.equals(CD.Drivers.get(i).getUser_name()) && pass.equals(CD.Drivers.get(i).getPassword()) ){
                System.out.print(CD.Drivers.get(i).getUser_name());
                System.out.println("      You Are loged in");
                loginTest = true;
                break;
            }
            else
            {
                // System.out.println("Username or Password is wrong");
                loginTest = false;
            }
        }
        if(loginTest==false ){System.out.println("Username or Password is wrong");}
        return loginTest;
    }

    @Override
    public void signUp() {
        System.out.println("Sign-up here");
        driver.setRole("driver");
        Scanner input = new Scanner(System.in);
        System.out.println("EnterUserNAme");
        String name = input.nextLine();
        driver.setUser_name(name);
        System.out.println("Enter pass");
        String password =  input.nextLine();
        driver.setPassaword(password);
        System.out.println("Enter Email");
        String email = input.nextLine();
        driver.setEmail(email);
        System.out.println("Enter mob");
        int mobile =input.nextInt();
        driver.setMob_number(mobile);
        System.out.println("Enter Driving Licesnse");
        String Dl= input.next();
        driver.setDrivingLicennse(Dl);
        System.out.println("Enter National ID");
        int ID = input.nextInt();
        driver.setnationalld(ID);
    }

    public void setCD(CRUDOperations CD) {
        this.CD = CD;
    }

    public CRUDOperations getCD() {
        return CD;
    }
}
