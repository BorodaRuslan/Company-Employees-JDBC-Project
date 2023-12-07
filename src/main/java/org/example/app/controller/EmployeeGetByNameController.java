package org.example.app.controller;

import org.example.app.service.EmployeeService;
import org.example.app.view.EmployeeGetByNameView;

public class EmployeeGetByNameController {
    EmployeeGetByNameView view;
    EmployeeService service;

    public EmployeeGetByNameController(EmployeeGetByNameView view, EmployeeService service) {
        this.view = view;
        this.service = service;
    }

    public void getByName(){
        String[] data = view.getData();
        String firstName = data[0];
        String lastName = data[1];

        view.getOutput(service.getEmployeeByName(firstName, lastName));
    }
}
