package com.company.Menu;

import com.company.Csv_Files.CsvActions;
import com.company.DataBase.DbConn;

import java.util.Scanner;

public class Menu {

    public static void MainMenu() {
        //Connect to database
        DbConn connection = new DbConn();
        connection.connect();
        Scanner input = new Scanner(System.in);
        int userInput;

        //Menu
        System.out.println("Hello.. You want to work with our database or with csv sheets?\n--------------------------------------------------------------------\n 1 --> Database.\n 2--> Csv files. ");
        int first_input = input.nextInt();
        if (first_input == 1) {
            System.out.println("----Select functionality to perform:----\n*1 Vehicle Insurance Status\n*2 Forecoming expiries\n*3 Expiries by plate\n*4 Fine calculation");

            do {
                userInput = input.nextInt();
                if (!(userInput >= 1 && userInput <= 4)) {
                    System.out.println("Please enter a number between 1-4");
                }
            } while (!(userInput >= 1 && userInput <= 4));

            if (userInput == 1) {
                //F1
                System.out.println("Enter your plate number\n");
                String pattern = "[A-Z]{3}[-][0-9]{4}";
                if (input.hasNext(pattern)) {
                    String plate = input.next(pattern);
                    connection.f1(plate);
                } else {
                    System.out.println("Wrong plate format");
                }
            } else if (userInput == 2) {
                    //F2
                    System.out.println("Enter days");
                    int user_inp_days = input.nextInt();
                    connection.f2(user_inp_days);
            } else if (userInput == 3) {
                    //F3
                    connection.f3();

            } else if (userInput == 4) {
                    //F4
                    connection.f4();

                }


        } else if (first_input == 2) {
            System.out.println("----Select functionality to perform:----\n*1 Vehicle Insurance Status\n*2 Forecoming expiries\n*3 Expiries by plate\n*4 Fine calculation");

            do {
                userInput = input.nextInt();
                if (!(userInput >= 1 && userInput <= 4)) {
                    System.out.println("Please enter a number between 1-4");
                }
            } while (!(userInput >= 1 && userInput <= 4));

            //Create csv object
            CsvActions csv = new CsvActions();

            if(userInput == 1){
                //F1
                System.out.println("Enter plates");
                String inp = input.next();
                csv.f1(inp);
            }else if (userInput == 2){
                //F2
                System.out.println("Enter days");
                int days = input.nextInt();
                csv.f2(days);
            }else if (userInput == 3){
                //F3
                csv.f3();
            }else if (userInput == 4){
                //F4
            }




        }
        }

    }

