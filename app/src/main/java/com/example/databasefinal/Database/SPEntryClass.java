package com.example.databasefinal.Database;

public class SPEntryClass {

    String userName,email,fullName,service,password;

    public SPEntryClass(){}

    public SPEntryClass(String userName, String email, String fullName, String service, String password) {
        this.userName = userName;
        this.email = email;
        this.fullName = fullName;
        this.service = service;
        this.password = password;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
