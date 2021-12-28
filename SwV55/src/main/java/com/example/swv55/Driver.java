package com.example.swv55;



import java.util.ArrayList;
import java.util.Scanner;

public class Driver implements UserLogin,UserSignUp{
    String user_name ;
    String passaword ;
    int mob_number=0;
    String Email;
    String drivingLicennse;
    int nationalld;
    String role;
    int offerPrice;
    CRUDOperations CD;
    int rate;
    int averageRating;
    public static ArrayList<String>FavouritAreas=new ArrayList<String>();
    public static  ArrayList<Integer>Offers=new ArrayList<Integer>();
  // public static ArrayList<Driver> Driver = new ArrayList<Driver>();
    public static ArrayList<String>AllRidesInFavAreas=new ArrayList<String>();
    public static ArrayList<Integer>AverageRates=new ArrayList<Integer>();
   public   ArrayList<Integer>HisRates=new ArrayList<Integer>();
   


    public void setUser_name(String user_name) {
        this.user_name= user_name;
    }



    public String getUser_name() {
        return this.user_name;
    }


    public void setPassaword(String password) {
        this.passaword = password;
    }


    public String getPassword() {
        return this.passaword;
    }



    public void setMob_number(int mob_number) {
        this.mob_number=mob_number;
    }


    public int getMob_number() {
        return mob_number;
    }


    public void setEmail(String Email) {
        this.Email=Email;
    }


    public String getEmail() {
        return Email;
    }

    public void setRole(String role) {
        this.role=role;
    }

    public String getRole() {
        return role;
    }



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


   /* public void setRates(int rates)
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
*/
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


   /*public ArrayList<Driver> getDriver(){
       for(int i=0 ;i <getAd().AllAccounts.size();i++){
           if((getAd().AllAccounts.get(i).getRole()).equals("driver") && !(Driver.contains(getAd().AllAccounts.get(i)))){

               Driver.add((Driver) getAd().AllAccounts.get(i));
           }
       }

        return Driver;
    }
*/




 /*@Override
      public void setSignedaccounts(User x){
      
      this.signedaccounts.add(x) ;
 
      }*/


   /*
    public void getSignedaccounts() {

        for (User signedaccount : signedaccounts) {
            //System.out.println(signedaccounts.size());

            System.out.println( this.getDrivingLicennse());
            System.out.println( this.getnationalld());


        }
        // return null;
    }*/

   /* public void signup() {

      
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
       


        
        
        
        
        
    }*/


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
    }
   /* public void setAd(Admin ad) {
        this.ad = ad;
    }*/
}
