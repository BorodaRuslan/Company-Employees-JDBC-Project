package org.example.app.controller.filtering;

import org.example.app.service.filtering.EmployeeFilterService;
import org.example.app.view.filtering.EmployeeFilterByCityView;

import java.util.List;

public class ControllerFilterByCity {
    EmployeeFilterByCityView view;
    EmployeeFilterService service;

    public ControllerFilterByCity(EmployeeFilterByCityView view, EmployeeFilterService service) {
        this.view = view;
        this.service = service;
    }

    public void getFilteredOut(){
        view.getOutput(service.filterByCity(view.inputData("City")));
    }
}
