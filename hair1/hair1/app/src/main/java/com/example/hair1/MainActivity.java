package com.example.hair1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnapply;
    private Button btnlogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnapply = (Button) findViewById(R.id.btnapply);
        btnlogin = (Button) findViewById(R.id.btnlogin) ;
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });
        btnapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterUser();
            }
        });
    }
    public void openRegisterUser() {
        Intent register = new Intent(MainActivity.this, register_user.class);
        startActivity(register);

    }
    public void openlogin(){
        Intent Login = new Intent(MainActivity.this, LoginUser.class);
        startActivity(Login);
    }


}