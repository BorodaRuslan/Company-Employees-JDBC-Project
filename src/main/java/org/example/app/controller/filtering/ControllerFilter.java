package org.example.app.controller.filtering;

import org.example.app.service.containerFiltering.ContainerFiltering;
import org.example.app.view.filtering.EmployeeFilterView;

public class ControllerFilter {


    EmployeeFilterView view;
    ContainerFiltering containerFiltering;


    private void filterChoice(int choice){
        switch (choice){
            case 1:
                containerFiltering.filterEmployeesByCity();


            // Другие кейсы!

        }
    }

}
