package com.example.databasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.databasefinal.Database.ServiceEntryClass;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddService extends AppCompatActivity {

    TextInputEditText editTextServiceType,editTextServiceLocation,editTextServicePrice,editTextServiceMobileNo,editTextServiceAadharNo;

    Button registerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        editTextServiceType= findViewById(R.id.serviceType);
        editTextServiceLocation= findViewById(R.id.location);
        editTextServicePrice= findViewById(R.id.price);
        editTextServiceMobileNo= findViewById(R.id.mobileNo);
        editTextServiceAadharNo= findViewById(R.id.aadhar);

        registerService=findViewById(R.id.registerService);
        registerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeServiceData();
                Toast.makeText(AddService.this, "Service Added Succesfully", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(),SPHome.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void storeServiceData() {
        DatabaseReference mDatabase;
        mDatabase= FirebaseDatabase.getInstance().getReference();

        String serviceType,serviceLocation,servicePrice,serviceMobileNo,serviceAadharNo;
        serviceType=editTextServiceType.getText().toString();
        serviceLocation=editTextServiceLocation.getText().toString();
        servicePrice=editTextServicePrice.getText().toString();
        serviceMobileNo=editTextServiceMobileNo.getText().toString();
        serviceAadharNo=editTextServiceAadharNo.getText().toString();

        ServiceEntryClass addNewService = new ServiceEntryClass(serviceType,serviceLocation,servicePrice,serviceMobileNo,serviceAadharNo);
        mDatabase.child("Services").child(serviceType).child(serviceMobileNo).setValue(addNewService);
    }
}