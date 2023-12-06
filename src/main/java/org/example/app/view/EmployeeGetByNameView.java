package org.example.app.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeGetByNameView {
    private static final Logger logger = LoggerFactory.getLogger(EmployeesGetAllVeiw.class);

    Scanner scanner = new Scanner(System.in);
    public String[] getData(){
        String [] data = new String[2];
        String firstName;
        String lastName;
        do {
            try {
                System.out.println("Please, enter first name: ");
                firstName = scanner.nextLine();
                System.out.println("Please, enter last name: ");
                lastName = scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid name");
                logger.warn(">>> Invalid name: " + e.getMessage());

            }

            // ToDo: Нужно написать условие проверки!
        } while(true);

    }
    public void getOutput(String resultOutput){
        System.out.println(resultOutput);
    }
}
