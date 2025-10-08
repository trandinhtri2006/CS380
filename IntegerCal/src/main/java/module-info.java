module com.example.integercal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.integercal to javafx.fxml;
    exports com.example.integercal;
}