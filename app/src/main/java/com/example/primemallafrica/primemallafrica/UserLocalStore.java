package com.example.primemallafrica.primemallafrica;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore (Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData (User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("Fullname", user.Fullname);
        spEditor.putString("Username", user.Username);
        spEditor.putString("Email", user.Email);
        spEditor.putString("Password", user.Password);
        spEditor.putInt("Phone", user.Phone);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String Fullname = userLocalDatabase.getString("Fullname", "");
        String Username = userLocalDatabase.getString("Username", "");
        String Email = userLocalDatabase.getString("Email", "");
        String Password = userLocalDatabase.getString("Password", "");
        int Phone = userLocalDatabase.getInt("Phone",-1);

        User storedUser = new User(Fullname, Username, Email, Password, Phone);

        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn", false) == true){
            return true;
        }
        else {
            return false;
        }
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
