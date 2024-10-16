package com.fairplay;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class FPController {
    FairPlayBrain brain = new FairPlayBrain();
    @FXML
    private TextField tf_Slovo;
    @FXML
    private TextField TF_siftext;
    @FXML
    private TextArea sifrovacia_tabulka;
    @FXML
    void handle_slovo() {
        brain.setSlovo(tf_Slovo.getText());
        brain.naplnpole(brain.getSlovo());
        sifrovacia_tabulka.setText(brain.vypispoleR());

        System.out.println("NEW");

    }

}