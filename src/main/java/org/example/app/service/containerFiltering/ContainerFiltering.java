package org.example.app.service.containerFiltering;

import org.example.app.controller.filtering.ControllerFilterByCity;
import org.example.app.controller.filtering.ControllerFilterByGender;
import org.example.app.controller.filtering.ControllerFilterByPosition;
import org.example.app.repository.Impl.EmployeesFilteringRepositoryImpl;
import org.example.app.service.filtering.EmployeeFilterService;
import org.example.app.view.filtering.EmployeeFilterByCityView;
import org.example.app.view.filtering.EmployeeFilterByGenderView;
import org.example.app.view.filtering.EmployeeFilterByPositionView;

public class ContainerFiltering {


    public void filterEmployeesByCity(){
        EmployeeFilterByCityView view = new EmployeeFilterByCityView();
        EmployeesFilteringRepositoryImpl repository = new EmployeesFilteringRepositoryImpl();
        EmployeeFilterService service = new EmployeeFilterService(repository);

        ControllerFilterByCity controller = new ControllerFilterByCity(view, service);
        controller.getFilteredOut();
    }

    public void filterEmployeesByPosition(){
        EmployeeFilterByPositionView view = new EmployeeFilterByPositionView();
        EmployeesFilteringRepositoryImpl repository = new EmployeesFilteringRepositoryImpl();
        EmployeeFilterService service = new EmployeeFilterService(repository);

        ControllerFilterByPosition controller = new ControllerFilterByPosition(view, service);
        controller.getFilterPositionOut();
    }

    public void filterEmployeesByGender(){
        EmployeeFilterByGenderView view = new EmployeeFilterByGenderView();
        EmployeesFilteringRepositoryImpl repository = new EmployeesFilteringRepositoryImpl();
        EmployeeFilterService service = new EmployeeFilterService(repository);

        ControllerFilterByGender controller = new ControllerFilterByGender(view, service);
        controller.getFilterByGender();
    }
}
