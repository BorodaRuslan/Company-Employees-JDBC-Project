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
import java.util.List;

public class FilterEmployeesRepositoryImpl implements FilterRepository<Employee> {
    private static final Logger logger = LoggerFactory.getLogger(FilterEmployeesRepositoryImpl.class);
    @Override
    public List<Employee> filterByCity(String city) {
        return executeFilterQuery("city", city);
    }

    @Override
    public List<Employee> filterByPositions(String position) {
        return executeFilterQuery("position", position);
    }

    @Override
    public List<Employee> filterByGender(String gender) {
        return executeFilterQuery("gender", gender);
    }

    @Override
    public List<Employee> filterBySalary(double salary) {
        return executeFilterQuery("salary", salary);
    }

    private <T> List<Employee> executeFilterQuery(String columnName, T value) {
        List<Employee> resultList = new ArrayList<>();
        try (Connection connect = DBConn.connect()) {
            String query = "SELECT * FROM employee WHERE " + columnName + " = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);

            if (value instanceof String){
                preparedStatement.setString(1, (String) value);
            } else if (value instanceof Double){
                preparedStatement.setDouble(1, (Double) value);
            } else {
                // Другие типы данных можно добавить по необходимости
                logger.error("Unsupported filter value type: {}", value.getClass().getName());
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
