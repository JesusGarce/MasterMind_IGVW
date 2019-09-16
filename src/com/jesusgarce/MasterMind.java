package com.jesusgarce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MasterMind {
    private static final int MAX_ATTEMPTS = 10;
    static final int CODE_SIZE = 4;
    private int attempts;
    private SecretCode secretCode;

    MasterMind() {
        this.attempts = 0;
        this.secretCode = new SecretCode();
    }

    private boolean play(String stringProposedCode) {

        if (stringProposedCode.isEmpty() || stringProposedCode.length() != CODE_SIZE) {
            System.out.println("La longitud de tu respuesta no es válida, deben ser 4 caracteres");
            return false;
        }

        ProposedCode proposedCode = secretCode.checkAndSaveProposedCode(stringProposedCode);

        if (proposedCode.getCode().size() == 0) {
            System.out.println("Tu respuesta solo debe contenter los caracteres 'R, B, Y, G, O, P' en mayúsculas");
            return false;
        }

        if (proposedCode.getResult().isWinner()) {
            attempts++;
            System.out.println("¡HAS GANADO! Usaste " + this.attempts + " intentos.");
            return true;
        } else {
            attempts++;
            System.out.println("Tienes " + proposedCode.getResult().getWoundeds() + " fichas blancas y " + proposedCode.getResult().getDeads() + " fichas rojas. Sigue probando!");
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        MasterMind masterMind = new MasterMind();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean play = true;
        boolean rightAnswer = false;
        boolean playAgain;

        while (play) {
            playAgain = false;
            System.out.println("MASTER MIND");
            System.out.println("----------------------------------------------------------------------------------------------");

            while (!rightAnswer && masterMind.attempts < MAX_ATTEMPTS) {
                System.out.println("Código a descubrir: "+masterMind.secretCode.getSecretCode()+" | Intentos restantes: " + (MAX_ATTEMPTS - masterMind.attempts) + " | Dime tu código: ");
                String stringProposedCode = br.readLine();
                System.out.println("----------------------------------------------------------------------------------------------");

                rightAnswer = masterMind.play(stringProposedCode);

                ArrayList<ProposedCode> proposedCodes = masterMind.secretCode.getProposedCodes();
                for (int i = 0; i < proposedCodes.size(); i++)
                    System.out.println("Intento " + (i + 1) + ": " + proposedCodes.get(i).getCode() + " | Rojas: " + proposedCodes.get(i).getResult().getDeads() + " Blancas: " + proposedCodes.get(i).getResult().getWoundeds());

                System.out.println("----------------------------------------------------------------------------------------------");
            }

            if (masterMind.attempts == MAX_ATTEMPTS && !rightAnswer)
                System.out.println("¡HAS PERDIDO! Consumiste todos tus intentos. La partida se ha acabado.");

            while (!playAgain) {
                System.out.println("¿Quieres jugar otra partida? (Pulsa 'S' para jugar de nuevo y 'N' para quitar el juego)");
                String answer = br.readLine().toUpperCase();
                switch (answer) {
                    case "S":
                        rightAnswer = false;
                        playAgain = true;
                        masterMind = new MasterMind();
                        break;
                    case "N":
                        play = false;
                        playAgain = true;
                        break;
                    default:
                        System.out.println("No he entendido tu respuesta.");
                        break;
                }
            }
        }

    }
}

