module com.example.lab_assignment_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_assignment_4 to javafx.fxml;
    exports com.example.lab_assignment_4;
}