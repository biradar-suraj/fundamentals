package org.drogo.basics.cleancode;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    public static boolean isValidEmail(String input) {
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("example@example.com")); // valid email
        System.out.println(isValidEmail("invalid_email")); // invalid email
    }

    public static void dbProcessEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            if (!isValidEmail(email)) {
                throw new IllegalArgumentException("Not a valid email");
            }

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "<connection string>";
            connection = DriverManager.getConnection(connectionUrl);

            String query = "SELECT * FROM users WHERE email= ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);

            resultSet = statement.executeQuery();

            // Process the result set as needed
            while (resultSet.next()) {
                // Example: System.out.println(resultSet.getString("column_name"));
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database access error.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid email format.");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database resources.");
                e.printStackTrace();
            }
        }

    }
}
