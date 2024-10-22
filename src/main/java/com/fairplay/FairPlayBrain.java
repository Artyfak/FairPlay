package com.fairplay;

public class FairPlayBrain {
    private char [][] polechar = new char[5][5];
    private String slovo;
    private String prvotnytext;

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

    public String getPrvotnytext() {
        return prvotnytext;
    }

    public void setPrvodnytext(String prvotnytext) {
        this.prvotnytext = prvotnytext;
    }

    public String getSlovo() {
        return slovo;
    }

    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }
    //Naplnenie pola tak aby sa neopakoval žiadny znak a vymazanie 22 znmaku teda W
    public void naplnpole_cz(String kluc) {
        boolean[] pouzite = new boolean[26];
        int index = 0;


        for (char c : kluc.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                int i = c - 'A';
                if (i >= 0 && i < 26 && !pouzite[i]) {
                    pouzite[i] = true;
                    polechar[index / 5][index % 5] = c;
                    index++;
                }
            }
        }
        pouzite[22] = true;


        for (char c = 'A'; c <= 'Z'; c++) {
            int i = c - 'A';
            if (!pouzite[i]) {
                if (index < 25) {
                    polechar[index / 5][index % 5] = c;
                    index++;
                }
            }
        }


    }
    //Naplnenie pola tak aby sa neopakoval žiadny znak a vymazanie 9 znmaku teda J
    public void naplnpole_en(String kluc) {
        boolean[] pouzite = new boolean[26];
        int index = 0;


        for (char c : kluc.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                int i = c - 'A';
                if (i >= 0 && i < 26 && !pouzite[i]) {
                    pouzite[i] = true;
                    polechar[index / 5][index % 5] = c;
                    index++;
                }
            }
        }
        pouzite[9] = true;


        for (char c = 'A'; c <= 'Z'; c++) {
            int i = c - 'A';
            if (!pouzite[i]) {
                if (index < 25) {
                    polechar[index / 5][index % 5] = c;
                    index++;
                }
            }
        }


    }
    //Funkcia na vypis pola pre gui
    public String vypispoleR() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < polechar.length; i++) {
            for (int j = 0; j < polechar[i].length; j++) {
                sb.append(polechar[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String filtruj_cz(String input) {



        // Normalizer
        input = input.replaceAll("á","A");
        input = input.replaceAll("w","v");
        input = input.replaceAll("ď","D");
        input = input.replaceAll("č","C");
        input = input.replaceAll("é","E");
        input = input.replaceAll("ě","E");
        input = input.replaceAll("í","I");
        input = input.replaceAll("ň","N");
        input = input.replaceAll("ó","O");
        input = input.replaceAll("ř","R");
        input = input.replaceAll("š","S");
        input = input.replaceAll("ť","T");
        input = input.replaceAll("ú","U");
        input = input.replaceAll("ů","U");
        input = input.replaceAll("ý","Y");
        input = input.replaceAll("ž","Z");

        // Zmena Cislic
        input = input.replaceAll("\\p{Punct}", "");
        input = input.replaceAll(" ","XMEZERX");
        input = input.replaceAll("1","XONEX");
        input = input.replaceAll("2","XTWOX");
        input = input.replaceAll("3","XTHREEX");
        input = input.replaceAll("4","XFOURX");
        input = input.replaceAll("5","XFIVEX");
        input = input.replaceAll("6","XSESTX");
        input = input.replaceAll("7","XSEVENX");
        input = input.replaceAll("8","XEIGHTX");
        input = input.replaceAll("9","XNINEX");
        input = input.replaceAll("0","XZEROX");

        StringBuilder output = new StringBuilder();
        //Ošetrenie o ak po filtracií končí na X
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            output.append(input.charAt(i));

            if (i < input.length()-1 && input.charAt(i) == input.charAt(i+1)) {
                if (input.charAt(i) == 'X') {
                    output.append('Y');
                } else {
                    output.append('X');

                }
            }
        }

        output = new StringBuilder(output.toString().toUpperCase());
        //ak nepárne pridá X
        if (output.length() % 2 == 1) {
            if (output.charAt(output.length() - 1) == 'X') {
                output.append('Y');
            } else {
                output.append('X');
            }
        }
        return output.toString().toUpperCase();
    }

    public String filtruj_en(String input) {



        System.out.println("Input into filtruj(): " + input);

        // Normalizer
        input = input.replaceAll("á","A");
        input = input.replaceAll("j","i");
        input = input.replaceAll("ď","D");
        input = input.replaceAll("č","C");
        input = input.replaceAll("é","E");
        input = input.replaceAll("ě","E");
        input = input.replaceAll("í","I");
        input = input.replaceAll("ň","N");
        input = input.replaceAll("ó","O");
        input = input.replaceAll("ř","R");
        input = input.replaceAll("š","S");
        input = input.replaceAll("ť","T");
        input = input.replaceAll("ú","U");
        input = input.replaceAll("ů","U");
        input = input.replaceAll("ý","Y");
        input = input.replaceAll("ž","Z");

        // Zmena Cislic
        input = input.replaceAll("\\p{Punct}", "");
        input = input.replaceAll(" ","XMEZERX");
        input = input.replaceAll("1","XONEX");
        input = input.replaceAll("2","XTWOX");
        input = input.replaceAll("3","XTHREEX");
        input = input.replaceAll("4","XFOURX");
        input = input.replaceAll("5","XFIVEX");
        input = input.replaceAll("6","XSESTX");
        input = input.replaceAll("7","XSEVENX");
        input = input.replaceAll("8","XEIGHTX");
        input = input.replaceAll("9","XNINEX");
        input = input.replaceAll("0","XZEROX");

        StringBuilder output = new StringBuilder();
        //Ošetrenie o ak po filtracií končí na X
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            output.append(input.charAt(i));

            if (i < input.length()-1 && input.charAt(i) == input.charAt(i+1)) {
                if (input.charAt(i) == 'X') {
                    output.append('Y');
                } else {
                    output.append('X');

                }
            }
        }

        output = new StringBuilder(output.toString().toUpperCase());
        //ak nepárne pridá X
        if (output.length() % 2 == 1) {
            if (output.charAt(output.length() - 1) == 'X') {
                output.append('Y');
            } else {
                output.append('X');
            }
        }
        return output.toString().toUpperCase();


    }
    //pridávanie medzier pre gui na výpis po 2 prvkov
    public String pridajmedzery(String input) {
        String resultSM = "";
        String resultBezM = input;
        for (int j = 0; j < input.length(); j++) {
            if (j % 2 == 0 && (j != 0)) {
                resultSM = resultSM + " ";
                resultSM = resultSM + resultBezM.charAt(j);
            } else {
                resultSM = resultSM + resultBezM.charAt(j);
            }
        }
        return resultSM;
    }
    //pridávanie medzier pre gui na výpis po 5 prvkov
    public String pridajmedzerypo5(String imput) {
        String resultSM = "";
        String resultBezM = imput;
        for (int j = 0; j < imput.length(); j++) {
            if (j % 5 == 0 && (j != 0)) {
                resultSM = resultSM + " ";
                resultSM = resultSM + resultBezM.charAt(j);
            } else {
                resultSM = resultSM + resultBezM.charAt(j);
            }
        }
        return resultSM;
    }
    //Šifrovanie posunom v poli
    public String sifrovanie(String imput) {
        imput = imput.replaceAll(" ", "");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < imput.length(); i += 2) {
            char first = imput.charAt(i);
            char second = (i + 1 < imput.length()) ? imput.charAt(i + 1) : 'X';
            if (first == second) {
                second = 'X';
                i--;
            }

            int[] pos1 = getPosition(first);
            int[] pos2 = getPosition(second);

            if (pos1[0] == pos2[0]) {
                result.append(polechar[pos1[0]][(pos1[1] + 1) % 5]);
                result.append(polechar[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                result.append(polechar[(pos1[0] + 1) % 5][pos1[1]]);
                result.append(polechar[(pos2[0] + 1) % 5][pos2[1]]);
            } else {
                result.append(polechar[pos1[0]][pos2[1]]);
                result.append(polechar[pos2[0]][pos1[1]]);
            }
        }

        return result.toString();
    }
    //Funkcia vráti pozíciu charakteru v poli
    private int[] getPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (polechar[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public String desifrovanie(String ciphertext) {
        ciphertext = ciphertext.replaceAll(" ", "");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            char first = ciphertext.charAt(i);
            char second = (i + 1 < ciphertext.length()) ? ciphertext.charAt(i + 1) : 'X';

            int[] pos1 = getPosition(first);
            int[] pos2 = getPosition(second);

            if (pos1[0] == pos2[0]) {
                result.append(polechar[pos1[0]][(pos1[1] + 5 - 1) % 5]);
                result.append(polechar[pos2[0]][(pos2[1] + 5 - 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                result.append(polechar[(pos1[0] + 5 - 1) % 5][pos1[1]]);
                result.append(polechar[(pos2[0] + 5 - 1) % 5][pos2[1]]);
            } else {
                result.append(polechar[pos1[0]][pos2[1]]);
                result.append(polechar[pos2[0]][pos1[1]]);
            }
        }

        for (int i = 0; i < result.length()-2; i++) {
            if (result.charAt(i) ==  result.charAt(i+2) && (result.charAt(i+1) == 'Y' || result.charAt(i+1) == 'X')){
                result.deleteCharAt(i+1);
            }
        }
        if (result.charAt(result.length()-1) == 'Y' && result.charAt(result.length()-2) =='X'){
            result.deleteCharAt(result.length()-1);
        } else if (result.charAt(result.length()-1) =='X' && result.charAt(result.length()-2) =='Y') {
            result.deleteCharAt(result.length()-1);
        }
        result = new StringBuilder(prepis(result.toString()));
        return result.toString();
    }
    //prepis medzier a čisiel pre gui
    public String prepis(String result){
        result = result.replaceAll("XMEZERX", " ");
        result = result.replaceAll("XONEX", "1");
        result = result.replaceAll("XTWOX", "2");
        result = result.replaceAll("XTHREEX", "3");
        result = result.replaceAll("XFOURX", "4");
        result = result.replaceAll("XFIVEX", "5");
        result = result.replaceAll("XSESTX", "6");
        result = result.replaceAll("XSEVENX", "7");
        result = result.replaceAll("XEIGHTX", "8");
        result = result.replaceAll("XNINEX", "9");
        result = result.replaceAll("XZEROX", "0");
        return result;
    }



}
