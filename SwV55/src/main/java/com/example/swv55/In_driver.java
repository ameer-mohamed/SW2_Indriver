/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.swv55;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class In_driver {


  public static   Map<Integer,String > offerPrices=new HashMap<Integer,String >();

    public static void main(String[] args) {
        CRUDOperations database=new CRUDOperations();
        admin_controller Ac= new admin_controller();
        driverController DC = new driverController();
        passengerController Pc = new passengerController();
        Admin ad = new Admin();
        Driver d1 = new Driver();
       // UserData u1 = new UserData();
        Passenger p1 = new Passenger();
        Ride ride = new Ride();
       // p1.setAd(ad);
      //  d1.setAd(ad);
       // u1.setAd(ad);

        Ac.addAdmin("ameer","311");
       Ac.addAdmin("menna", "101");
        Ac.addAdmin("medhat", "1811");
        Ac.addAdmin("suad", "102");
        
        int exist=-1;
       int  inverifed=-1;
      System.out.println("Welcome !");
       Scanner input = new Scanner(System.in);
        Boolean flag = true;
        while(flag)
        { 
            System.out.println("Choose one of the following choices");
            System.out.println("1) Sign up");
            System.out.println("2) Login");  
            int choice = input.nextInt(); 
            switch(choice)
                    {
                
                        case 1:
                        {
                            Boolean Role = true;
                            while(Role == true){
                            System.out.println("Choose one of the following roles");
                            System.out.println("1) Passenger");
                            System.out.println("2) Driver");
                            int role = input.nextInt();
                            
                            if(role == 1)
                            {
                                Pc.setPassenger(p1);
                                Pc.setCD(database);
                                Pc.signUp();
                              // Ac.addpass(p1);
                               p1=new Passenger();

                                for(int i =0;i<database.Passengers.size();i++){

                                    System.out.println(database.Passengers.get(i).getUser_name()+ database.Passengers.get(i).getRole());

                                }
                               break;
                            }
                            else if(role == 2)
                            {
                                DC.setDriver(d1);
                                DC.setCD(database);
                               DC.signUp();
                               Ac.needverfiy(d1);
                               d1 = new Driver();
                              for(int i =0;i<database.inverifedaccounts.size();i++){
                              
                              System.out.println(database.inverifedaccounts.get(i).getUser_name()+ database.inverifedaccounts.get(i).getRole());
                              
                              }

                               break;
                           }
                            else
                            {
                                System.out.println("Please enter a valid input");
                                Role = true;
                            }
                            
                            }
                            
                            break;
                        }
                        case 2:
                        {
                            Boolean Role = true;
                            while(Role ){
                            System.out.println("Choose one of the following roles");
                            System.out.println("1) User");
                            System.out.println("2) Admin");
                            int role = input.nextInt();
                            if(role == 1) {
                                System.out.println("Choose one of the following roles");
                                System.out.println("1) Driver");
                                System.out.println("2) Passenger");
                                int how = input.nextInt();
                                switch (how) {
                                    case 1: {
                                        System.out.println("enter your username");
                                        String username = input.next();
                                        System.out.println("enter your Passaword");
                                        String pass = input.next();
                                        Boolean z = DC.Login(username, pass);
                                        for (int i = 0; i < database.inverifedaccounts.size(); i++) {
                                            if (username.equals(database.inverifedaccounts.get(i).getUser_name())) {
                                                inverifed = i;
                                            }
                                        }
                                        if (inverifed != -1) {
                                            System.out.println("your Account is not verifed yet"
                                                    + "please wait an admin verify you soon ");
                                        }
                                        inverifed = -1;
                                        if (z == true) {
                                            exist = -1;
                                            for (int i = 0; i < database.Drivers.size(); i++) {
                                                if (username.equals(database.Drivers.get(i).getUser_name())) {
                                                    exist = i;
                                                }
                                            }
                                            boolean fd = true;

                                            //  if(database.Drivers.get(exist).getRole()=="driver")
                                            //{
                                            System.out.println(" ---------------------- ");
                                            System.out.println("Hello: " + username);
                                            while (fd) {

                                                System.out.println("1) Add favorite area");
                                                System.out.println("2) My rates");
                                                System.out.println("3) Requested Rides");
                                                System.out.println("4) List of all rides");
                                                System.out.println("5) Logout");
                                                int function = input.nextInt();
                                                switch (function) {
                                                    case 1: {
                                                        System.out.println("Enter the area you want to add to the list");
                                                        Boolean satisfied = false;
                                                        while (satisfied == false) {
                                                            String area = input.next();
                                                            d1.FavouritAreas.add(area);
                                                            System.out.println("FA: " + d1.FavouritAreas.size());
                                                            System.out.println("Add another area");
                                                            System.out.println("1) yes");
                                                            System.out.println("2) No");
                                                            int x = input.nextInt();
                                                            if (x == 1) {
                                                                satisfied = false;
                                                            } else if (x == 2) {
                                                                satisfied = true;
                                                            } else {
                                                                System.out.println("Please enter a valid input");
                                                            }
                                                        }

                                                        break;
                                                    }
                                                    case 2: {
                                                        DC.showRates();
                                                        break;
                                                    }
                                                    case 3:{

                                                        for (int i=0; i< DC.getDriver().Requestedrides.size(); i++)
                                                        {
                                                            System.out.println("Enter "+(i+1) +" To accept Request Ride From "+DC.getDriver().Requestedrides.get(i).getSource() +" To "+DC.getDriver().Requestedrides.get(i).getDestnation()+
                                                                    " With "+ DC.getDriver().Requestedrides.get(i).getNumOfPassengers() + " Passengers !");
                                                        }

                                                        for (int i = 0; i <  DC.getDriver().Requestedrides.size(); i++) {
                                                            System.out.println("Enter Choice");
                                                            int choose = input.nextInt();

                                                            DC.acceptRequestRide( DC.getDriver().Requestedrides.get(i));

                                                        }


                                                        break;
                                                    }
                                                    case 4: {
                                                        System.out.print("Your Rides : ");
                                                        for (int y = 0; y < d1.AllRidesInFavAreas.size(); y++) {
                                                            System.out.println(d1.AllRidesInFavAreas.get(y));
                                                        }
                                                        break;
                                                    }
                                                    case 5: {
                                                        fd = false;
                                                        break;

                                                    }
                                                    default: {
                                                        System.out.println("Please enter a valid input");
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                            // }
                                        }
                                    }
                                    case 2: {
                                        System.out.println("enter your username");
                                        String username = input.next();
                                        System.out.println("enter your Passaword");
                                        String pass = input.next();
                                        Boolean z = Pc.Login(username, pass);

                                        if (z == true) {
                                            exist = -1;
                                            for (int i = 0; i < database.Passengers.size(); i++) {
                                                if (username.equals(database.Passengers.get(i).getUser_name())) {
                                                    exist = i;
                                                }
                                            }
                                            boolean fP = true;
                                            System.out.println(" ----------------- ");
                                            System.out.println("Hello: " + username);
                                            while (fP) {
                                                System.out.println("1) Request a trip");
                                                System.out.println("2) logout");
                                                int cH = input.nextInt();
                                                switch (cH) {

                                                    case 1: {
                                                        if (database.Drivers.size() == 0) {
                                                            System.out.println("No Trips yet! :(");
                                                        } else {
                                                            System.out.println("please enter your source");
                                                            String src = input.next();
                                                            System.out.println("please enter your Destnation");
                                                            String dest = input.next();
                                                            System.out.println("please enter number of passengers");
                                                            int num = input.nextInt();

                                                            //DC.setPassengerController(Pc);
                                                           // Pc.setDC(DC);
                                                            Ride R= new Ride();
                                                            Pc.setPassenger(p1);
                                                            DC.setDriver(d1);
                                                            R.setPassengerController(Pc);
                                                            R.setSource(src);
                                                            R.setDestnation(dest);
                                                            R.setNumOfPassengers(num);
                                                            Pc.request(R);

                                                            // d1.Match(src);
                                                            // d1.notify(src);
                                                       /*System.out.println("Your offers are : [");
                                                       for (int i = 0; i < d1.notify(src).size(); i++) {
                                                           System.out.println(d1.notify(src).get(i) + " , ");
                                                       }
                                                       System.out.println(" ]");*/

                                                           // Pc.accept();
                                                            //  p1.rate(d1);
                                                        }
                                                        break;
                                                    }
                                                    case 2: {
                                                        fP = false;
                                                        break;
                                                    }
                                                }
                                            }


                                            break;
                                        }
                                    }
                                }
                            }
                            else if(role == 2)
                            {
                                boolean F=true;
                                System.out.println("enter your username");
                               String username = input.next();
                               System.out.println("enter your Passaword");
                              String  pass = input.next();

                                Boolean z =   Ac.Login(username, pass);

                               if(z==true){
                                   System.out.println("Hello:  " + username);
                                   while(F){

                                       System.out.println("1) Verfiy Account");
                                       System.out.println("2) Suspend Account");
                                       System.out.println("3) logout");
                                       int function = input.nextInt();
                                       switch(function){
                                           case 1:
                                           {
                                               Ac.setDatabase(database);
                                               Ac.verfiy();
                                               for(int i =0;i<database.Drivers.size();i++){

                                                   System.out.println(database.Drivers.get(i).getUser_name()+ database.Drivers.get(i).getRole());

                                               }
                                             //  d1.getDriver();
                                               break;
                                           }
                                           case 2 :
                                           {
                                               Ac.setDatabase(database);
                                               Ac.suspend();
                                               break;

                                           }
                                           case 3:
                                           {
                                               F=false;
                                           }

                                       }
                                   }


                            }
                            }
                            else
                            {
                                System.out.println("Please enter a valid input");
                                Role = false;
                            }
                            break;
                            }
                            break;
                        }
                        default:
                        {
                            System.out.println("Please enter a valid input");
                            break;
                        }
                    }
            
            
        }
        for(Map.Entry<Integer,String> mm:offerPrices.entrySet()){
            System.out.println("MMMMM "+ mm.getKey()+" "+ mm.getValue());
        }


    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package in_driver;


        import java.util.Scanner;

public class In_driver {
    public static void main(String[] args) {


        Admin ad = new Admin();
        Driver d1 = new Driver();
        UserData u1 = new UserData();
        Passenger p1 = new Passenger();
        p1.setAd(ad);
        d1.setAd(ad);
        u1.setAd(ad);
        ad.addAdmin("ameer","311");
        ad.addAdmin("menna", "101");
        ad.addAdmin("medhat", "1811");
        ad.addAdmin("suad", "102");

        int exist=-1;
        int  inverifed=-1;
        System.out.println("Welcome !");
        Scanner input = new Scanner(System.in);
        Boolean flag = true;
        while(flag)
        {
            System.out.println("Choose one of the following choices");
            System.out.println("1) Sign up");
            System.out.println("2) Login");
            int choice = input.nextInt();
            switch(choice)
            {

                case 1:
                {
                    Boolean Role = true;
                    while(Role == true){
                        System.out.println("Choose one of the following roles");
                        System.out.println("1) Passenger");
                        System.out.println("2) Driver");
                        int role = input.nextInt();

                        if(role == 1)
                        {
                            p1.signup();
                            ad.addpass(p1);
                            p1=new Passenger();
                            break;
                        }
                        else if(role == 2)
                        {
                            d1.signup();
                            ad.needverfiy(d1);
                            d1 = new Driver();
                            for(int i =0;i<ad.AllAccounts.size();i++){

                                System.out.println(ad.AllAccounts.get(i).getUser_name()+ ad.AllAccounts.get(i).getRole());

                            }




                            break;
                        }
                        else
                        {
                            System.out.println("Please enter a valid input");
                            Role = true;
                        }

                    }

                    break;
                }
                case 2:
                {
                    Boolean Role = true;
                    while(Role ){
                        System.out.println("Choose one of the following roles");
                        System.out.println("1) User");
                        System.out.println("2) Admin");
                        int role = input.nextInt();
                        if(role == 1)
                        {
                            System.out.println("enter your username");
                            String username = input.next();
                            System.out.println("enter your Passaword");
                            String  pass = input.next();
                            Boolean z = u1.Login(username, pass);
                            for(int i =0 ; i < ad.inverifedaccounts.size() ; i++)
                            { //System.out.println(ad.AllAccounts.get(i).getRole());
                                // System.out.println("........");
                                //System.out.println (ad.AllAccounts.get(i).getUser_name());


                                if(username.equals(ad.inverifedaccounts.get(i).getUser_name())){
                                    inverifed=i;
                                }    }
                            if(inverifed!=-1){ System.out.println("your Account is not verifed yet"
                                    + "please wait an admin verify you soon ");}
                            inverifed=-1;
                            if(z ==true){
                                exist=-1;
                                for(int i =0 ; i < ad.AllAccounts.size() ; i++)
                                { //System.out.println(ad.AllAccounts.get(i).getRole());
                                    // System.out.println("........");
                                    //System.out.println (ad.AllAccounts.get(i).getUser_name());


                                    if(username.equals(ad.AllAccounts.get(i).getUser_name())){
                                        exist=i;
                                    }   }
                                if(ad.AllAccounts.get(exist).getRole()=="driver")
                                {
                                    System.out.println("Hello         " + username);
                                    System.out.println("1) Add favorite area");
                                    System.out.println("2) My rates");
                                    System.out.println("3) List of all rides");
                                    int function = input.nextInt();
                                    switch(function)
                                    {
                                        case 1:
                                        {
                                            System.out.println("Enter the area you want to add to the list");
                                            Boolean satisfied = false;
                                            while(satisfied == false)
                                            {
                                                String area = input.next();
                                                d1.FavouritAreas.add(area);
                                                System.out.println("Add another area");
                                                System.out.println("1) yes");
                                                System.out.println("2) No");
                                                int x = input.nextInt();
                                                if(x == 1)
                                                {
                                                    satisfied = false;
                                                }
                                                else if(x == 2)
                                                {
                                                    satisfied = true;
                                                }
                                                else
                                                {
                                                    System.out.println("Please enter a valid input");
                                                }
                                            }

                                            break;
                                        }
                                        case 2:
                                        {
                                            for(int y = 0 ; y < d1.HisRates.size() ; y ++)
                                            {
                                                System.out.println(d1.HisRates.get(y));
                                            }
                                            break;
                                        }
                                        case 3:
                                        {
                                            System.out.println(d1.AllRidesInFavAreas.size());
                                            for(int y = 0 ; y < d1.AllRidesInFavAreas.size() ; y ++)
                                            {
                                                System.out.println(d1.AllRidesInFavAreas.get(y));
                                            }
                                            break;
                                        }
                                        default:
                                        {
                                            System.out.println("Please enter a valid input");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else
                                {
                                    System.out.println("Hello       " + username);
                                    System.out.println("Request a trip");
                                    System.out.println("please enter your source");
                                    String src = input.next();
                                    System.out.println("please enter your Destnation");
                                    String dest = input.next();
                                    p1.request( src , dest);
                                    d1.Match(src);
                                     /*
                                     Database D1= new Database();
                                     d1.Match(src,D1.Driver)



                                     */
                          /*          System.out.println("Your offers are : " +  d1.notify(src) );

                                    p1.accept();
                                    p1.rate (d1);
                                    break;
                                }
                            }
                        }

                        else if(role == 2)
                        {
                            System.out.println("enter your username");
                            String username = input.next();
                            System.out.println("enter your Passaword");
                            String  pass = input.next();

                            boolean z =   ad.Login(username, pass);
                            if(z==true){
                                System.out.println("Hello         " + username);
                                System.out.println("1) Verfiy Account");
                                System.out.println("2) Suspend Account");
                                int function = input.nextInt();
                                switch(function){
                                    case 1:
                                    {
                                        ad.verfiy();
                                    }
                                    case 2 :
                                    {
                                        ad.suspend(u1);

                                    }

                                }

                            }
                        }
                        else
                        {
                            System.out.println("Please enter a valid input");
                            Role = false;
                        }
                        break;
                    }
                    break;
                }
                default:
                {
                    System.out.println("Please enter a valid input");
                    break;
                }
            }


        }*/