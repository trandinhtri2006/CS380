package com.example.lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.util.*;
public class HelloController {

    @FXML
    private Button AddButton;

    @FXML
    private Button PrintButton;

    @FXML
    private Button RemoveButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private TextArea fnameInput;

    @FXML
    private TextArea gradeInput;

    @FXML
    private TextArea lnameInput;

    @FXML
    private TextArea studidInput;

    @FXML
    private Label textDisplay;

    private static final String url = "jdbc:mysql://localhost:3306/student_grades";
    private static final String root = "root";
    private static final String password = "23032006";

    Map<Integer, String> storage = new HashMap<>();

    /* Add Function */
    public void add() {
        String lastName = lnameInput.getText();
        String firstName = fnameInput.getText();
        String grade = gradeInput.getText();
        String idText = studidInput.getText();

        if (idText.isBlank()) {
            textDisplay.setText("Student ID cannot be blank.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            textDisplay.setText("Invalid ID format.");
            return;
        }

        if (!validInput(lastName, firstName, id)) {
            if (grade.isBlank()) {
                grade = "0";
            }


            String sql = "INSERT INTO 302_grades (student_id, fname, lname, grade) VALUES (?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url, root, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                stmt.setString(2, firstName);
                stmt.setString(3, lastName);
                stmt.setString(4, grade);
                stmt.executeUpdate();

                textDisplay.setText("Successfully added to database!");
                clear();
            } catch (SQLException e) {
                textDisplay.setText("Database Error: " + e.getMessage());
            }
        }
    }

    /* Remove Function */
    public void remove() {
        String sql = "DELETE FROM 302_grades WHERE student_id = ?";

        int id = Integer.parseInt(studidInput.getText());
        try (Connection conn = DriverManager.getConnection(url, root, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            textDisplay.setText("Successfully removed from database!");
            clear();
        } catch (SQLException e) {
            textDisplay.setText("Database Error: " + e.getMessage());
        }
    }

    /* Update Function */
    public void update() {
        String sql = "UPDATE 302_grades SET ";

        String lastName = lnameInput.getText();
        String firstName = fnameInput.getText();
        String grade = gradeInput.getText();
        int id = Integer.parseInt(studidInput.getText());

        if (!firstName.isBlank()) {
            sql += "fname = '" + firstName + "'";
        }
        if (!lastName.isBlank()) {
            sql += "lname = '" + lastName + "'";
        }
        if (!grade.isBlank()) {
            sql += "grade = '" + grade + "'";
        }

        sql += " WHERE student_id = " + id + ";";

        try (Connection conn = DriverManager.getConnection(url, root, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();

            textDisplay.setText("Successfully updated the database!");
            clear();
        } catch (SQLException e) {
            textDisplay.setText("Database Error: " + e.getMessage());
        }
    }

    /* Print */
    public void print() {
        String sql = "select * from 302_grades";
        try (Connection conn = DriverManager.getConnection(url, root, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet resultSet = stmt.executeQuery();

            String display = "";
            while (resultSet.next()) {
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String grade = resultSet.getString("grade");
                display += lastName + " " + firstName + " " + grade + "\n";
            }

            textDisplay.setText("Successfully updated the database!");
            clear();
        } catch (SQLException e) {
            textDisplay.setText("Database Error: " + e.getMessage());
        }
    }

    private void clear() {
        lnameInput.clear();
        fnameInput.clear();
        gradeInput.clear();
        studidInput.clear();
    }

    private boolean validInput(String lastName, String firstName, int id) {
        String errorMess = "";
        String idStr = String.valueOf(id);
        if (!lastName.isBlank() && !firstName.isBlank() && !idStr.isBlank() && idStr.length() == 8) {
            return false;
        }

        if (lastName.isBlank()) {
            errorMess += "Please enter the student last name\n";
        }

        if (firstName.isBlank()) {
            errorMess += "Please enter the student last name\n";
        }

        if (idStr.isBlank()) {
            errorMess += "Please enter the student id\n";
        } else if (idStr.length() != 8) {
            errorMess += "Invalid student ID";
        }
        textDisplay.setText(errorMess);
        return true;
    }


}
