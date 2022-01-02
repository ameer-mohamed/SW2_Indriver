package com.example.swv55;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class passengerController implements subject,observer, UserSignUp,UserLogin{
    CRUDOperations CD=new CRUDOperations();
    Passenger passenger = new Passenger() ;
    driverController DC = new driverController();
    //admin_controller AC = new admin_controller();
   // Ride rd=new Ride();
   // static ArrayList<Integer> Offers = new ArrayList<Integer>();


    void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }
    Passenger getPassenger(){
        return passenger;
    }

    void request(Ride r) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your source");
        String src = input.next();
        System.out.println("please enter your Destnation");
        String dest = input.next();
        System.out.println("please enter number of passengers");
        int num = input.nextInt();

        //DC.setPassengerController(Pc);
        // Pc.setDC(DC);

        this.setPassenger(passenger);

        r.setPassengerController(this);
        r.setSource(src);
        r.setDestnation(dest);
        r.setNumOfPassengers(num);
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d2 = new Date();
            r.setDate(d2);
        }catch(Exception e)
        {

        }
        System.out.println("Wait For Drivers......");
    };


   Boolean accept(Ride r)
    {
        System.out.println("I entered the accept function");
        System.out.println("The offers size: "+CD.Offers.size());
        Boolean test = false;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i <CD.Offers.size(); i++){
            System.out.println("Enter "+(i+1) +" To accept offer  "+CD.Offers.get(i) + " With " + CD.TimeDesnation.get(i) + " mins away!");

        }

        for (int i = 0; i < CD.Offers.size(); i++) {
            System.out.println("Enter Choice");


            int choose = input.nextInt();
            System.out.println(choose);
            //System.out.println("I am entering 1 now");
            r.setPrice(CD.Offers.get(choose-1));

            Event e = new Event();
            e.setEventName("Passenger Acccept Offer of specific driver!");
            LocalTime AT = LocalTime.now();
            e.setTime(AT);
            e.setPassengerName(r.getpassCont().getPassenger().getUser_name());
            r.events.add(e);
             LocalTime n = AT.plusMinutes(CD.TimeDesnation.get(i) );
             if(java.time.LocalTime.now() == n){
                 Event e2 = new Event();
                 e.setEventName("Captain arrived to user location !");
                 e.setTime(n);
                 e.setPassengerName(r.getpassCont().getPassenger().getUser_name());
                 e.setCaptinName(r.getdrivcont().getDriver().getUser_name());
                 r.events.add(e);
             }

            //System.out.println("I am entering 2 now");
            //DC.driver.AllRidesInFavAreas.add(r);
            DC.getDriver().AllRidesInFavAreas.add(r);

        }
        if(r.getNumOfPassengers() == 2)
        {
            System.out.println("You will have a 5% discount since the number of the passengers in the ride = 2 !");
            r.price = (r.price * 0.95);
        }
        if(this.passenger.getFirstRide()==true)
        {
            System.out.println("You have now a discount 10% on this ride since it is your first ride !");
            r.price = (r.price * 0.9);

        }
        for(int i = 0; i < CD.discountAreas.size();i++)
        {
            System.out.println("You have now a discount 10% on this ride since you are in a special area !");
            r.price = (r.price * 0.9);
        }

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM");
            Date d1 = sdf.parse(passenger.getBirthDate());
            Date d2 = new Date();
            sdf.format(d1);
            String myDate = sdf.format(d2);
            if(passenger.getBirthDate().equals(myDate))
            {
                System.out.println("You have now a 10% discount since today is your birthday, Happy Birthday !!");
                r.price = (r.price * 0.9);
            }

        }catch(Exception e)
        {

        }
        this.passenger.setFirstRide(false);



/*
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
                  //  CD.Drivers.get(z).AllRidesInFavAreas.add(rd.getSource());
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

       // this.getDriver().AllRidesInFavAreas.add(this.getSource());*/
        return test;
    }


    void rated (Ride r)
    {
        // System.out.println("DU"+D.getUser_name());

        Event e = new Event();
        e.setEventName("Captain arrived to user destination!");
        e.setTime((java.time.LocalTime.now()));
        e.setPassengerName(r.getpassCont().getPassenger().getUser_name());
        e.setCaptinName(r.getdrivcont().getDriver().getUser_name());
        r.events.add(e);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Rate From 1 to 5");
        int R= input.nextInt();
        while(R >5 || R<1){
            System.out.println("Enter from 1 to 5");
            R= input.nextInt();
        }
        r.getdrivcont().getDriver().setRate(R);
        r.getdrivcont().getDriver().HisRates.add(R);

        CD.Rides.add(r);
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

            //DC.Match(rd.source , rd.destnation);

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
       Scanner input2 = new Scanner(System.in);
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
        System.out.println("Enter Birth date");
        String date =input2.nextLine();
        passenger.setBirthDate(date);

        CD.Passengers.add(passenger);

    }

    /*public Ride getRd() {
        return rd;
    }

    public void setRd(Ride rd) {
        this.rd = rd;
    }*/

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
