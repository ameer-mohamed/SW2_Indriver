package com.example.swv55;



import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends UserData{



    String drivingLicennse;
    int nationalld;
    int mob_number=0;
    String Email;
    String role;
    String user_name ;
    String passaword ;

int offerPrice;



    public static ArrayList<String>FavouritAreas=new ArrayList<String>();
    public static  ArrayList<Integer>Offers=new ArrayList<Integer>();
   public static ArrayList<Driver> Driver = new ArrayList<Driver>();
    public static ArrayList<String>AllRidesInFavAreas=new ArrayList<String>();
    public static ArrayList<Integer>AverageRates=new ArrayList<Integer>();
   public   ArrayList<Integer>HisRates=new ArrayList<Integer>();
   
    Passenger passenger;
     int rate;
    int averageRating;



    void setOfferPrice(int P){
        this.offerPrice = P;
        this.Offers.add(P);
    }

    int getOfferPrice(){
        return offerPrice;
    }

    public void setDrivingLicennse(String DL)
    {
        this.drivingLicennse=DL;
    }
    public String getDrivingLicennse()
    {
        return drivingLicennse;
    }

    public void setnationalld(int n)
    {
        this.nationalld=n;
    }
    public int getnationalld()
    {
        return nationalld;
    }


    public void setRates(int rates)
    {
        this.rate=rates;
        this.HisRates.add(rates);

    }
    public int getRate()
    {
        return this.rate;
    }

    public void setaverageRating()
    {
        int sum=0;
       for (int i=0 ; i< this.HisRates.size(); i++){
            sum += HisRates.get(i);
       }
       this.averageRating = sum/this.HisRates.size();
       this.AverageRates.add(this.averageRating);
    }
    public int getaverageRating()
    {
        return averageRating;
    }

    Passenger getPassenger () {
        return null;

    }
/*
    public  void showRates(){
        for(int i=0 ; i< Driver.size();i++ ){
            if(Driver.get(i).getRate() == 0){
                System.out.println("No Rating here :(");
                break;
            }
            else{
                for (int j =0 ; j< Driver.get(j).HisRates.size() ; j++){
                   // System.out.println("DU"+this.getDriver().getUser_name());
                    System.out.println(this.HisRates.get(j));
                }
            }
        }
      /*  for (int i =0 ; i< this.getDriver().HisRates.size() ; i++){
             System.out.println("DU"+this.getDriver().getUser_name());
            System.out.println(this.getDriver().HisRates.get(i));
        }-
    }*/

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

    public ArrayList<Driver> getDriver(){
       for(int i=0 ;i <getAd().AllAccounts.size();i++){
           if((getAd().AllAccounts.get(i).getRole()).equals("driver") && !(Driver.contains(getAd().AllAccounts.get(i)))){

               Driver.add((Driver) getAd().AllAccounts.get(i));
           }
       }

        return Driver;
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


 @Override
      public void setSignedaccounts(User x){
      
      this.signedaccounts.add(x) ;
 
      }


    @Override
    public void getSignedaccounts() {

        for (User signedaccount : signedaccounts) {
            //System.out.println(signedaccounts.size());

            System.out.println( this.getDrivingLicennse());
            System.out.println( this.getnationalld());


        }
        // return null;
    }

    public void signup() {

      
        this.setRole("driver");
        Scanner input = new Scanner(System.in);
        System.out.println("EnterUserNAme");
        String name = input.nextLine();
        this.setUser_name(name);
        System.out.println("Enter pass");
        String password =  input.nextLine();
        this.setPassaword(password);
        System.out.println("Enter Email");
        String email = input.nextLine();
        this.setEmail(email);
        System.out.println("Enter mob");
        int mobile =input.nextInt();
        this.setMob_number(mobile);
        System.out.println("Enter Driving Licesnse");
        String Dl= input.next();
        this.setDrivingLicennse(Dl);
        System.out.println("Enter National ID");
        int ID = input.nextInt();
        this.setnationalld(ID);
       
       System.out.println( ".........");
       // getAd().AllAccounts.add(this);
        this.setSignedaccounts(this);
        
        
        
        
        
    }

    




}
