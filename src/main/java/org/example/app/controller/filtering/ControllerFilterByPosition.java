package org.example.app.controller.filtering;

import org.example.app.service.filtering.EmployeeFilterService;
import org.example.app.view.filtering.EmployeeFilterByCityView;
import org.example.app.view.filtering.EmployeeFilterByPositionView;

import java.util.List;

public class ControllerFilterByPosition {

    EmployeeFilterByPositionView view;
    EmployeeFilterService service;

    public ControllerFilterByPosition(EmployeeFilterByPositionView view, EmployeeFilterService service) {
        this.view = view;
        this.service = service;
    }

    public void getFilterPositionOut(){
        view.getOutput(service.filterByPosition(view.inputData("positions")));
    }
}
