module com.example.oversetter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oversetter to javafx.fxml;
    exports com.example.oversetter;
}