package org.example.app.view.filtering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFilterByPositionView {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFilterByPositionView.class);
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> resultPositionList = new ArrayList<>();

    public List<String> inputDataPosition(){
        // Переменная для хранения ответа пользователя о добавлении еще одного города
        String userAnswer = null;
        // Начало цикла для ввода профессий.
        do {
            // Переменная для хранения введенного города.
            String searchPosition;

            // Внутренний цикл для ввода города с проверкой валидности.
            do {
                System.out.println("Enter the position by which you want to filter (1-12 characters, Cyrillic only):");
                searchPosition = scanner.nextLine();
                logger.info(">>> Received user data: " + searchPosition);
            } while (!searchPosition.matches("^[а-яА-ЯёЁ]{1,12}$"));  // Проверка валидности ввода.
            resultPositionList.add(searchPosition);

            // Запрос пользователя о добавлении еще одного позиции.
            System.out.println("Do you want to add another positions for filtering? (Yes/No)");
            userAnswer = scanner.nextLine().trim();

        } while (userAnswer.equalsIgnoreCase("Yes"));
        return resultPositionList;
    }
    public void getOutput(String resultOutput){
        if (resultPositionList.isEmpty()){
            System.out.println("No cities selected.");
        } else {
            String positionStr = String.join(", ", resultPositionList);
            System.out.println("You have filtered these positions: " + positionStr + ". " + "\n");
            System.out.println(resultOutput);
        }
    }
}
