package com.example.lab_4;

import javafx.application.Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_grades";
        String root = "root";
        String password = "23032006";
        try {
            Connection con = DriverManager.getConnection(url, root, password);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Failed to Connect");
            throw new RuntimeException(e);
        }
        Application.launch(HelloApplication.class, args);
    }
}
