package org.example.app.view.filtering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class EmployeeFilterByCityView {

    // Todo: Этот метод можно сделать более гибким, например для ввода нескольких городов!
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFilterByCityView.class);

    public List<String> inputData(){

        List<String> cityList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String searchCity = null;

        do {
            System.out.println("Enter the city by which you want to search!");
            try {
                searchCity = scanner.nextLine().trim();
                logger.info(">>> Received user data:" + searchCity);


            } catch (Exception e){
                System.out.println("An error occurred: " + e.getMessage());
                logger.error(">>> Error: " + e.getMessage());
            }

        } while (!searchCity.matches("^[а-яА-ЯёЁ]{1,12}$"));
        cityList.add(searchCity);
        return cityList;
    }

    public void getOutput(String output){
        // Тут можно сделать описание фильтрации
        System.out.println(output);
    }
}
