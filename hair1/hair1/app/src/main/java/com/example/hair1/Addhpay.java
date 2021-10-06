package com.example.hair1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Addhpay extends AppCompatActivity {
    private ImageView btnback1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpay_user);

        btnback1 =(ImageView) findViewById(R.id.btnback1);

        btnback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

    }

    public void back(){
        Intent back2 = new Intent(Addhpay.this, HomeUser.class);
        startActivity(back2);
    }
}