package org.example.app.view.filtering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class EmployeeFilterAbstractView {

    // Logger для записи логов
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFilterAbstractView.class);

    // Scanner для ввода данных
    protected final Scanner scanner = new Scanner(System.in);

    // Список для хранения фильтров
    protected final List<String> filterList = new ArrayList<>();

    // Метод для ввода данных с проверкой валидности
    protected String getInputWithValidation(String prompt, String regexPattern) {
        String userInput;
        do {
            System.out.println(prompt);
            userInput = scanner.nextLine();
            logger.info(">>> Received user data: " + userInput);

        } while (!userInput.matches(regexPattern));
        return userInput;

    }

    // Метод для ввода данных
    public List<String> inputData(String entity){
        String userAnswer;

        // Начало цикла для ввода данных.
        do {
            String searchData = getInputWithValidation( String.format("Enter the %s by which you want to filter " +
                            "(1-12 characters, Cyrillic only):", entity),
                    "^[а-яА-ЯёЁ]{1,12}$");
            filterList.add(searchData);

            // Запрос пользователя о добавлении еще одного фильтра
            System.out.println(String.format("Do you want to add another %s for filtering? (Yes/No)", entity));
            userAnswer = scanner.nextLine().trim();

        } while (userAnswer.equalsIgnoreCase("Yes"));
        return filterList;
    }
    // Абстрактный метод для вывода результатов
    public abstract void getOutput(String output);
}
