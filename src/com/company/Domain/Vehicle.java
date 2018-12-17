package com.company.Domain;

import java.util.Date;

public class Vehicle {

    private String Sign;
    private Date date;
    private boolean isValid;
    private String vehicle_name;

    public Vehicle(String Sign,Date date,boolean isValid,String vehicle_name) {
        this.Sign = Sign;
        this.date = date;
        this.isValid = isValid;
        this.vehicle_name = vehicle_name;
    }

    public Vehicle() {
    }

    public String getSign() {
        return Sign;
    }

    public Date getDate() {
        return date;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }


}
