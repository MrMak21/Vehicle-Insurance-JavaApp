package com.company.Domain;

import java.util.Date;

public class Person extends Vehicle {
    private String name;





    public Person(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public Person(String name,String Sign, Date date, boolean isValid, String vehicle_name) {
        super(Sign, date, isValid, vehicle_name);
        this.name = name;
    }
}
