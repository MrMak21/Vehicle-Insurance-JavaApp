package com.company;




import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        //Connect to database
        DbConn connection = new DbConn();
        connection.connect();
        Scanner input = new Scanner(System.in);


        //Menu
        System.out.println("Hello.. You want to work with our database or with csv sheets?\n--------------------------------------------------------------------\n 1 --> Database.\n 2--> Csv files. ");
        int first_input = input.nextInt();
        if (first_input == 1){
            System.out.println("-Select funcionality to perform\n-------------------------------------\n 1) Vehicle Insurance status \n 2) Forecoming Expiries \n 3) Expiries by plate(ordering in asc)\n");
            int user_choice;
            user_choice = input.nextInt();
            if (user_choice == 1){
            //F1
            System.out.println("Hello.. Give me your plate..\n");
            String inp;
            inp = input.next();
            connection.f1(inp);
            }else if (user_choice == 2) {
                //F2
                System.out.println("Give me days");
                int user_inp = input.nextInt();
                connection.f2(user_inp);
            }else if (user_choice == 3){
                //F3
                connection.f3();

            }else if (user_choice ==4){
                //F$

        }
        //Work with csv
    }else if(first_input == 2){

            System.out.println("-Select funcionality to perform\n-------------------------------------\n 1) Vehicle Insurance status \n 2) Forecoming Expiries \n 3) Expiries by plate(ordering in asc)\n");
            int user_choice;
            user_choice = input.nextInt();

            //Create csv object
            CsvActions csv = new CsvActions();

            if(user_choice == 1){
                //F1
                System.out.println("Please give the plates you want to find");
                String inp = input.next();
                csv.f1(inp);
            }else if (user_choice == 2){
                //F2
                System.out.println("Please give me the days");
                int days = input.nextInt();
                csv.f2(days);
            }else if (user_choice == 3){
                //F3
                csv.f3();
            }else if (user_choice == 4){
                //F4
            }
        }

        System.out.println("\nThank you for supporting us!!");
    }
}
