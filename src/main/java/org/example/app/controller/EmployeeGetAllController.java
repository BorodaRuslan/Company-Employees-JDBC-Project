package org.example.app.controller;

import org.example.app.repository.EmployeeRepository;
import org.example.app.service.EmployeeService;
import org.example.app.view.EmployeeView;
import org.example.app.view.EmployeesGetAllVeiw;

public class EmployeeGetAllController {
    EmployeesGetAllVeiw view;
    EmployeeRepository repository;
    EmployeeService service;

    public EmployeeGetAllController(EmployeesGetAllVeiw view, EmployeeService service) {
        this.view = view;
        this.service = service;
    }
    public void getAllEmployees(){
        view.getOutput(service.getAllEmployees());
    }
}
