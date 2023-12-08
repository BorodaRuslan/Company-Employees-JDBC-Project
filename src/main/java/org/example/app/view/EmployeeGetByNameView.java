package org.example.app.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeGetByNameView {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeGetByNameView.class);

    Scanner scanner = new Scanner(System.in);
    public String[] getData(){
        String [] data = new String[2];
        String firstName;
        String lastName;
        do {
            try {
                System.out.println("Please, enter first name: ");
                firstName = scanner.nextLine().trim();
                System.out.println("Please, enter last name: ");
                lastName = scanner.nextLine().trim();

                if (!firstName.isEmpty() && firstName.matches("^[а-яА-ЯёЁ]+$") &&
                        !lastName.isEmpty() && lastName.matches("^[а-яА-ЯёЁ]+$")){
                    data[0] = firstName;
                    data[1]= lastName;
                    logger.info(">>> Received user data: " + firstName + " and " + lastName);
                    break;    // Выход из цикла, если ввод корректен
                } else {
                    System.out.println("Invalid input. Please enter valid first and last names.");
                    logger.warn(">>> Received data are incorrect: " + firstName + " and " + lastName);
                }

            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid name.");
                logger.warn(">>> Invalid name: " + e.getMessage());
            }

        } while(true);
        return data;

    }
    public void getOutput(String resultOutput){
        System.out.println(resultOutput);
    }
}
