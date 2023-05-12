package com.example.databasefinal.Database;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserEntryClass {

    String userName,email,fullName,password,mobielNo,uID,Bdate;

    public UserEntryClass(){}


    public UserEntryClass(String userName, String email, String fullName, String password, String mobileNo, String uID, String Bdate) {
        this.userName = userName;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.mobielNo = mobileNo;
        this.uID = uID;
        this.Bdate = Bdate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobielNo() {return mobielNo; }

    public void setMobielNo(String mobielNo) { this.mobielNo = mobielNo; }

    public String getuID() { return uID; }

    public void setuID(String uID) { this.uID = uID; }

    public String getBdate() { return Bdate; }

    public void setBdate(String Bdate) { this.Bdate = Bdate; }

}
