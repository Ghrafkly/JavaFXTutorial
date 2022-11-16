module com.example.keeptoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.keeptoo to javafx.fxml;
    exports com.example.keeptoo;
    opens com.example.keeptoo.controllers to javafx.fxml;
    exports com.example.keeptoo.controllers;
    opens com.example.keeptoo.models to javafx.fxml;
    exports com.example.keeptoo.models;
}