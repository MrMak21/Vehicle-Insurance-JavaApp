package com.company;

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

    public void setSign(String sign) {
        Sign = sign;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }
}
