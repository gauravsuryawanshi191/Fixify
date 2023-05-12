package com.example.databasefinal.Database;

public class BookingEntryClass {

    String date,time,username;

    public BookingEntryClass(String date, String time, String username) {
        this.date = date;
        this.time = time;
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
