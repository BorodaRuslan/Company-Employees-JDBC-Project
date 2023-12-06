package org.example.app.repository;

import org.example.app.ConfigDatabase.DBConn;
import org.example.app.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    public List<Employee> getAllEmployees(){
        List<Employee> listEmployees = new ArrayList<>();
        try (Connection connect = DBConn.connect();
             Statement statement = connect.createStatement();)
        {
            String query = "SELECT * FROM employee";
            ResultSet resultEmployees = statement.executeQuery(query);
            logger.info(">>> Base connection established!");

            while (resultEmployees.next()) {
                Employee employee = new Employee();
                employee.setId(resultEmployees.getLong("id"));
                employee.setFirst_name(resultEmployees.getString("first_name"));
                employee.setLast_name(resultEmployees.getString("last_name"));
                employee.setGender(resultEmployees.getString("gender"));
                employee.setPhone(resultEmployees.getString("phone"));
                employee.setPosition(resultEmployees.getString("position"));
                employee.setSalary(resultEmployees.getDouble("salary"));
                employee.setCity(resultEmployees.getString("city"));
                logger.info(">>> Return the list of objects from the database!");
                listEmployees.add(employee);
            }

        } catch (SQLException e){
            logger.error(">>> No connection to base established: " + e.getMessage());
        }
        return listEmployees;
    }

    public Employee getEmployeeByName(String firstName, String lastName){
        Employee employee = new Employee();
        try (Connection connect = DBConn.connect()){

            String query = "Select * From employee Where first_name = ? AND last_name = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            logger.info(">>> Base connection established!");

            ResultSet resultEmployee = preparedStatement.executeQuery();

            while (resultEmployee.next()){
                employee.setId(resultEmployee.getLong("id"));
                employee.setFirst_name(resultEmployee.getString("first_name"));
                employee.setLast_name(resultEmployee.getString("last_name"));
                employee.setGender(resultEmployee.getString("gender"));
                employee.setPhone(resultEmployee.getString("phone"));
                employee.setPosition(resultEmployee.getString("position"));
                employee.setSalary(resultEmployee.getDouble("salary"));
                employee.setCity(resultEmployee.getString("city"));
            }
            logger.info(">>> Return the object from the database!");
            return employee;

        } catch (SQLException e){
            logger.error(">>> No connection to base established: " + e.getMessage());
        }
        return employee;

    }




}
