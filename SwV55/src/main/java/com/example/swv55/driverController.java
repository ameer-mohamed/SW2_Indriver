package com.example.swv55;

import java.util.ArrayList;
import java.util.Scanner;

public class driverController {
    Driver driver = new Driver();
    passengerController PC =new passengerController();

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

        for(int i = 0 ; i < Driver.size() ; i++ )
        {
            for(int j = 0 ; j <Driver.get(i).FavouritAreas.size() ; j++)
            {
                //Driver d= new Driver();
                if(source.equals(Driver.get(i).FavouritAreas.get(j)))
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

        System.out.println(Driver.get(index).getUser_name() +"    Please enter an offer");
        Scanner input = new Scanner(System.in);
        int offer = input.nextInt();
        Driver.get(index).setOfferPrice(offer);

        System.out.println("Avarage Rate : " + getaverageRating()+" For "+Driver.get(index).getUser_name()+ " with offer price:  "+ Driver.get(index).getOfferPrice());


        return Offers;

    }


}
