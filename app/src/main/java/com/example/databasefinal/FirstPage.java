package com.example.databasefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstPage extends AppCompatActivity {
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        button1 = findViewById(R.id.userlogin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FirstPage.this, UserLogin.class);
                startActivity(intent);


            }


        });
        button2 = findViewById(R.id.splogin);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FirstPage.this, SPLogin.class);
                startActivity(intent);


            }


        });
    }
}
