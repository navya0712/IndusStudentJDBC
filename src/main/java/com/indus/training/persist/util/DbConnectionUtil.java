package com.indus.training.persist.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DbConnectionUtil {

    private static String dbUrl;
    private static String dbUsername;
    private static String dbPassword;
    private static final Logger loggerObj = LogManager.getLogger(DbConnectionUtil.class);

    static {
        loadConfig();
    }

    /**
     * Loads the database configuration from config.properties. The properties
     * include database URL, username, and password.
     */
    private static void loadConfig() {
        Properties prop = new Properties();
        try (InputStream input = DbConnectionUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                prop.load(input);
                dbUrl = prop.getProperty("db.url", "");
                dbUsername = prop.getProperty("db.username", "");
                dbPassword = prop.getProperty("db.password", "");
                loggerObj.info("DatabaseConnectionManager initialized with database URL: " + dbUrl);
            } else {
                loggerObj.fatal("Config file not found.");
                throw new RuntimeException("Config file not found.");
            }
        } catch (IOException ex) {
            loggerObj.fatal("Failed to load config properties.", ex);
            throw new RuntimeException("Failed to load config properties.", ex);
        }
    }

    /**
     * Establishes a connection to the database using the configured URL, username,
     * and password.
     * 
     * @return a Connection object.
     * @throws SQLException if a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}
