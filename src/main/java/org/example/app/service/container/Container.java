package org.example.app.service.container;

import org.example.app.controller.EmployeeGetAllController;
import org.example.app.controller.EmployeeGetByNameController;
import org.example.app.repository.EmployeeRepository;
import org.example.app.service.EmployeeService;
import org.example.app.view.EmployeeGetByNameView;
import org.example.app.view.EmployeesGetAllVeiw;

public class Container {


    public void getAllEmployees(){
        EmployeesGetAllVeiw view = new EmployeesGetAllVeiw();
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);

        EmployeeGetAllController controller = new EmployeeGetAllController(view, service);
        controller.getAllEmployees();
    }

    public void getEmployeeByName(){
        EmployeeGetByNameView view = new EmployeeGetByNameView();
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);
        EmployeeGetByNameController controller = new EmployeeGetByNameController(view, service);

        controller.getByName();

    }

}
