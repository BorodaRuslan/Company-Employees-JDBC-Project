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
        List<String> resultPosition = view.inputDataPosition();
        String position = resultPosition.get(0);
        view.getOutput(service.filterByPosition(position));
    }
}
