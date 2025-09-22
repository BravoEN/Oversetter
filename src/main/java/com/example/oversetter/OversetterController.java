package com.example.oversetter;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.util.List;

public class OversetterController {

    @FXML
    private ToggleGroup fraSprak;

    @FXML
    private ToggleGroup tilSprak;

    @FXML
    private TextArea fraTekst;

    @FXML
    private TextArea tilTekst;

    @FXML
    protected void oversetter() {
        Iterable<Ord> objectList = Ord.OppretterOrd();
        RadioButton frasprakSelectedToggle = (RadioButton) fraSprak.getSelectedToggle();
        RadioButton tilsprakSelectedToggle = (RadioButton) tilSprak.getSelectedToggle();
        String[] ord = fraTekst.getText().split(" ");
        boolean funnet = false;
        if (frasprakSelectedToggle.getText().equals("Norsk") && tilsprakSelectedToggle.getText().equals("Alien")) {
            for (int i = 0; i < ord.length; i++) {
                for (Ord obj : objectList ) {
                    if (ord[i].equals(obj.norskOrd)) {
                        funnet = true;
                        tilTekst.appendText(obj.alienOrd + " ");
                    }
                }
                if (funnet == false) {
                    tilTekst.appendText("??? ");
                }
                funnet = false;
            }
        } else if (frasprakSelectedToggle.getText().equals("Alien") && tilsprakSelectedToggle.getText().equals("Norsk")) {
            for (int i = 0; i < ord.length; i++) {
                for (Ord obj : objectList ) {
                    if (ord[i].equals(obj.alienOrd)) {
                        funnet = true;
                        tilTekst.appendText(obj.norskOrd + " ");
                    }
                }
                if (funnet == false) {
                    tilTekst.appendText("??? ");
                }
                funnet = false;
            }
        }
    }

    @FXML
    protected void oversettKnapp() {
        tilTekst.clear();
        oversetter();
    }

    @FXML
    protected void avsluttKnapp() {
        javafx.application.Platform.exit();
    }
}

