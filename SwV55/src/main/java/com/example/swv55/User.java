package com.example.swv55;

import java.util.ArrayList;

public interface User extends UserLogin {

    ArrayList<User> signedaccounts = new ArrayList<User>();



    void setMob_number(int mob_number);
    int getMob_number();

    void setEmail(String address);
    String getEmail();

    void setRole(String role);
    String getRole();

    void setSource(String source);
    String getSource();

    void setDestnation(String destnation);
    String  getDestnation();

    void setSignedaccounts(User acc);
    void getSignedaccounts();
    ArrayList<User> getSigndupAccounts();
    void signup();


}



