package com.fairplay;

public class FairPlayBrain {
    private char [][] polechar = new char[5][5];
    private String slovo;

    public FairPlayBrain() {
        for (int i = 0; i < polechar.length; i++) {
            for (int j = 0; j < polechar[i].length; j++) {

                polechar[i][j] = ' ';
            }
        }
        this.slovo = " ";
    }

    public char[][] getPolechar() {
        return polechar;
    }

    public String getSlovo() {
        return slovo;
    }

    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }

    public void naplnpole(String kluc) {
        boolean[] pouzite = new boolean[26]; // Pre písmená A-Z
        int index = 0;

        // Pridanie unikátnych znakov z kľúča
        for (char c : kluc.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c); // Zabezpečenie veľkých písmen
                int i = c - 'A';
                if (i >= 0 && i < 26 && !pouzite[i]) {
                    pouzite[i] = true;
                    polechar[index / 5][index % 5] = c;
                    index++;
                }
            }
        }
        pouzite[22] = true;

        // Pridanie zvyšných písmen
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = c - 'A';
            if (!pouzite[i]) {
                if (index < 25) { // Uisti sa, že index je v rámci
                    polechar[index / 5][index % 5] = c;
                    index++;
                }
            }
        }
    }

    public void vypisPole() {
        for (int i = 0; i < polechar.length; i++) {
            for (int j = 0; j < polechar[i].length; j++) {
                System.out.print(polechar[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String vypispoleR() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < polechar.length; i++) {
            for (int j = 0; j < polechar[i].length; j++) {
                sb.append(polechar[i][j]).append(" ");
            }
            sb.append("\n"); // Nový riadok po každom riadku matice
        }
        return sb.toString(); // Vráti celý obsah ako reťazec
    }
}
