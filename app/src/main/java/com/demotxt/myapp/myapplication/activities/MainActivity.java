package com.demotxt.myapp.myapplication.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.demotxt.myapp.myapplication.R;


public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText) findViewById(R.id.etname);
        Password = (EditText) findViewById(R.id.etpassword);
        Login = (Button) findViewById(R.id.btnlogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondActivity(Name.getText().toString(),Password.getText().toString());
            }
        });


    }

    public void secondActivity(String username,String password) {
        if ((username.equals("admin"))&&(password.equals("1234"))) {

            Intent intent = new Intent(MainActivity.this, PizzaMenu.class);
            startActivity(intent);
        }
    }
}



