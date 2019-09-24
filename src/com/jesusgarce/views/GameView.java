package com.jesusgarce.views;

import com.jesusgarce.models.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.jesusgarce.MasterMind.CODE_SIZE;
import static com.jesusgarce.MasterMind.MAX_ATTEMPTS;

public class GameView {
    private Game game;
    private boolean playing = true;
    private boolean continuePlaying = true;

    public GameView(Game game) {
        this.game = game;
    }

    public void interact() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("MASTER MIND");
            System.out.println("----------------------------------------------------------------------------------------------");

            while (playing) {
                printProposedCodesArray();

                System.out.println("Código a descubrir: **** | Intentos restantes: " + (MAX_ATTEMPTS - game.getAttempts()) + " | Dime tu código: ");

                String stringProposedCode = br.readLine();

                if (stringProposedCode.isEmpty() || stringProposedCode.length() != CODE_SIZE)
                    System.out.println("La longitud de tu respuesta no es válida, deben ser 4 caracteres");
                else {
                    if (game.createProposedCode(stringProposedCode)) {
                        game.addAtempt();
                        if (game.isWinner()) {
                            playing = false;
                            System.out.println("¡HAS GANADO! Usaste " + game.getAttempts() + " intentos.");
                        } else
                            playing = game.attemptsRemained();
                    } else
                        System.out.println("Tu respuesta solo debe contenter los caracteres 'R, B, Y, G, O, P' y no puedes repetir ninguno.");
                }

            }

            if (!game.attemptsRemained())
                System.out.println("¡HAS PERDIDO! Consumiste todos tus intentos. La partida se ha acabado. El código era: " + new SecretCodeView(game.getSecretCode()).print());

            continuePlaying = printPlayAgain();

        } while (continuePlaying);
    }

    private boolean printPlayAgain() throws IOException {
        System.out.println("¿Quieres jugar otra partida? (Pulsa 'S' para jugar de nuevo y 'N' para quitar el juego)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine().toUpperCase();
        switch (answer) {
            case "S":
                playing = true;
                game.initialize();
                return true;
            case "N":
                return false;
            default:
                System.out.println("No he entendido tu respuesta.");
                playing = false;
                return true;
        }
    }

    private void printProposedCodesArray() {
        for (int i = 0; i < game.getProposedCodes().size(); i++) {
            ProposedCodeView proposedCodeView = new ProposedCodeView(game.getProposedCodes().get(i));
            ResultView resultView = new ResultView(game.getProposedCodes().get(i).getResult());
            System.out.print("Intento " + (i + 1) + ": ");
            proposedCodeView.print();
            resultView.print();
            System.out.println();
        }
    }


}
