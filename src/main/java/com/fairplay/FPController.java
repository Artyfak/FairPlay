package com.fairplay;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;

public class FPController {
    boolean en_cz_bull = true;
    FairPlayBrain brain = new FairPlayBrain();
    @FXML
    private TextField tf_Slovo;
    @FXML
    private TextField TF_siftext;
    @FXML
    private TextArea sifrovacia_tabulka2;
    @FXML
    private TextArea sifrovacia_tabulka1;
    @FXML
    private TextArea sifrovacia_tabulka3;
    @FXML
    private TextArea sifrovacia_tabulka4;
    @FXML
    private TextArea ukazatel;

    @FXML
    private Button en_cz;
    @FXML
    void handle_slovo() {
        sifrovacia_tabulka1.setWrapText(true);
        sifrovacia_tabulka2.setWrapText(true);
        sifrovacia_tabulka3.setWrapText(true);

        brain.setSlovo(tf_Slovo.getText());
        if (en_cz_bull) {
            brain.naplnpole_en(brain.getSlovo());

        }else {
            brain.naplnpole_cz(brain.getSlovo());
        }
        sifrovacia_tabulka1.setText(brain.vypispoleR());


    }
    @FXML
    void handle_text() {
        sifrovacia_tabulka1.setWrapText(true);
        sifrovacia_tabulka2.setWrapText(true);
        sifrovacia_tabulka3.setWrapText(true);
        brain.setPrvodnytext(TF_siftext.getText());
        String output = "";
        if (en_cz_bull) {
             output = brain.filtruj_en(brain.getPrvotnytext().toLowerCase());

        } else {
             output = brain.filtruj_cz(brain.getPrvotnytext().toLowerCase());

        }


        sifrovacia_tabulka2.setText(brain.pridajmedzery(output));
        sifrovacia_tabulka3.setText(brain.pridajmedzerypo5(brain.sifrovanie(sifrovacia_tabulka2.getText())));

        sifrovacia_tabulka4.setText(brain.prepis(brain.desifrovanie(sifrovacia_tabulka3.getText())));



    }
    @FXML
    boolean handle_button() {
        if (en_cz_bull == true) {
            ukazatel.setText("CZ");
            en_cz_bull = false;
        } else {
            en_cz_bull = true;
            ukazatel.setText("EN");
        }

        return en_cz_bull;



    }



}