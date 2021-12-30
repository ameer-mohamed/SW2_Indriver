package com.example.swv55;

import java.util.Scanner;

public class passengerController implements subject,observer, UserSignUp,UserLogin{
    CRUDOperations CD=new CRUDOperations();
    Passenger passenger ;
    driverController DC ;
    Ride rd=new Ride();

    void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }
    Passenger getPassenger(){
        return passenger;
    }

    void request(String source,String destnation)
   {
        //rd.source =source;
        //rd.destnation = destnation;

        for(int i = 0 ; i <= CD.Drivers.size(); i++)
        {

             DC.Match(source , destnation);

        }
    };


   Boolean accept()
    {
        Boolean test = false;

        Scanner sc = new Scanner(System.in);

        int i = 0 ;
        System.out.println("Your offers are : [");
        for (int k = 0; k < CD.Offers.size(); k++) {
            System.out.println(CD.Offers.get(k) + " , ");
        }
        System.out.println(" ]");
        while(test == false)
        {
            System.out.println("Please choose an offer");
            int x = sc.nextInt();
            // driver.setOfferPrice(x);
            for(int z = 0 ; z < CD.Offers.size() ; z++){
                if(CD.Offers.get(z) == x)
                {
                    int y = z+1;
                    System.out.println("The passenger selected the offer of the driver : " + CD.Drivers.get(z).getUser_name() );
                     rated(CD.Drivers.get(z));
                    CD.Drivers.get(z).AllRidesInFavAreas.add(rd.getSource());
                    //System.out.println("Dm"+this.getDriver().getUser_name());
                    test = true;
                }

            }
            if(test == false){
                System.out.println("Please enter a valid number");
            }
        }
        CD.Offers.clear();

        //rated(this.getDriver());

       // this.getDriver().AllRidesInFavAreas.add(this.getSource());
        return test;
    }


    void rated (Driver D)
    {
        // System.out.println("DU"+D.getUser_name());

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Rate From 1 to 5");
        int R= input.nextInt();
        while(R >5 || R<1){
            System.out.println("Enter from 1 to 5");
            R= input.nextInt();
        }
        D.setRates(R);


        System.out.println("Successfully rated");
        System.out.println("");


    }

    @Override
    public void update(int message) {
        System.out.println("your offers are :  "+ message);

    }

    @Override
    public void add(observer observer) {

    }

    @Override
    public void remove(observer observer) {

    }

    @Override
    public void notifyall() {
        for(int i = 0 ; i <= CD.Drivers.size(); i++)
        {

            DC.Match(rd.source , rd.destnation);

        }
    }

    @Override
    public Boolean Login(String Username, String pass) {
        Boolean loginTest = false;
        for(int i=0;i<CD.Passengers.size();i++){


            if(Username.equals(CD.Passengers.get(i).getUser_name()) && pass.equals(CD.Passengers.get(i).getPassword()) ){
                System.out.print(CD.Passengers.get(i).getUser_name());
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
        passenger.setRole("passenger");
        Scanner input = new Scanner(System.in);
        System.out.println("EnterUserNAme");
        String name = input.nextLine();
        passenger.setUser_name(name);
        System.out.println("Enter pass");
        String password =  input.nextLine();
        passenger.setPassaword(password);
        System.out.println("Enter Email");
        String email = input.nextLine();
        passenger.setEmail(email);
        System.out.println("Enter mob");
        int mobile =input.nextInt();
        passenger.setMob_number(mobile);

        CD.Passengers.add(passenger);

    }

    public Ride getRd() {
        return rd;
    }

    public void setRd(Ride rd) {
        this.rd = rd;
    }

    public CRUDOperations getCD() {
        return CD;
    }

    public void setCD(CRUDOperations CD) {
        this.CD = CD;
    }

    public driverController getDC() {
        return DC;
    }

    public void setDC(driverController DC) {
        this.DC = DC;
    }
}
