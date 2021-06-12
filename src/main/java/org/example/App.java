package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/todoit?&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin";
        String user = "root";
        String password = "12345";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM todo_item";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
                System.out.println(rs.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}

