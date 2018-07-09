package com.example.primemallafrica.primemallafrica;

import android.app.ProgressDialog;
import android.content.Context;

import java.security.PublicKey;

public class ServerRequests {

    ProgressDialog progressDialog;      //shows a loading bar when the request is being executed
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://localhost/primemall_africa/";

    public ServerRequests(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void storeUserDataInBackground(User user, GetUserCallback callback) {

    }
    public void fetchUserDataInBackground(User user, GetUserCallback callback) {

    }
}