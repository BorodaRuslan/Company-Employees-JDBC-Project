package org.example.app.controller;
import org.example.app.service.container.Container;
import org.example.app.service.containerFiltering.ContainerFiltering;
import org.example.app.view.EmployeeView;
import org.example.app.view.filtering.EmployeeFilterView;

import java.util.Scanner;

public class EmployeeController {
    EmployeeView view;
    EmployeeFilterView filterView;
    Container container;
    ContainerFiltering containerFiltering;


    public EmployeeController(EmployeeView view, Container container, ContainerFiltering containerFiltering,
                              EmployeeFilterView filterView) {
        this.view = view;
        this.container = container;
        this.containerFiltering = containerFiltering;
        this.filterView = filterView;
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
            case 3:
                int choice;
               do {
                   choice = filterView.filteringChoice();
                   if (choice < 1 || choice > 3)
                       System.out.println("Invalid input. Please enter valid numbers (1-3)");
               } while (choice < 1 | choice > 3);
               switch (choice){
                   case 1:
                       containerFiltering.filterEmployeesByCity();
                       // тут будет логика сохранения
                       break;
                   case 2:
                       containerFiltering.filterEmployeesByPosition();
                       // тут будет логика сохранения
                       break;
                   case 3:
                       containerFiltering.filterEmployeesByGender();
                       // тут будет логика сохранения
                       break;
               }
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
