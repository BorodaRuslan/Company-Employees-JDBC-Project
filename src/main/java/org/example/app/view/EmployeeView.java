package org.example.app.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeView {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeView.class);
    Scanner scanner = new Scanner(System.in);

    public int optionalUser(){
        int userChoice;
       do {
           try {
               userChoice = scanner.nextInt();
               logger.info(">>> Data received from user: " + userChoice);
           } catch (InputMismatchException e ){
               System.out.println("Invalid input. Please enter a valid number");
               logger.warn(">>> Invalid input number: " + e.getMessage());
               scanner.nextLine();     // Очищаем буфер после ошибочного ввода.
               userChoice = -1;       // Присваиваем недопустимое значение, чтобы продолжить цикл.
           }
       } while (userChoice < 0 || userChoice > 5);
       return userChoice;
    }
    public void menu(){
        System.out.println("""
                
                To use the application, select a number from the menu.
                
                1. See all employees.
                2. Search employee by name.
                3. Filtering employees.
                4. Statistic.
                0. To close the application.
                
                """);
    }

    public void getOutput(String output){
        System.out.println(output);
    }



}
