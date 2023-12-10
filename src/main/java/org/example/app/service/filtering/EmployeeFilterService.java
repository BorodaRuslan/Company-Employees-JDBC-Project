package org.example.app.service.filtering;

import org.example.app.entity.Employee;
import org.example.app.repository.Impl.EmployeesFilteringRepositoryImpl;

import java.util.List;

public class EmployeeFilterService {
    EmployeesFilteringRepositoryImpl repository;

    public EmployeeFilterService(EmployeesFilteringRepositoryImpl repository) {
        this.repository = repository;
    }

    public String filterByCity(String city){
        return builderDataEmployee(repository.filterByCity(city));
    }

    public String filterByGender(String gender){
        return builderDataEmployee(repository.filterByGender(gender));
    }

    public String filterByPosition(String position){
        return builderDataEmployee(repository.filterByPositions(position));
    }

    public String filterBySalary(double salary){
        return builderDataEmployee(repository.filterBySalary(salary));
    }

    private String builderDataEmployee(List<Employee> list){
        StringBuilder stringBuilder = new StringBuilder();

        if (!list.isEmpty()){
            for (Employee employee: list){
                stringBuilder.append("Id: " + employee.getId()).append(" Firs name: ").append(employee.getFirst_name())
                        .append(". Last name: ").append(employee.getLast_name()).append(". Gender: ").append(employee.getGender())
                        .append(". Phone: ").append(employee.getPhone()).append(". Positions: ").append(employee.getPosition())
                        .append(". Salary: ").append(employee.getSalary()).append(". City: ").append(employee.getCity())
                        .append(".").append("\n");
            }
            return stringBuilder.toString();
        }
        return "Sorry there is no data";
    }

}
