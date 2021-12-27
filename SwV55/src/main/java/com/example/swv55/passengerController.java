package com.example.swv55;

import java.util.Scanner;

public class passengerController {

    Passenger passenger =new Passenger();
    driverController DC = new driverController();
    void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }
    Passenger getPassenger(){
        return passenger;
    }

    void request(String source,String destnation)
    {

        this.source = source;
        this.destnation = destnation;

       /* for(int i = 0 ; i <= driver.Driver.size(); i++)
        {*/

        driver.Match(source);

        /* }*/
    };
    Boolean accept()
    {
        Boolean test = false;

        Scanner sc = new Scanner(System.in);

        int i = 0 ;
        System.out.println("Your offers are : [");
        for (int k = 0; k < driver.Offers.size(); k++) {
            System.out.println(driver.Offers.get(k) + " , ");
        }
        System.out.println(" ]");
        while(test == false)
        {
            System.out.println("Please choose an offer");
            int x = sc.nextInt();
            // driver.setOfferPrice(x);
            for(int z = 0 ; z < driver.Offers.size() ; z++){
                if(driver.Offers.get(z) == x)
                {
                    int y = z+1;
                    System.out.println("The passenger selected the offer of the driver : " + driver.Driver.get(z).getUser_name() );
                    this.setDriver(driver.Driver.get(z));
                    //System.out.println("Dm"+this.getDriver().getUser_name());
                    test = true;
                }

            }
            if(test == false){
                System.out.println("Please enter a valid number");
            }
        }
        driver.Offers.clear();

        rate(this.getDriver());

        this.getDriver().AllRidesInFavAreas.add(this.getSource());
        return test;
    }


    void rate (Driver D)
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


    };
}
