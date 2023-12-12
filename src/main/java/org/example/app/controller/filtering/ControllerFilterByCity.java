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
        List<String> listCity = view.inputData();
        String city = listCity.get(0);

        view.getOutput(service.filterByCity(city));
    }
}
