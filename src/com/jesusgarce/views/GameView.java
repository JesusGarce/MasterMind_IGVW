package com.jesusgarce.views;

import com.jesusgarce.controllers.ProposeController;
import com.jesusgarce.controllers.ResumeController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.jesusgarce.MasterMind.CODE_SIZE;
import static com.jesusgarce.MasterMind.MAX_ATTEMPTS;

public class GameView {
    private boolean playing = true;
    private boolean continuePlaying = true;
    private final ResumeController resumeController;
    private final ProposeController proposeController;

    public GameView(ResumeController resumeController, ProposeController proposeController) {
        this.proposeController = proposeController;
        this.resumeController = resumeController;
    }

    public void interact() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("MASTER MIND");
            System.out.println("----------------------------------------------------------------------------------------------");

            while (playing) {
                printProposedCodesArray();

                System.out.println("Código a descubrir: **** | Intentos restantes: " + (MAX_ATTEMPTS - proposeController.getAttempts()) + " | Dime tu código: ");

                String stringProposedCode = br.readLine();

                if (stringProposedCode.isEmpty() || stringProposedCode.length() != CODE_SIZE)
                    System.out.println("La longitud de tu respuesta no es válida, deben ser 4 caracteres");
                else {
                    if (proposeController.createProposedCode(stringProposedCode)) {
                        proposeController.addAtempt();
                        if (proposeController.isWinner()) {
                            playing = false;
                            System.out.println("¡HAS GANADO! Usaste " + proposeController.getAttempts() + " intentos.");
                        } else
                            playing = proposeController.attemptsRemained();
                    } else
                        System.out.println("Tu respuesta solo debe contenter los caracteres 'R, B, Y, G, O, P' y no puedes repetir ninguno.");
                }

            }

            if (!proposeController.attemptsRemained())
                System.out.println("¡HAS PERDIDO! Consumiste todos tus intentos. La partida se ha acabado. El código era: " + new SecretCodeView(proposeController).print());

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
                resumeController.initialize();
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
        for (int i = 0; i < proposeController.getProposedCodes().size(); i++) {
            ProposedCodeView proposedCodeView = new ProposedCodeView(proposeController.getProposedCodes().get(i));
            ResultView resultView = new ResultView(proposeController.getProposedCodes().get(i).getResult());
            System.out.print("Intento " + (i + 1) + ": ");
            proposedCodeView.print();
            resultView.print();
            System.out.println();
        }
    }


}
