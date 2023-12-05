package org.example.app.repository;

import org.example.app.ConfigDatabase.DBConn;
import org.example.app.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final Logger logger = LoggerFactory.getLogger(DBConn.class);

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
                listEmployees.add(employee);
            }

        } catch (SQLException e){
            logger.error(">>> No connection to base established!");

        }
        return listEmployees;
    }
}
