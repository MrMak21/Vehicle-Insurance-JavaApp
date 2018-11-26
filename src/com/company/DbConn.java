package com.company;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DbConn {


    ResultSet rs;
    Connection conn;
    Statement stmt;
    private int count =1;
    private int days;

    public void connect() {


        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assigment?useSSL=false", "root", "panosaek1997");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Wrong");
        }
    }


        public void f1(String inp){


            try {
                rs = stmt.executeQuery("SELECT * FROM assigment.eforia2 WHERE Sign = '"+inp+"'");
                if (!rs.isBeforeFirst()){
                    System.out.println("Sorry there is no car with this sign..");
                }
                while (rs.next()){
                    String name = rs.getString("Name");
                    String Sign = rs.getString("Sign");
                    Date date = rs.getDate("Date");
                    String vehicle_name = rs.getString("Vehicle");
                    boolean isValid = rs.getBoolean("isValid");

                    //New object Person
                    Person human1 = new Person(name,Sign,date,isValid,vehicle_name);
                    if (human1.isValid()) {
                        System.out.println("This car belongs to "+human1.getName() + " and it is valid until "+human1.getDate());
                    }else{
                        System.out.println("This car belongs to "+ human1.getName() + " and it is expired from "+human1.getDate());
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Don't Exist");
            }

        }

        public  void f2(int days){

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Calendar c = Calendar.getInstance();
            java.util.Date timenow = c.getTime();
            String timenow2 = sdf.format(c.getTime());
            c.setTime(new java.util.Date());
            c.add(Calendar.DATE,days);
            String output = sdf.format(c.getTime());

            System.out.println("time now is "+timenow2);
            System.out.println("new time is "+output);



            try {
                rs = stmt.executeQuery("SELECT * FROM assigment.eforia2 WHERE Date BETWEEN '"+timenow2+"' AND '"+output+"'");
                if (!rs.isBeforeFirst()){
                    System.out.println("Sorry there is no car with this sign..");
                }
                while (rs.next()){
                    String name = rs.getString("Name");
                    String Sign = rs.getString("Sign");
                    Date date = rs.getDate("Date");
                    String vehicle_name = rs.getString("Vehicle");
                    boolean isValid = rs.getBoolean("isValid");


                    //New object Person
                    Person human1 = new Person(name,Sign,date,isValid,vehicle_name);
                    System.out.println(human1.getName());
                    count++;

                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Don't Exist");
            }

        }

        public void f3(){

        //List making
        List<String> names = new ArrayList<String>();
        List<String> sign = new ArrayList<String>();
        List<String> isValid = new ArrayList<String>();
        List<String> date = new ArrayList<String>();
        List<String> vehicle = new ArrayList<String>();



        try {
            rs = stmt.executeQuery("SELECT * FROM assigment.eforia2");

            while(rs.next()){
                names.add(rs.getString("Name"));
                sign.add(rs.getString("Sign"));
                date.add(rs.getString("Date"));
                isValid.add(rs.getString("isValid"));
                vehicle.add(rs.getString("Vehicle"));


            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        //F3 doing
            String temp;
            int compare;
            //Sorting the lists
            for (int i=0;i<sign.size();i++){
                for(int j=1;j<sign.size();j++){
                    compare = sign.get(j).compareTo(sign.get(j-1));
                    if(compare <0){
                        //Sorting Names
                        temp = names.get(j-1);
                        names.set(j-1,names.get(j));
                        names.set(j,temp);
                        //Sorting Sign
                        temp = sign.get(j-1);
                        sign.set(j-1,sign.get(j));
                        sign.set(j,temp);
                        //Sorting isValid
                        temp = isValid.get(j-1);
                        isValid.set(j-1,isValid.get(j));
                        isValid.set(j,temp);
                        //Sorting Date
                        temp = date.get(j-1);
                        date.set(j-1,date.get(j));
                        date.set(j,temp);
                        //Sorting Vehicle
                        temp = vehicle.get(j-1);
                        vehicle.set(j-1,vehicle.get(j));
                        vehicle.set(j,temp);
                    }

                }
            }

            //Printing the lists
            System.out.println("These are the uninsured vehicles\n");
            for (int i=0;i < names.size();i++){
                if (isValid.get(i).equals("0")) {
                    System.out.println("Name is : " + names.get(i) + " sign is : " + sign.get(i) + " date is : "+ date.get(i)+" and has a "+vehicle.get(i));
                }
            }




        }




    }












