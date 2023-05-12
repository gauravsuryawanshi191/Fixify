package com.example.databasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceBooking extends AppCompatActivity {

    Button btnCleaning, btnElectrician, btnPlumbing, btnPainting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_booking);
        btnCleaning = findViewById(R.id.btn_serviceCleaning);
        btnElectrician = findViewById(R.id.btn_serviceElectrician);
        btnPlumbing = findViewById(R.id.btn_servicePlumbing);
        btnPainting = findViewById(R.id.btn_servicePainting);

        btnCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), RPaymentMain.class);
                startActivity(intent);
                finish();
            }
        });

        btnElectrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), BookingPage.class);
                startActivity(intent);
                finish();
            }
        });

        btnPlumbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), BookingPage.class);
                startActivity(intent);
                finish();
            }
        });

        btnPainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), BookingPage.class);
                startActivity(intent);
                finish();
            }
        });
    }

}