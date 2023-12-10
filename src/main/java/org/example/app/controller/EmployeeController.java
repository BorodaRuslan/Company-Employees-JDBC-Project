package org.example.app.controller;
import org.example.app.service.container.Container;
import org.example.app.view.EmployeeView;

public class EmployeeController {
    EmployeeView view;
    Container container;

    public EmployeeController(EmployeeView view, Container container) {
        this.view = view;
        this.container = container;
    }

    public void runApp(){
        int userChoice;
        do {
            view.menu();
            userChoice = view.optionalUser();
            filter(userChoice);
        } while (userChoice != 0);
    }

    private void filter(int numberChoice){
        switch (numberChoice){
            case 1:
                container.getAllEmployees();
                break;
            case 2:
                container.getEmployeeByName();
                break;
            case 0:
                System.out.println("Closing the application. Goodbye!");
                break;

            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;

        }

    }
}
