package org.example.app.view.filtering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFilterByPositionView {

    // Todo: Этот метод можно сделать более гибким, например для ввода нескольких параметров!

    private static final Logger logger = LoggerFactory.getLogger(EmployeeFilterByPositionView.class);

    public List<String> inputDataPosition(){
        List<String> resultPositionList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String searchPosition = null;

        do {
            System.out.println("Enter the position by which you want to search!");
            try {

                searchPosition = scanner.nextLine();
                logger.info(">>> Received user data:" + searchPosition);
            } catch (Exception e){
                System.out.println("An error occurred: " + e.getMessage());
                logger.error(">>> Error receiving data from user: " + e.getMessage());
            }
        } while (!searchPosition.matches("^[а-яА-ЯёЁ]{1,12}$"));
        resultPositionList.add(searchPosition);
        return resultPositionList;
    }

    public void getOutput(String resultOutput){
        System.out.println(resultOutput);
    }
}
