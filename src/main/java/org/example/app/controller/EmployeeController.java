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

    public void filter(int numberChoice){
        switch (numberChoice){
            case 1 -> container.getAllEmployees();


        }
    }
}
