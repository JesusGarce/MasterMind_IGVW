package com.jesusgarce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Console {
    private static final int MAX_ATTEMPTS = 10;

    private static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println("\b");
    }

    public static void main(String[] args) throws IOException {
        MasterMind game = new MasterMind();
        boolean play = true;
        boolean rightAnswer = false;
        boolean playAgain;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (play) {
            playAgain = false;

            System.out.println("MASTER MIND");

            System.out.println("----------------------------------------------------------------------------------------------");

            while (!rightAnswer && game.getAttempts() < MAX_ATTEMPTS) {
                //System.out.println("Código a descubrir: " + game.getCode().toString() + " | Intentos restantes: "+(MAX_ATTEMPTS - game.getAttempts()) + " | Dime tu código: ");
                System.out.println("Código a descubrir: **** | Intentos restantes: "+(MAX_ATTEMPTS - game.getAttempts()) + " | Dime tu código: ");

                String attempt = br.readLine();

                System.out.println("----------------------------------------------------------------------------------------------");

                int answer = game.checkAttempt(attempt);

                ArrayList<ArrayList<Token>> attemptsHistory = game.getAttempsCode();
                ArrayList<ArrayList<Integer>>  attemptsTokensHistory = game.getAttempsTokens();
                for (int i = 0; i < attemptsHistory.size(); i++)
                    System.out.println("Intento "+(i+1)+": "+attemptsHistory.get(i).toString() + " | Rojas: " + attemptsTokensHistory.get(i).get(1) + " Blancas: " + attemptsTokensHistory.get(i).get(0));
                System.out.println();

                switch (answer) {
                    case 0:
                        System.out.println("Tienes "+game.getWhiteTokens() + " fichas blancas y "+game.getRedTokens()+" fichas rojas. Sigue probando!");
                        break;
                    case 1:
                        System.out.println("La longitud de tu respuesta no es válida, deben ser 4 caracteres");
                        break;
                    case 2:
                        System.out.println("Tu respuesta solo debe contenter los caracteres 'R, B, Y, G, O, P' en mayúsculas");
                        break;
                    case 3:
                        System.out.println("¡HAS GANADO! Usaste "+game.getAttempts()+" intentos.");
                        rightAnswer = true;
                        break;
                    default:
                        break;
                }
                System.out.println("----------------------------------------------------------------------------------------------");
            }

            if (game.getAttempts() == MAX_ATTEMPTS)
                System.out.println("¡HAS PERDIDO! Consumiste todos tus intentos. La partida se ha acabado.");

            String answer;

            while (!playAgain) {
                System.out.println("¿Quieres jugar otra partida? (Pulsa 'S' para jugar de nuevo y 'N' para quitar el juego)");
                answer = br.readLine().toUpperCase();
                switch (answer) {
                    case "S":
                        rightAnswer = false;
                        playAgain = true;
                        game.restartMasterMind();
                        clearConsole();
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
