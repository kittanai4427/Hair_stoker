package com.example.hair1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginUser extends AppCompatActivity {
    private ImageButton btnback;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        btnback = (ImageButton)findViewById(R.id.btnback1);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginuser();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backmain();
            }
        });
    }
    public void backmain(){
        Intent backLogin = new Intent(LoginUser.this, MainActivity.class);
        startActivity(backLogin);

    }
    public void loginuser(){
        Intent loginu = new Intent(LoginUser.this, HomeUser.class);
        startActivity(loginu);
    }
}