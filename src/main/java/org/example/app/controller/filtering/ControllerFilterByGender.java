package org.example.app.controller.filtering;

import org.example.app.service.EmployeeService;
import org.example.app.service.filtering.EmployeeFilterService;
import org.example.app.view.filtering.EmployeeFilterByGenderView;

import java.util.List;

public class ControllerFilterByGender {
    EmployeeFilterByGenderView view;
    EmployeeFilterService service;

    public ControllerFilterByGender(EmployeeFilterByGenderView view, EmployeeFilterService service) {
        this.view = view;
        this.service = service;
    }
    
    public void getFilterByGender(){
        List<String> dataGender = view.getDataGender();
        String letter = dataGender.get(0);
        view.getOutput(service.filterByGender(letter));
    }
}
