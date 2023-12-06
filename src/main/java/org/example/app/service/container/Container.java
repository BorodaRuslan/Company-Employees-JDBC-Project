package org.example.app.service.container;

import org.example.app.controller.EmployeeGetAllController;
import org.example.app.repository.EmployeeRepository;
import org.example.app.service.EmployeeService;
import org.example.app.view.EmployeesGetAllVeiw;

public class Container {


    public void getAllEmployees(){
        EmployeesGetAllVeiw veiw = new EmployeesGetAllVeiw();
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);

        EmployeeGetAllController controller = new EmployeeGetAllController(veiw, service);
        controller.getAllEmployees();

    }

}
