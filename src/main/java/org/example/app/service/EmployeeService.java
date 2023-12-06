package org.example.app.service;


import org.example.app.entity.Employee;
import org.example.app.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    EmployeeRepository repository;
    StringBuilder stringBuilder = new StringBuilder();

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String getAllEmployees(){
        List<Employee> allEmployees = repository.getAllEmployees();

        if (!allEmployees.isEmpty()){
            for (Employee employee: allEmployees){
                stringBuilder.append("Employee id: ").append(employee.getId()).append(" First name: ")
                        .append(employee.getFirst_name()).append(" last name: ").append(employee.getLast_name())
                        .append(" gender: ").append(employee.getGender()).append(" Phone: ").append(employee.getPhone())
                        .append(" Position: ").append(employee.getPosition()).append(" Salary: ").append(employee.getSalary())
                        .append(" City: ").append(employee.getCity());
            }
            return stringBuilder.toString();
        }
        return "Sorry, the database is empty!";
    }

    public String getEmployeeByName(String firstName, String lastName){
        Employee employeeResult = repository.getEmployeeByName(firstName, lastName);
        if (employeeResult != null){
            return stringBuilder.append("Employee id: ").append(employeeResult.getId()).append(" First name: ")
                    .append(employeeResult.getFirst_name()).append(" last name: ").append(employeeResult.getLast_name())
                    .append(" gender: ").append(employeeResult.getGender()).append(" phone: ").append(employeeResult.getPhone())
                    .append(" position: ").append(employeeResult.getPosition()).append(" salary: ").append(employeeResult.getSalary())
                    .append(" city: ").append(employeeResult.getCity()).toString();
        }
        return "Sorry, there’s no such employee in the database!";

    }
}
