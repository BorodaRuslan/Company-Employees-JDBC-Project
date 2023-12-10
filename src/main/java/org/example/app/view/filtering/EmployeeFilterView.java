package org.example.app.view.filtering;

import org.example.app.repository.Impl.EmployeesFilteringRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeFilterView {

    private static final Logger logger = LoggerFactory.getLogger(EmployeesFilteringRepositoryImpl.class);
    private final Scanner scanner = new Scanner(System.in);

    public int filteringChoice(){

        int userChoice;
        do {
            filterMenu();
            System.out.println("Please enter a number ");

            try {
                userChoice = scanner.nextInt();
                logger.info(">>> Data received from user: " + userChoice);

            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter valid number");
                logger.warn(">>> Received data are incorrect:" + e.getMessage());
                scanner.nextLine();
                userChoice = -1;
            }
        } while (userChoice < 0 || userChoice > 3);
        return userChoice;


    }
    private void filterMenu(){
        System.out.println("""
                
                How do you want to filter out employees?
                
                1.Filtered by gender.
                2.Filtered by positions.
                3.Filtered by salary.
                
                """);
    }

    public void getOutput(String output){
        System.out.println(output);
    }
}
