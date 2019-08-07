package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dados {

    public static String nome;
    public static int pontos;
    public ArrayList<String> nomes;
    public ArrayList<String> scores;
    boolean podePassar;
    File file;
    FileWriter fw;

    public Dados() throws FileNotFoundException {
        file = new File("scores.txt");
        nomes = new ArrayList<String>();
        scores = new ArrayList<String>();
//        addScores();
        mostra();
    }
/*
    public void addScores() {
        String nomePlayer = new String();
        String scorePlayer = new String();
        Scanner scanner = new Scanner(System.in);
        String linha = new String();
        try {
            scanner = new Scanner(new FileReader(file.getAbsolutePath()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            podePassar = false;
            int i;
            try {
                linha = scanner.nextLine();
                for (i = 0; linha.charAt(i) != ' '; i++) {
                    nomePlayer += linha.charAt(i);
                }
                i++;
                for (; i < linha.length(); i++) {
                    scorePlayer += linha.charAt(i);
                }
                podePassar = true;
            } catch (NullPointerException e) {

            }
            if (podePassar) {
                nomes.add(nomePlayer);
                scores.add(scorePlayer);
            }
            nomePlayer = new String();
            scorePlayer = new String();
        }
    }*/

    public void mostra() {
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i) + scores.get(i));
        }
    }

    public void salvarScore() {
        atualizarScore();
        fw = null;
        String arquivoTexto = new String();
        arquivoTexto += "--scores do jogo GuardiÃµes do EspaÃ§o-- \n";
        for (int i = 0; i < nomes.size(); i++) {
            arquivoTexto += nomes.get(i) + " " + scores.get(i);
            if (i < nomes.size() - 1) {
                arquivoTexto += "\n";
            }
        }
        try {
            fw = new FileWriter(file.getAbsolutePath());
            escrever(arquivoTexto);
        } catch (IOException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escrever(String linha) throws IOException {
        try (BufferedWriter buffWrite = new BufferedWriter(fw)) {
            buffWrite.write(linha);
            buffWrite.newLine();
            buffWrite.flush();
            //buffWrite.close();
        }
    }

    public void atualizarScore() {
        int aux;
        String auxNome = new String();
        for (int i = 0; i < scores.size(); i++) {
            String nn = scores.get(i);
            int au = Integer.parseInt(nn);
            if (pontos >= au) {
                auxNome = nomes.get(i);
                aux = Integer.parseInt(scores.get(i));
                nomes.set(i, nome);
                scores.set(i, Integer.toString(pontos));
                nome = auxNome;
                pontos = aux;
            }
        }
        if (scores.size() < 5) {
            nomes.add(nome);
            scores.add(Integer.toString(pontos));
        }
    }
}
