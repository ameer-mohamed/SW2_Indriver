package com.example.swv55;

import java.util.ArrayList;

public class UserData implements User{
    int mob_number=0;
    String Email;
    String role;
    String source;
    String destnation;
    String user_name ;
    String passaword ;
    Admin ad = new Admin();
    

   @Override
    public Boolean Login(String Username, String pass) {
        // Admin ad = new Admin();
        Boolean loginTest = false;
        for(int i=0;i<ad.AllAccounts.size();i++){
            

            if(Username.equals(ad.AllAccounts.get(i).getUser_name()) && pass.equals(ad.AllAccounts.get(i).getPassword()) ){
                 System.out.print(ad.AllAccounts.get(i).getUser_name());
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

    public void setAd(Admin ad) {
        this.ad = ad;
    }

    public Admin getAd() {
        return ad;
    }






    @Override
    public ArrayList<User> getSigndupAccounts() {
        return User.signedaccounts;
    }

    @Override
    public void signup() {
        System.out.println("Sign-up here");
    }



    @Override
    public void setSignedaccounts(User acc) {
        signedaccounts.add(acc);

    }

    @Override
    public void getSignedaccounts() {

        for (User signedaccount : signedaccounts) {
            System.out.println(signedaccounts.size());
            System.out.println( signedaccount.getUser_name());
            System.out.println( signedaccount.getPassword());

            System.out.println( signedaccount.getMob_number());

            System.out.println( signedaccount.getEmail());



        }
        // return null;
    }
    @Override
    public void setUser_name(String user_name) {
        this.user_name= user_name;
    }


    @Override
    public String getUser_name() {
        return this.user_name;
    }

    @Override
    public void setPassaword(String password) {
        this.passaword = password;
    }

    @Override
    public String getPassword() {
        return this.passaword;
    }


    @Override
    public void setMob_number(int mob_number) {
        this.mob_number=mob_number;
    }

    @Override
    public int getMob_number() {
        return mob_number;
    }

    @Override
    public void setEmail(String Email) {
        this.Email=Email;
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setRole(String role) {
        this.role=role;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setSource(String source) {
        this.source=source;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void setDestnation(String destnation) {
        this.destnation=destnation;
    }

    @Override
    public String getDestnation() {
        return destnation;
    }

}
