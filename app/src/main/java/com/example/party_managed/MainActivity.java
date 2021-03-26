package com.example.party_managed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname, pass;
    String username, password;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.upass);
        mydb = new DatabaseHelper(this);
    }

    public void registerPage(View view) {
        Intent i = new Intent(MainActivity.this, Registration.class);
        startActivity(i);
    }

    public void login(View view) {
        username = uname.getText().toString();
        password = pass.getText().toString();

        if (username.equals("") || password.equals("")){
            Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkuserpass = mydb.checkUsernamePassword(username, password);
            if(checkuserpass == true){
                Toast.makeText(MainActivity.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "User not exists", Toast.LENGTH_SHORT).show();
            }
        }
    }
}