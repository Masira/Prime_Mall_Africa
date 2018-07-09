package com.example.primemallafrica.primemallafrica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{
    Button btnRegister;
    EditText etFullname, etUsername, etPhone, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFullname = (EditText) findViewById(R.id.etFullName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister:

                String Fullname = etFullname.getText().toString();
                String Username = etUsername.getText().toString();
                int Phone = Integer.parseInt(etPhone.getText().toString());
                String Email = etEmail.getText().toString();
                String Password = etPassword.getText().toString();

                User registeredData = new User(Fullname, Username, Phone, Email, Password);

                break;
        }
    }
}
