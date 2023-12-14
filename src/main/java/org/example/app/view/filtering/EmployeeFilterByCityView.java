package org.example.app.view.filtering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class EmployeeFilterByCityView {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeFilterByCityView.class);
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> cityList = new ArrayList<>();

    public List<String> inputData(){
        // Переменная для хранения ответа пользователя о добавлении еще одного города
        String userAnswer = null;

        // Начало цикла для ввода городов.
        do {
            // Переменная для хранения введенного города.
            String searchCity;

            // Внутренний цикл для ввода города с проверкой валидности.
            do {
                System.out.println("Enter the city by which you want to filter (1-12 characters, Cyrillic only):");
                searchCity = scanner.nextLine();
                logger.info(">>> Received user data: " + searchCity);
            } while (!searchCity.matches("^[а-яА-ЯёЁ]{1,12}$"));   // Проверка валидности ввода.
            // Добавление введенного города в список.
            cityList.add(searchCity);

            // Запрос пользователя о добавлении еще одного города
            System.out.println("Do you want to add another city for filtering? (Yes/No)");
            userAnswer = scanner.nextLine().trim();

        } while (userAnswer.equalsIgnoreCase("Yes")); // Повторение цикла при положительном ответе пользователя
        return cityList;
    }
    public void getOutput(String output) {
        if (cityList.isEmpty()) {
            System.out.println("No cities selected.");
        } else {
            String cityStr = String.join(", ", cityList);
            System.out.println("You have filtered these cities: " + cityStr + ". " + "\n");
            System.out.println(output);
        }
    }
}
