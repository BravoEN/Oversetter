package com.example.oversetter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OversetterController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
