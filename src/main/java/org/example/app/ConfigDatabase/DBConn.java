package org.example.app.ConfigDatabase;

import org.example.app.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static final Logger logger = LoggerFactory.getLogger(DBConn.class);

    public static Connection connect(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Constants.DB_DRIVER + Constants.DB_NAME,
                    Constants.DB_USER, Constants.DB_PASS);
            logger.info(">>> Connected to the database!");
        } catch (SQLException e){
            logger.error("Error connecting to the database: {}", e.getMessage());
        }
        return connection;
    }
}
