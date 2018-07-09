package com.example.primemallafrica.primemallafrica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etFullname, etUsername, etPhone, etEmail;
    Button btnLogout;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFullname = (EditText) findViewById(R.id.etFullName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }
    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate() == true){
            dispalyUserDetails();
        } else {
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }
    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }
    private void dispalyUserDetails(){
        User user = userLocalStore.getLoggedInUser();
        etFullname.setText(user.Fullname);
        etUsername.setText(user.Username);
        etPhone.setText(user.Phone + "");
        etEmail.setText(user.Email);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogout:

                userLocalStore.setUserLoggedIn(false);
                startActivity(new Intent (this, Login.class));
                break;
        }
    }
}
