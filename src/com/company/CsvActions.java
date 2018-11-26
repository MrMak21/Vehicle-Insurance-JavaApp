package com.company;



import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CsvActions {

    //Csv variables
    String csvfile = "C:\\Users\\panos\\Desktop\\Dbcsv\\Db_records.csv";
    BufferedReader br = null;
    String line = "";
    String csvSPlit = ",";


    //List making
    List<String> names = new ArrayList<String>();
    List<String> sign = new ArrayList<String>();
    List<String> isValid = new ArrayList<String>();
    List<String> date = new ArrayList<String>();
    List<String> vehicle = new ArrayList<String>();


    public void f1(String inp){
        try{
            int remove_first_line = 0; //Don't read 1st line from csv..
            int counter = 0;

            br = new BufferedReader(new FileReader(csvfile));

            while((line = br.readLine())!= null){
                //First line break
                if(remove_first_line == 0){
                    remove_first_line++;
                    continue;
                }
                //use comma as separator
                String[] words = line.split(csvSPlit);

                //Adding in lists
                names.add(words[1]);
                sign.add(words[2]);
                date.add(words[3]);
                isValid.add(words[4]);
                vehicle.add(words[5]);
            }


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Check if the plate is in the lists
        int index = 0;
        boolean flag = false;
        for (int i =0;i<sign.size();i++){
            if(sign.get(i).equals(inp)){
                index = i;
                flag = true;
            }
        }

        //Write to csv file
        final String COMMA = ",";
        final  String FILE_HEADER = "Name,Sign,Date,isValid,Vehicle";
        final String NEW_LINE_SEPARATOR = "\n";

        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter("C:\\Users\\panos\\Desktop\\Dbcsv\\mak.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            if(flag == true){
                fileWriter.append(String.valueOf(names.get(index)));
                fileWriter.append(COMMA);
                fileWriter.append(String.valueOf(sign.get(index)));
                fileWriter.append(COMMA);
                fileWriter.append(String.valueOf(date.get(index)));
                fileWriter.append(COMMA);
                fileWriter.append(String.valueOf(isValid.get(index)));
                fileWriter.append(COMMA);
                fileWriter.append(String.valueOf(vehicle.get(index)));
                fileWriter.append(COMMA);


            }




        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }



        //Check for output in the console
        if(flag == true){
            System.out.println("This car belongs to " + names.get(index) + " with the plate "+sign.get(index)+" and it is expired on "+ date.get(index));

        }else{
            System.out.println("We didn't find it..");
        }




    }


    public void f2(int days){

        try{
            int remove_first_line = 0; //Don't read 1st line from csv..

            br = new BufferedReader(new FileReader(csvfile));

            while((line = br.readLine())!= null){
                //First line break
                if(remove_first_line == 0){
                    remove_first_line++;
                    continue;
                }
                //use comma as separator
                String[] words = line.split(csvSPlit);

                //Adding in lists
                names.add(words[1]);
                sign.add(words[2]);
                date.add(words[3]);
                isValid.add(words[4]);
                vehicle.add(words[5]);
            }


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Make the new day
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        java.util.Date timenow = c.getTime();
        String timenow2 = sdf.format(c.getTime());
        c.setTime(new java.util.Date());
        c.add(Calendar.DATE,days);
        String output = sdf.format(c.getTime());


        //Write to csv file
        final String COMMA = ",";
        final  String FILE_HEADER = "Name,Sign,Date,isValid,Vehicle";
        final String NEW_LINE_SEPARATOR = "\n";

        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter("C:\\Users\\panos\\Desktop\\Dbcsv\\mak.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            for(int i =0;i<date.size();i++) {
                if (date.get(i).compareTo(timenow2) >= 0 && date.get(i).compareTo(output) <= 0) {
                    fileWriter.append(String.valueOf(names.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(sign.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(date.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(isValid.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(vehicle.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            }
        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }






        System.out.println("time now is "+timenow2);
        System.out.println("new time is "+output);

        System.out.println("\nThe vehicles that are going to expire between "+timenow2 +" and "+ output +" are:");
        System.out.println("-------------------------------------------------------------------------------------");

        for(int i=0;i<date.size();i++){
            if (date.get(i).compareTo(timenow2)>=0 && date.get(i).compareTo(output)<=0 ){
                System.out.println(names.get(i)+ " at "+date.get(i));

            }
        }
        System.out.println("--------------------------------------------------------------------------------------");




    }














    public void f3(){
        try{
            int remove_first_line = 0; //Don't read 1st line from csv..
            int counter = 0;

            br = new BufferedReader(new FileReader(csvfile));

            while((line = br.readLine())!= null){
                //First line break
                if(remove_first_line == 0){
                    remove_first_line++;
                    continue;
                }
                //use comma as separator
                String[] words = line.split(csvSPlit);

                //Adding in lists
                names.add(words[1]);
                sign.add(words[2]);
                date.add(words[3]);
                isValid.add(words[4]);
                vehicle.add(words[5]);


                System.out.println("Name is : "+words[1]+" with sign : "+words[2]);
                counter++;
            }


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Make keno
        System.out.println("\n \n");

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
        for (int i=0;i <names.size();i++){
            if (isValid.get(i).equals("0")) /*Check if is expired or not..*/{
                System.out.println("Name is : " + names.get(i) + " sign is : " + sign.get(i) + " date is : "+ date.get(i)+" and has a "+vehicle.get(i));
            }
        }

        //Write to csv file
        final String COMMA = ",";
        final  String FILE_HEADER = "Name,Sign,Date,isValid,Vehicle";
        final String NEW_LINE_SEPARATOR = "\n";

        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter("C:\\Users\\panos\\Desktop\\Dbcsv\\mak.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            for(int i =0;i<date.size();i++) {
                if (isValid.get(i).equals("0")) {
                    fileWriter.append(String.valueOf(names.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(sign.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(date.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(isValid.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(String.valueOf(vehicle.get(i)));
                    fileWriter.append(COMMA);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            }
        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }

    }
}
