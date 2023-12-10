package org.example.app.service.containerFiltering;

import org.example.app.controller.filtering.ControllerFilterByCity;
import org.example.app.repository.Impl.EmployeesFilteringRepositoryImpl;
import org.example.app.service.filtering.EmployeeFilterService;
import org.example.app.view.filtering.EmployeeFilterByCityView;

public class ContainerFiltering {


    public void filterEmployeesByCity(){
        EmployeeFilterByCityView view = new EmployeeFilterByCityView();
        EmployeesFilteringRepositoryImpl repository = new EmployeesFilteringRepositoryImpl();
        EmployeeFilterService service = new EmployeeFilterService(repository);

        ControllerFilterByCity controller = new ControllerFilterByCity(view, service);

        controller.getFilteredOut();

    }
}
