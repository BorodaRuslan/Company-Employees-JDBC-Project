package org.example.app.repository.Impl;

import org.example.app.ConfigDatabase.DBConn;
import org.example.app.entity.Employee;
import org.example.app.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesFilteringRepositoryImpl implements FilterRepository<Employee> {
    private static final Logger logger = LoggerFactory.getLogger(EmployeesFilteringRepositoryImpl.class);
    @Override
    public List<Employee> filterByCity(List<String> city) {
        return executeFilterQuery("city", city);
    }

    @Override
    public List<Employee> filterByPositions(List<String> position) {
        return executeFilterQuery("position", position);
    }

    @Override
    public List<Employee> filterByGender(List<String> gender) {
        return executeFilterQuery("gender", gender);
    }

    @Override
    public List<Employee> filterBySalary(List<Double> salary) {
        return executeFilterQuery("salary", salary);
    }

    private <T> List<Employee> executeFilterQuery(String columnName, List<T> values) {
        List<Employee> resultList = new ArrayList<>();
        // Строим строку с заполнителями для оператора IN в SQL
        String placeholders = String.join(",", Collections.nCopies(values.size(), "?"));
        // Формируется динамический SQL запрос.
        String query = "SELECT * FROM employee WHERE " + columnName + " IN (" + placeholders + ")";

        try (Connection connect = DBConn.connect();
             PreparedStatement preparedStatement = connect.prepareStatement(query)){
            for (int i = 0; i < values.size(); i++){
                if (values.get(i) instanceof String){
                    preparedStatement.setString(i + 1, (String) values.get(i));
                } else if (values.get(i) instanceof Double){
                    preparedStatement.setDouble(i + 1, (Double) values.get(i));
                } else {
                    // Другие типы данных можно добавить по необходимости.
                    logger.error(">>> Unsupported filter value type: {}", values.get(i).getClass().getName());
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setCity(resultSet.getString("city"));
                resultList.add(employee);
            }
            logger.info(">>> Returning a filtered list!");
            return resultList;

        } catch (SQLException e) {
            logger.error(">>> No connection to base established: " + e.getMessage());
        }
        logger.info("Returning an empty list!");
        return resultList;
    }
}
