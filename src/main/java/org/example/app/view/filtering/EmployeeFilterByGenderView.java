package org.example.app.view.filtering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFilterByGenderView {
    // Todo: Этот метод можно сделать более гибким, например для ввода нескольких параметров!
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFilterByGenderView.class);

    public List<String> getDataGender() {
        List<String> resultGender = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String searchGender = null;

        do {
            System.out.println("Enter letter('M' or 'Ж') the gender by which you want to search: ");
            try {
                searchGender = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                logger.error(">>> Error receiving data from user: " + e.getMessage());
            }
        } while (!searchGender.matches("^[МЖ]{1}$"));
        resultGender.add(searchGender);
        return resultGender;
    }

    public void getOutput(String resultOutput){
        System.out.println(resultOutput);
    }
}
