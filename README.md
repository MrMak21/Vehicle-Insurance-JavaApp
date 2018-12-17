# Vehicle-Insurance-JavaApp
Development of a Java application, covering all the functional specs of a real life scenario of vehicle’s insurance and ownership information.

**Code.Hub Project 1**

Overview: This repository contains the final outcome of our team project, regarding the 1st Java assignment of [Code.Hub's, Java | Spring bootcamp scholarship by Piraeus Bank] (https://www.projectfuture.gr) .

The purpose of this exercise was to confirm, justify and consolidate all the learning outcomes, obtained during the Java Section of the course, i.e. Algorithm Design, Java Language Fundamentals and DB & SQL Usage.

Description: The test case aimed at developing a Java application, covering all the functional specs of a real life scenario of vehicle’s insurance and ownership information.

When inserting a vehicle's registration plate by the user (command line argument), the application could respond with the vehicle’s insurance status. In case of wrong input, it provided an error message, accordingly.

Additionally, when inserting a timeframe (in days), the application would provide a list of all the vehicles' licenses from the database or .csv file, which would expire, within this timeframe. The user could also select the export format of the output (console or exported .csv file).

The application was also able to provide the plate numbers, in alphanumerical order. The algorithm to sort plate numbers in ascending alphanumeric natural manner was implemented in Java and not via DB-prepared ordered result.

In case an owner had one or more uninsured vehicles, the application would calculate the total fine cost, according to a fine which was provided as an argument in the prompt.
