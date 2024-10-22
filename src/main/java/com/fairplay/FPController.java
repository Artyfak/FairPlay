package com.fairplay; // Definícia balíčka

import javafx.fxml.FXML; // Import knižnice pre FXML
import javafx.scene.control.Button; // Import pre tlačidlá
import javafx.scene.control.TextField; // Import pre textové polia
import javafx.scene.control.TextArea; // Import pre textové oblasti
import javafx.scene.control.ToggleButton; // Import pre prepínacie tlačidlá

public class FPController { // Trieda na správu užívateľského rozhrania
    boolean en_cz_bull = true; // Príznak na určenie jazyka (CZ/EN)
    FairPlayBrain brain = new FairPlayBrain(); // Inštancia triedy pre logiku aplikácie

    @FXML
    private TextField tf_Slovo; // Textové pole pre zadanie slova
    @FXML
    private TextField TF_siftext; // Textové pole pre zadanie šifrovaného textu
    @FXML
    private TextArea sifrovacia_tabulka2; // Textová oblasť pre zobrazenie druhej tabuľky
    @FXML
    private TextArea sifrovacia_tabulka1; // Textová oblasť pre zobrazenie prvej tabuľky
    @FXML
    private TextArea sifrovacia_tabulka3; // Textová oblasť pre zobrazenie tretej tabuľky
    @FXML
    private TextArea sifrovacia_tabulka4; // Textová oblasť pre zobrazenie štvrtej tabuľky
    @FXML
    private TextArea ukazatel; // Textová oblasť pre zobrazenie aktuálneho jazyka

    @FXML
    private Button en_cz;

    // Metóda na spracovanie slova
    @FXML
    void handle_slovo() {
        // Umožnenie zalamovania textu v textových oblastiach
        sifrovacia_tabulka1.setWrapText(true);
        sifrovacia_tabulka2.setWrapText(true);
        sifrovacia_tabulka3.setWrapText(true);

        // Nastavenie slova v triede brain
        brain.setSlovo(tf_Slovo.getText());

        // Naplnenie poľa podľa zvoleného jazyka
        if (en_cz_bull) {
            brain.naplnpole_en(brain.getSlovo()); // Pre anglický jazyk
        } else {
            brain.naplnpole_cz(brain.getSlovo()); // Pre český jazyk
        }

        // Zobrazenie výsledného poľa v prvej tabuľke
        sifrovacia_tabulka1.setText(brain.vypispoleR());
    }

    // Metóda na spracovanie textu
    @FXML
    void handle_text() {
        // Umožnenie zalamovania textu v textových oblastiach
        sifrovacia_tabulka1.setWrapText(true);
        sifrovacia_tabulka2.setWrapText(true);
        sifrovacia_tabulka3.setWrapText(true);

        // Nastavenie pôvodného textu
        brain.setPrvodnytext(TF_siftext.getText());
        String output = "";

        // Filtrácia textu podľa zvoleného jazyka
        if (en_cz_bull) {
            output = brain.filtruj_en(brain.getPrvotnytext().toLowerCase());
        } else {
            output = brain.filtruj_cz(brain.getPrvotnytext().toLowerCase());
        }

        // Pridanie medzier a zobrazenie v druhej tabuľke
        sifrovacia_tabulka2.setText(brain.pridajmedzery(output));

        // Šifrovanie a zobrazenie v tretej tabuľke
        sifrovacia_tabulka3.setText(brain.pridajmedzerypo5(brain.sifrovanie(sifrovacia_tabulka2.getText())));

        // Dešifrovanie a zobrazenie v štvrtej tabuľke
        sifrovacia_tabulka4.setText(brain.prepis(brain.desifrovanie(sifrovacia_tabulka3.getText())));
    }

    // Metóda na prepínanie jazyka
    @FXML
    boolean handle_button() {
        // Prepínanie medzi českým a anglickým jazykom
        if (en_cz_bull == true) {
            ukazatel.setText("CZ"); // Nastavenie jazyka na CZ
            en_cz_bull = false; // Zmena príznaku na EN
        } else {
            en_cz_bull = true; // Zmena príznaku na CZ
            ukazatel.setText("EN"); // Nastavenie jazyka na EN
        }

        return en_cz_bull; // Vráti aktuálny jazyk
    }
}
