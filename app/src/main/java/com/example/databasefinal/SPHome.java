package com.example.databasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SPHome extends AppCompatActivity {

    Button button1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_home);

        textView= findViewById(R.id.userdata);
        button1= findViewById(R.id.btn_addService);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), AddService.class);
                startActivity(intent);
                finish();
            }
        });
    }
}