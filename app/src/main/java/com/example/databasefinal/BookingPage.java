package com.example.databasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.databasefinal.Database.BookingEntryClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookingPage extends AppCompatActivity {

    DatePicker date;
    TimePicker time;
    String username;
    Button bookbtn;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_bookingpage);
        date = findViewById(R.id.orderDate);
        time = findViewById(R.id.orderTime);
        bookbtn = findViewById(R.id.bookbutton);
        user= auth.getCurrentUser();
        username= "gaurav";
        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeRealtimeData();
            }
        });
    }


    private void storeRealtimeData(){
        DatabaseReference mDatabase;
        mDatabase= FirebaseDatabase.getInstance().getReference();

        String fulldate;
        int daydate,monthdate,yeardate;
        daydate=date.getDayOfMonth();
        monthdate=date.getMonth();
        yeardate=date.getYear();
        fulldate= Integer.toString(daydate)+"/"+Integer.toString(monthdate)+"/"+Integer.toString(yeardate);

        String fulltime,z;
        int hour,minute;
        hour=time.getHour();
        minute=time.getMinute();
        if (hour == 0) {
            hour += 12;
            z = "AM";
        } else if (hour == 12) {
            z = "PM";
        } else if (hour > 12) {
            hour -= 12;
            z = "PM";
        } else {
            z = "AM";
        }
        fulltime= Integer.toString(hour)+":"+Integer.toString(minute)+" "+z;

        BookingEntryClass newbooking = new BookingEntryClass(fulldate,fulltime,username);
        mDatabase.child("Orders").child(fulldate).setValue(newbooking);
    }

}