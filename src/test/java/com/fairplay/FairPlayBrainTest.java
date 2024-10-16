package com.fairplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FairPlayBrainTest {

    @Test
    void naplnpole() {
        FairPlayBrain cipher = new FairPlayBrain();
        cipher.naplnpole("KLUČ");

        // Očakávané výsledky
        char[][] ocekavanePole = {
                {'K', 'L', 'U', 'C', 'A'},
                {'B', 'D', 'E', 'F', 'G'},
                {'H', 'I', 'J', 'M', 'N'},
                {'O', 'P', 'Q', 'R', 'S'},
                {'T', 'V', 'W', 'X', 'Y'}
        };

        for (int i = 0; i < 5; i++) {
            assertArrayEquals(ocekavanePole[i], cipher.getPolechar()[i]);
        }
    }

    @Test
    void vypisPole() {
    }
}