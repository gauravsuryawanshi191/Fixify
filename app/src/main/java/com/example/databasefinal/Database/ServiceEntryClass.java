package com.example.databasefinal.Database;

public class ServiceEntryClass {

    String serviceType,serviceLocation,servicePrice,serviceMobileNo,serviceAadharNo;

    public ServiceEntryClass(){}

    public ServiceEntryClass(String serviceType, String serviceLocation, String servicePrice, String serviceMobileNo, String serviceAadharNo) {
        this.serviceType = serviceType;
        this.serviceLocation = serviceLocation;
        this.servicePrice = servicePrice;
        this.serviceMobileNo = serviceMobileNo;
        this.serviceAadharNo = serviceAadharNo;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceMobileNo() {
        return serviceMobileNo;
    }

    public void setServiceMobileNo(String serviceMobileNo) {
        this.serviceMobileNo = serviceMobileNo;
    }

    public String getServiceAadharNo() {
        return serviceAadharNo;
    }

    public void setServiceAadharNo(String serviceAadharNo) {
        this.serviceAadharNo = serviceAadharNo;
    }
}
