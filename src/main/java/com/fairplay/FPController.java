package com.fairplay;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FPController {
    @FXML
    private TextField tf_Slovo;
    @FXML
    private TextField TF_siftext;
    @FXML
    void handle_slovo() {
        System.out.println(tf_Slovo.getText());
    }

}