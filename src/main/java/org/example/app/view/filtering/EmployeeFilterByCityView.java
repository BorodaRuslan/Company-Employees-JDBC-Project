package org.example.app.view.filtering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class EmployeeFilterByCityView extends EmployeeFilterAbstractView{

    @Override
    public void getOutput(String output) {
        if (output.isEmpty()){
            System.out.println("No cities selected.");
        } else {
            String cityStr = String.join(",", filterList);
            System.out.println("You have filtered these cities: " + cityStr);
            System.out.println(output);

        }

    }
}
